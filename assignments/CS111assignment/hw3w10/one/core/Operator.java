// Wirakorn Thanabat
// 6809617415

package one.core;

import java.util.ArrayList;
import one.Resource;
import one.core.printer.Printer;
import one.player.ComputerPlayer;
import one.player.PlayerData;
import one.player.RealPlayer;
import one.space.Map;

public class Operator implements Resource {
    // Variables
    private ArrayList<PlayerData> players;
    private Map world;
    private Dimension mapSize;

    // Constructor
    public Operator() {
        players = new ArrayList<>();
        // Request for players (Mocks)
        for (int i = 0; i < REAL_PLAYER_AMOUNT; i++) {
            players.add(new RealPlayer(TYPE.PLAYER));
        }
        for (int i = 0; i < COMPUTER_PLAYER_AMOUNT; i++) {
            players.add(new ComputerPlayer(TYPE.COMPUTER));
        }
        if (rand.nextInt(101) >= 50) {
            players.reversed();
        }

        // Request for Map Size
        Printer.println("Input for row of map", true);
        int row = stdin.nextInt();
        Printer.println("Input for col of map", true);
        int col = stdin.nextInt();

        mapSize = new Dimension(row, col);

        Printer.println(String.format("Mapsize is %dx%d", row, col), false);

        Printer.println("Input for landmine amounts(not less than 5)", true);
        int landmines = stdin.nextInt();
        Printer.println(String.format("Landmine amounts are set to %d", (landmines > MINIMUM_LANDMINE) ? landmines : MINIMUM_LANDMINE), true);

        // Set Map
        world = new Map(mapSize, (landmines > MINIMUM_LANDMINE) ? landmines : MINIMUM_LANDMINE);
    }

    public void start() {
        turn();
        endGame();
    }

    private void turn() {
        // If a player death -> end
        while (PlayerData.getDeathCount() < players.size() - 1) {
            for (int i = 0; i < players.size(); i++) {
                Printer.turnOf(players.get(i).getPlayerTypeString());
                Dimension playerChoice = players.get(i).choose(mapSize);
                
                // Check for out of Range
                try {
                    if (world.isReveal(playerChoice)) {
                        i--; Printer.println(Printer.bold(String.format("Grid %d,%d is already opened. Choose again", playerChoice.getRow(), playerChoice.getCol())), true);
                        continue;
                    } else if (!world.choose(playerChoice)) {
                        players.get(i).reduceHealtPointBy(1);
                    } 
                    } catch (ArrayIndexOutOfBoundsException e) {
                    i--; Printer.println(Printer.bold("Invalid row or column. Choose again"), true);
                    continue;
                }
                
                Printer.openingGrid(playerChoice);
                Printer.printMap(world.getPlayerBoard());
                for (PlayerData player : players) {
                    Printer.showHealtPointOf(player.getPlayerTypeString(), player.getHealtPoint());
                }
            }
        }
    }

    public void endGame() {
        world.revealAll();
        Printer.endGame(world.getPlayerBoard());
    }
}
