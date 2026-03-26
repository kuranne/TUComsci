// Wirakorn Thanabat
// 6809617415

package one;

import java.util.HashSet;
import static one.Resource.*;

public class PlayerComputer extends Player {
    private static final HashSet<Dimension> openedPositions = new HashSet<>();
    public PlayerComputer() {
        setPlayerType(TYPE.COMPUTER);
    }

    public Dimension choose(Dimension range) {
        Dimension nextRandom;
        do {
            nextRandom = new Dimension(rand.nextInt(range.row()), rand.nextInt(range.col()));
        } while (openedPositions.contains(nextRandom));
        
        openedPositions.add(nextRandom);
        return nextRandom;
    }

    @Override
    public int getId() {
        return -1;
    }
    
}
