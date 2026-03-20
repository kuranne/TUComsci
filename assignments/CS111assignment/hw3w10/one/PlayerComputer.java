// Wirakorn Thanabat
// 6809617415

package one;

import java.util.HashSet;

public class PlayerComputer extends Player{
    private static final HashSet<Dimension> openedGrid = new HashSet<>();
    public PlayerComputer() {
        setPlayerType(TYPE.COMPUTER);
    }
    @Override
    public Dimension choose(Dimension range) {
        while (true) {
            Dimension nextRandom = new Dimension(rand.nextInt(range.row()), rand.nextInt(range.col()));
            if (openedGrid.contains(nextRandom)) continue;
            openedGrid.add(nextRandom);
            return nextRandom;
        }
    }

    @Override
    public int getId() {
        return -1;
    }
    
}
