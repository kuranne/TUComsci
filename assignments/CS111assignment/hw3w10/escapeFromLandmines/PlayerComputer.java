// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

import static escapeFromLandmines.Resource.*;

import java.util.HashSet;

public class PlayerComputer extends Player {
    // Variables
    private static final HashSet<Dimension> openedPositions = new HashSet<>();

    // Constructor
    public PlayerComputer() {
        setPlayerType(TYPE.COMPUTER);
    }

    // Methods
    @Override
    public Dimension choose(Dimension range) {
        Dimension nextRandom;
        do {
            nextRandom = new Dimension(rand.nextInt(range.row()), rand.nextInt(range.col()));
        } while (openedPositions.contains(nextRandom));
        
        openedPositions.add(nextRandom);
        return nextRandom;
    }

    // Getter Methods
    @Override
    public int getId() {
        return -1;
    }
    
}
