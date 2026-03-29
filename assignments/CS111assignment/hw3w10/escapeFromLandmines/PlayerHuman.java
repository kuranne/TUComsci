// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

import escapeFromLandmines.Model.PlayerType;
import escapeFromLandmines.Model.Vector2;

public class PlayerHuman extends Player {
    // Variables    
    private final int id;

    // Constructor
    public PlayerHuman(int healthPoint, int id) {
        super(healthPoint);
        setPlayerType(PlayerType.HUMAN);
        this.id = id;
    }

    // Methods
    @Override
    public Vector2 choose(Vector2 scope) {
        return scope;
    }

    // Getter Methods
    @Override
    public int getId() {
        return id;
    }
}
