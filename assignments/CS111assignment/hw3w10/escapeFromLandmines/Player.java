// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

import escapeFromLandmines.Model.PlayerType;
import escapeFromLandmines.Model.Vector2;

public abstract class Player implements Selectable {
    // Variable
    private int healthPoint;
    private boolean alive;
    private PlayerType playerType;

    // Constructor
    public Player(int healthPoint) {
        this.healthPoint = healthPoint;
        alive = healthPoint > 0;
    }
    
    // Methods
    public void reduceHealthPointBy(int damage) {
        if (alive) {
            healthPoint -= damage;
            if (healthPoint < 0) {
                healthPoint = 0;
            }
            updateAlive();
        }
    }
    public void updateAlive() {
        alive = healthPoint > 0;
    }
    public abstract Vector2 choose(Vector2 scope);
    
    // Getter Methods
    public int getHealthPoint() {
        return healthPoint;
    }
    public boolean isAlive() {
        return alive;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public String getPlayerTypeString() {
        return playerType.getType();
    }
    public abstract int getId();

    // Setter
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }
}