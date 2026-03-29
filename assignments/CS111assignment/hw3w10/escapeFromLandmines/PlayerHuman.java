// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

import static escapeFromLandmines.Resource.*;

public class PlayerHuman extends Player {
    // Variables
    private final int id;

    // Constructor
    public PlayerHuman(int id) {
        setPlayerType(TYPE.HUMAN);
        this.id = id;
    }

    // Methods
    @Override
    public Dimension choose(Dimension range) {
        stdout.println("Input row", true);
        int row = stdin.nextInt();
        stdout.println("Input col", true);
        int col = stdin.nextInt();
        return new Dimension(row, col);
    }

    // Getter Methods
    @Override
    public int getId() {
        return id;
    }
}
