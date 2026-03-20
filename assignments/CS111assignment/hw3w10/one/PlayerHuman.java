// Wirakorn Thanabat
// 6809617415

package one;

public class PlayerHuman extends Player {
    private final int id;
    private static int total_id = 0;
    public PlayerHuman() {
        setPlayerType(TYPE.HUMAN);
        id = total_id;
        total_id++;
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

    // Getter Methods
    @Override
    public int getId() {
        return id;
    }

}
