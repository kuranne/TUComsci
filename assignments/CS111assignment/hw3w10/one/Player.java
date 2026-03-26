// Wirakorn Thanabat
// 6809617415

package one;

import static one.Resource.*;

public abstract class Player implements Selectable {
    // Variable
    private int healthPoint;
    private boolean alive;
    private TYPE playerType;
    private static int deathCount = 0;

    // Constructor
    public Player() {
        healthPoint = INITIAL_HEALT_POINT;
        alive = healthPoint > 0;
    }
    public Player(TYPE playerType) {
        this();
        this.playerType = playerType;
    }

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
    public static int getDeathCount() {
        return deathCount;
    }
    public abstract int getId();

    // Setter & Changer Methods
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
        if (!alive) deathCount++;
    }

    public void setPlayerType(TYPE playerType) {
        this.playerType = playerType;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }
    
    // Other Methods
    public abstract Dimension choose(Dimension range);
}