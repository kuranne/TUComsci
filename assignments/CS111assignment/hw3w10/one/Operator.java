// Wirakorn Thanabat
// 6809617415
package one;

import java.util.ArrayList;

public class Operator implements Resource {

    // Variables
    private final String selectTxt = """
Select one of
1. Start the game with default setting
2. Set players and Board size before start""";
    private final ArrayList<Player> players;
    private Board world;
    private Dimension boardSize;

    // Constructor
    public Operator() {
        players = new ArrayList<>();
    }

    // Setup
    public void setupGame() {
        if (!MINIMAL_MODE) {
            Printer.println(selectTxt, true);
            selectSetting();
            Printer.println(String.format(
                "boardSize is %dx%d", 
                boardSize.getRow(), 
                boardSize.getCol()), 
                false
            );
            Printer.println(String.format(
                "Landmine amounts are set to %d", 
                world.getAmountOfLandmines()), 
                true
            );
        } else {
            setBoardAndPlayer();
        }
        world.setupBoard();
    }

    // Flow
    public void run() {
        setupGame();
        // Loop until not in Condition
        while (runCondition()) {
            playersRound();
        }
        endGame();
    }

    private void playersRound() {
        // For each player
        for (Player nowPlayer : players) {
            if (!nowPlayer.isAlive()) {
                continue; // That is alive
            }
            processSinglePlayerTurn(nowPlayer); // Give their turn

            if (!runCondition()) {
                break;
            }
        }
    }

    private void processSinglePlayerTurn(Player player) {
        boolean validMove = false;

        while (!validMove) {
            Printer.turnOf((MINIMAL_MODE || player.getId() == -1)
                    ? player.getPlayerTypeString()
                    : String.format(
                        "Human ID: %d", 
                        player.getId())
            );

            Dimension playerChoice = player.choose(boardSize);

            if (!isValidCoordinate(playerChoice)) {
                Printer.println(
                    Printer.bold("Invalid row or column. Choose again"), 
                    true);
                continue;
            }

            // Chick a grid if close -> said no
            if (world.isReveal(playerChoice)) {
                Printer.println(
                    Printer.bold(
                        String.format(
                            "Grid %d,%d is already opened. Choose again", 
                            playerChoice.getRow(), 
                            playerChoice.getCol()
                        )
                    ), 
                true
            );
                continue;
            }

            validMove = true;
            if (!world.choose(playerChoice)) {
                player.reduceHealthPointBy(1);
            }

            Printer.openingGrid(playerChoice);
            Printer.printBoard(world.getPlayerBoard());

            for (Player p : players) {
                Printer.showHealthPointOf(p.getPlayerTypeString(), p.getHealthPoint());
            }
        }
    }

    public void endGame() {
        world.revealAll();
        Printer.endGame(world.getPlayerBoard());
    }

    // Validate
    private boolean isValidCoordinate(Dimension choice) {
        return choice.getRow() >= 0 && choice.getRow() < boardSize.getRow()
                && choice.getCol() >= 0 && choice.getCol() < boardSize.getCol();
    }

    private boolean runCondition() {
        return (Player.getDeathCount() < players.size() - (players.size() > 1 ? 1 : 0) 
        && (MINIMAL_MODE || !world.isOutOfLandmine()));
    }

    private int allowanceLandmines(int landmines) {
        return Math.max(landmines, MINIMUM_LANDMINE);
    }

    private void selectSetting() {
        switch (stdin.nextInt()) {
            case 1 -> {
                defaultSetting();
            }
            case 2 -> {
                customSetting();
            }
            default -> {
                Printer.println(Printer.bold("Please Select one of them"), true);
                selectSetting();
            }
        }
    }

    // Special Methods
    private void setBoardAndPlayer() {
        setDefaultPlayer();
        world = new Board(boardSize = getCustomboardSize(), allowanceLandmines(getCustomLandmineAmount()));
    }

    // Default setting
    private void setDefaultPlayer() {
        players.clear();
        setPlayer(TYPE.HUMAN, HUMAN_PLAYER_AMOUNT);
        setPlayer(TYPE.COMPUTER, COMPUTER_PLAYER_AMOUNT);
    }

    private void setDefaultBoard() {
        boardSize = BOARD_SIZE;
        world = new Board(boardSize, boardSize.getArea() / 5);
    }

    private void defaultSetting() {
        setDefaultPlayer();
        setDefaultBoard();
    }

    // Custom setting
    private void setCustomPlayer() {
        try {
            Printer.println("Input for Number of Human Players", true);
            setPlayer(TYPE.HUMAN, stdin.nextInt());
            Printer.println("Input for Number of Computer Players", true);
            setPlayer(TYPE.COMPUTER, stdin.nextInt());
            Printer.println("Input for Health of Players", true);
            int Health = stdin.nextInt();
            for (Player player : players) {
                player.setHealthPoint(Health);
            }
        } catch (NumberFormatException e) {
            Printer.println("Failed to parse int, use default setting instread", true);
            setDefaultPlayer();
        }
    }

    private void setCustomBoard() {
        world = new Board(getCustomboardSize(), getCustomLandmineAmount());
    }

    private void customSetting() {
        // Requesting for Player
        setCustomPlayer();
        // Requesting for Board
        setCustomBoard();
    }

    // Getter Methods
    private Dimension getCustomboardSize() {
        Printer.println("Input for row of Board", true);
        int row = stdin.nextInt();
        Printer.println("Input for colum of Board", true);
        int col = stdin.nextInt();
        return boardSize = new Dimension(row, col);
    }

    private int getCustomLandmineAmount() {
        Printer.println(
            String.format(
                "Input for landmine amounts %s", 
                (MINIMAL_MODE) ? "(not less than 5)" : ""
            ), 
            true
        );
        return stdin.nextInt();
    }

    // Setter Methods
    private void setPlayer(TYPE type, int amount) {
        for (int i = 0; i < amount; i++) {
            players.add(
                ((type == TYPE.HUMAN) 
                ? new PlayerHuman() 
                : new PlayerComputer())
            );
        }
    }
}
