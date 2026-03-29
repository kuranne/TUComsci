// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

import static escapeFromLandmines.Resource.*;

public abstract class Player implements Selectable {
    // Variable
    private int healthPoint;
    private boolean alive;
    private TYPE playerType;

    // Constructor
    public Player() {
        healthPoint = INITIAL_HEALT_POINT;
        alive = healthPoint > 0;
    }
    public Player(TYPE playerType) {
        this();
        this.playerType = playerType;
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
    public abstract Dimension choose(Dimension range);
    
    // Getter Methods
    public int getHealthPoint() {
        return healthPoint;
    }
    public boolean isAlive() {
        return alive;
    }
    public TYPE getPlayerType() {
        return playerType;
    }
    public String getPlayerTypeString() {
        return playerType.getType();
    }
    public abstract int getId();

    // Setter
    public void setPlayerType(TYPE playerType) {
        this.playerType = playerType;
    }
    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }
}