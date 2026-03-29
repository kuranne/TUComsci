// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

import static escapeFromLandmines.Constants.*;
import escapeFromLandmines.Model.Vector2;
import escapeFromLandmines.Model.PlayerType;
import escapeFromLandmines.GameException.*;

import java.util.ArrayList;

public class Operator {
    // Variables
    private static final Printer stdout = new Printer(System.out);
    private static final FastReader stdin = new FastReader(System.in);

    private static final String SELECT_TEXT = """
            Select one of
            1. Start the game with default setting
            2. Set players and Board size before start""";
    private ArrayList<Player> players;
    private Board world;
    private Vector2 boardScope;

    // Constructor
    public Operator() {
        players = new ArrayList<>();
    }

    // Setup game
    // Set Player(non-minimal_mode), board's size and amount of landmines
    public void setupGame() {
        boolean boardInited = false;
        do {
            players.clear();
            PlayerComputer.resetMemory();
            try {
                if (!MINIMAL_MODE) {
                    stdout.println(SELECT_TEXT, true);
                    selectSettingMethod();
                    stdout.println(String.format(
                            "boardScope is %dx%d",
                            boardScope.row(),
                            boardScope.col()),
                            false);
                    stdout.println(String.format(
                            "Landmine amounts are set to %d",
                            world.getAmountOfLandmines()),
                            true);
                } else {
                    setBoardAndPlayer();
                }
                if (isValidBoardCreated()) boardInited = true;
                world.setupBoard();

                // When Finish Board Init -> Next

            } catch (RuntimeException e) {
                if (e instanceof InvalidBoardInitializeException) {
                    stdout.println(stdout.bold(e.getMessage()), true);
                    continue;
                }
                throw e;
            }
        } while (!boardInited);
    }

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
            try {
                String turnLabel = getTurnLabel(player);
                if (MINIMAL_MODE && turnLabel.equals(PlayerType.HUMAN.getType()))
                    turnLabel = "Player";
                stdout.turnOf(turnLabel);

                Vector2 playerChoice = player.choose((player.getPlayerType() == PlayerType.COMPUTER)? boardScope: inputCoordinate());

                isValidCoordinate(playerChoice);

                // Check if grid is already opened
                if (world.isReveal(playerChoice)) {
                    stdout.println(
                            stdout.bold(
                                    String.format(
                                            "Grid %d,%d is already opened. Choose again",
                                            playerChoice.row(),
                                            playerChoice.col())),
                            true);
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
            } catch (RuntimeException e) {
                if (e instanceof InvalidGamePlayException) {
                    stdout.println(stdout.bold(e.getMessage()), true);
                    continue;
                }
                if (e instanceof ArrayIndexOutOfBoundsException) {
                    stdout.println(stdout.bold("Something wrong..."), true);
                    continue;
                }
                throw e;
            }
        }
    }
    public void endGame() {
        world.revealAll();
        stdout.endGame(world.getPlayerBoard());
    }
    private void selectSettingMethod() {
        boolean pass = false;
        do {
            switch (stdin.nextInt()) {
                case 1 -> {
                    defaultSetting();
                    pass = true;
                }
                case 2 -> {
                    customSetting();
                    pass = true;
                }
                default -> {
                    stdout.println(stdout.bold("Please Select one of them"), true);
                }
            }
        } while (!pass);
    }

    // Methods
    private int allowanceLandmines(int landmines) {
        return Math.max(landmines, MINIMUM_LANDMINE);
    }
    private long countHumanPlayers() {
        return players.stream().filter(p -> p.getPlayerType() == PlayerType.HUMAN).count();
    }
    private boolean runCondition() {
        return (getPlayerDeathCount() < players.size() - (players.size() > 1 ? 1 : 0)
                && (MINIMAL_MODE || !world.isOutOfLandmine()));
    }
    private Vector2 inputCoordinate() {
        stdout.println("Input row", true);
        int row = stdin.nextInt();
        stdout.println("Input col", true);
        int col = stdin.nextInt();
        return new Vector2(row, col);
    }
    private int inputCustomLandmineAmount() {
        stdout.println(
                String.format(
                        "Input for landmine amounts %s",
                        (MINIMAL_MODE) ? "(not less than 5)" : ""),
                true);
        return stdin.nextInt();
    }

    // Special Methods
    private void setBoardAndPlayer() {
        setDefaultPlayer();
        stdout.println(stdout.bold("Input for row and column of Board"), true);
        world = new Board(boardScope = inputCoordinate(), allowanceLandmines(inputCustomLandmineAmount()));
    }

    // Default setting
    private void setDefaultPlayer() {
        setPlayer(PlayerType.HUMAN, HUMAN_PLAYER_AMOUNT);
        setPlayer(PlayerType.COMPUTER, COMPUTER_PLAYER_AMOUNT);
    }

    private void setDefaultBoard() {
        boardScope = BOARD_SIZE;
        world = new Board(boardScope, boardScope.area() / 5);
    }

    private void defaultSetting() {
        setDefaultPlayer();
        setDefaultBoard();
    }

    // Custom setting
    private void setCustomPlayer() {
        try {
            stdout.println("Input for Number of Human Players", true);
            setPlayer(PlayerType.HUMAN, stdin.nextInt());
            stdout.println("Input for Number of Computer Players", true);
            setPlayer(PlayerType.COMPUTER, stdin.nextInt());
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
        stdout.println(stdout.bold("Input for row and column of Board"), true);
        world = new Board(boardScope = inputCoordinate(), inputCustomLandmineAmount());
    }

    private void customSetting() {
        setCustomPlayer();
        setCustomBoard();
    }

    // Validate
    // isValidCoordinate check for player' choose grid that
    // Row & Col must be more than or equal to 0 and less that the board size
    private boolean isValidCoordinate(Vector2 choice) {
        if (!(isValidRowNumber(choice.row()) || isValidColNumber(choice.col())))
            throw new InvalidGamePlayException("Invalid row and column. Choose again");
        if (!isValidRowNumber(choice.row()))
            throw new InvalidGamePlayException("Invalid row. Choose again");
        if (!isValidColNumber(choice.col()))
            throw new InvalidGamePlayException("Invalid column. Choose again");
        return true;
    }

    private boolean isValidBoardCreated() throws InvalidBoardInitializeException {
        if (boardScope.area() < world.getAmountOfLandmines()) {
            throw new InvalidBoardInitializeException("Board's grids area must exceed landmines");
        }
        return true;
    }

    private boolean isValidRowNumber(int row) {
        return row >= 0 && row < boardScope.row();
    }

    private boolean isValidColNumber(int col) {
        return col >= 0 && col < boardScope.col();
    }

    // Getter Methods
    private String getTurnLabel(Player player) {
        boolean isComputer = player.getPlayerType() == PlayerType.COMPUTER;
        boolean isOnlyOneHuman = countHumanPlayers() == 1;
        return (isComputer || isOnlyOneHuman)
                ? player.getPlayerTypeString()
                : String.format("Human ID: %d", player.getId());
    }

    private int getPlayerDeathCount() {
        return (int) players.stream().filter(p -> !p.isAlive()).count();
    }

    // Setter Methods
    private void setPlayer(PlayerType type, int amount) {
        for (int i = 0; i < amount; i++) {
            players.add(
                    ((type == PlayerType.HUMAN)
                            ? new PlayerHuman(INITIAL_HEALTH_POINT, i)
                            : new PlayerComputer(INITIAL_HEALTH_POINT)));
        }
    }
}
