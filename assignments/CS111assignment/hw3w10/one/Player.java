// Wirakorn Thanabat
// 6809617415

package one;

public abstract class Player implements Resource {
    // Vairiable
    private int HealthPoint;
    private boolean alive;
    private TYPE playerType;
    private static int deathCount = 0;

    // Contructor;
    public Player() {
        HealthPoint = INITIAL_HEALT_POINT;
        alive = HealthPoint > 0;
    }
    public Player(TYPE playerType) {
        this();
        this.playerType = playerType;
    }

    // Getter Methods
    public int getHealthPoint() {
        return HealthPoint;
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
    public void reduceHealthPointBy(int HealthPoint) {
        if (alive) {
            this.HealthPoint -= HealthPoint;
            updateAlive();
        }

        if (HealthPoint < 0) {
            this.HealthPoint = 0;
        }
    }
    
    public void updateAlive() {
        alive = HealthPoint > 0;
        if (!alive) deathCount++;
    }

    public void setPlayerType(TYPE playerType) {
        this.playerType = playerType;
    }

    public void setHealthPoint(int HealthPoint) {
        this.HealthPoint = HealthPoint;
    }
    
    // Other Methods
    public abstract Dimension choose(Dimension range);
}