// Wirakorn Thanabat
// 6809617415

package one.player;

import one.Resource;

public abstract class PlayerData implements Resource {
    // Vairiable
    private int healtPoint;
    private boolean alive;
    private TYPE playerType;
    private static int deathCount = 0;

    // Contructor;
    public PlayerData() {
        healtPoint = INITIAL_HEALT_POINT;
        alive = healtPoint > 0;
    }
    public PlayerData(TYPE playerType) {
        this();
        this.playerType = playerType;
    }

    // Getter Methods
    public int getHealtPoint() {
        return healtPoint;
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

    // Setter & Changer Methods
    public void reduceHealtPointBy(int healtPoint) {
        if (alive) {
            this.healtPoint -= healtPoint;
            updateAlive();
        }

        if (healtPoint < 0) {
            this.healtPoint = 0;
        }
    }
    
    public void updateAlive() {
        alive = healtPoint > 0;
        if (!alive) deathCount++;
    }

    public void setPlayerType(TYPE playerType) {
        this.playerType = playerType;
    }
    

    // Other Methods
    public abstract Dimension choose(Dimension range);
}