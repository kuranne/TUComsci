// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

import escapeFromLandmines.Model.PlayerType;
import escapeFromLandmines.Model.Vector2;

import java.util.HashSet;
import java.util.Random;

public class PlayerComputer extends Player {
    // Variables
    private static final Random rand = new Random();
    private static final HashSet<Vector2> openedCoordinate = new HashSet<>();

    // Constructor
    public PlayerComputer(int healthPoint) {
        super(healthPoint);
        setPlayerType(PlayerType.COMPUTER);
    }

    // Methods
    @Override
    public Vector2 choose(Vector2 scope) {
        Vector2 nextCoordinate;
        do {
            nextCoordinate = new Vector2(rand.nextInt(scope.row()), rand.nextInt(scope.col()));
        } while (openedCoordinate.contains(nextCoordinate));
        
        openedCoordinate.add(nextCoordinate);
        return nextCoordinate;
    }

    public static void resetMemory() {
        openedCoordinate.clear();
    }

    // Getter Methods
    @Override
    public int getId() {
        return -1;
    }
    
}
