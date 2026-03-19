// Wirakorn Thanabat
// 6809617415

package one.player;

import one.core.printer.Printer;

public class RealPlayer extends PlayerData {
    public RealPlayer(TYPE playerType) {
        setPlayerType(playerType);
    }

    @Override
    public Dimension choose(Dimension range) {
        int row, col;
        Printer.println("Input row", true);
        row = stdin.nextInt();
        Printer.println("Input col", true);
        col = stdin.nextInt();
        Dimension pos = new Dimension(row, col);
        return pos;
    }
}
