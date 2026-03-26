// Wirakorn Thanabat
// 6809617415

package one;

import static one.Resource.*;

public class PlayerHuman extends Player {
    private final int id;
    private static int totalId = 0;
    public PlayerHuman() {
        setPlayerType(TYPE.HUMAN);
        id = totalId;
        totalId++;
    }

    public Dimension choose(Dimension range) {
        Printer.println("Input row", true);
        int row = stdin.nextInt();
        Printer.println("Input col", true);
        int col = stdin.nextInt();
        return new Dimension(row, col);
    }

    // Getter Methods
    @Override
    public int getId() {
        return id;
    }

}
