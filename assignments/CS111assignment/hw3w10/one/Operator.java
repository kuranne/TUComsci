// Wirakorn Thanabat
// 6809617415
package one;

import java.util.ArrayList;

import one.Resource.Dimension;
import one.Resource.TYPE;

import static one.Resource.*;

public class Operator {
    // Variables
    private static final String SELECT_TEXT = """
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
        while (true) {
            if (!MINIMAL_MODE) {
                stdout.println(SELECT_TEXT, true);
                selectSetting();
                stdout.println(String.format(
                    "boardSize is %dx%d", 
                    boardSize.row(), 
                    boardSize.col()), 
                    false
                );
                stdout.println(String.format(
                    "Landmine amounts are set to %d", 
                    world.getAmountOfLandmines()), 
                    true
                );
            } else {
                setBoardAndPlayer();
            }
            try {
                if (isValidBoardCreated())
                    break;
            } catch (InvalidBoardInitializeException e) {
                stdout.println(e.toString(), true);
            }
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
        // Process turn for each alive player
        for (Player player : players) {
            if (!player.isAlive()) {
                continue;
            }
            processSinglePlayerTurn(player);

            if (!runCondition()) {
                break;
            }
        }
    }

    private void processSinglePlayerTurn(Player player) {
        boolean validMove = false;

        while (!validMove) {
            String turnLabel = getTurnLabel(player);
            stdout.turnOf(turnLabel);

            Dimension playerChoice = player.choose(boardSize);

            if (!isValidCoordinate(playerChoice)) {
                stdout.println(
                    stdout.bold("Invalid row or column. Choose again"), 
                    true);
                continue;
            }

            // Check if grid is already opened
            if (world.isReveal(playerChoice)) {
                stdout.println(
                    stdout.bold(
                        String.format(
                            "Grid %d,%d is already opened. Choose again", 
                            playerChoice.row(), 
                            playerChoice.col()
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

            stdout.openingGrid(playerChoice.row(), playerChoice.col());
            stdout.printBoard(world.getPlayerBoard());

            for (Player p : players) {
                stdout.showHealthPointOf(p.getPlayerTypeString(), p.getHealthPoint());
            }
        }
    }

    public void endGame() {
        world.revealAll();
        stdout.endGame(world.getPlayerBoard());
    }

    // Validate
    private boolean isValidCoordinate(Dimension choice) {
        return choice.row() >= 0 && choice.row() < boardSize.row()
                && choice.col() >= 0 && choice.col() < boardSize.col();
    }
    private boolean isValidBoardCreated() throws InvalidBoardInitializeException {
        if (boardSize.area() < world.getAmountOfLandmines()) {
            throw new InvalidBoardInitializeException("Board's grids area must be more than landmines");
        }
        return true;
    }

    private boolean runCondition() {
        return (Player.getDeathCount() < players.size() - (players.size() > 1 ? 1 : 0) 
        && (MINIMAL_MODE || !world.isOutOfLandmine()));
    }

    private int allowanceLandmines(int landmines) {
        return Math.max(landmines, MINIMUM_LANDMINE);
    }

    private String getTurnLabel(Player player) {
        boolean isComputer = player.getPlayerType() == TYPE.COMPUTER;
        boolean isOnlyOneHuman = countHumanPlayers() == 1;
        return (isComputer || isOnlyOneHuman) 
            ? player.getPlayerTypeString()
            : String.format("Human ID: %d", player.getId());
    }

    private long countHumanPlayers() {
        return players.stream().filter(p -> p.getPlayerType() == TYPE.HUMAN).count();
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
                stdout.println(stdout.bold("Please Select one of them"), true);
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
        world = new Board(boardSize, boardSize.area() / 5);
    }

    private void defaultSetting() {
        setDefaultPlayer();
        setDefaultBoard();
    }

    // Custom setting
    private void setCustomPlayer() {
        try {
            stdout.println("Input for Number of Human Players", true);
            setPlayer(TYPE.HUMAN, stdin.nextInt());
            stdout.println("Input for Number of Computer Players", true);
            setPlayer(TYPE.COMPUTER, stdin.nextInt());
            stdout.println("Input for Health of Players", true);
            int Health = stdin.nextInt();
            for (Player player : players) {
                player.setHealthPoint(Health);
            }
        } catch (NumberFormatException e) {
            stdout.println("Failed to parse int, use default setting instread", true);
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
        stdout.println("Input for row of Board", true);
        int row = stdin.nextInt();
        stdout.println("Input for colum of Board", true);
        int col = stdin.nextInt();
        return boardSize = new Dimension(row, col);
    }

    private int getCustomLandmineAmount() {
        stdout.println(
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
