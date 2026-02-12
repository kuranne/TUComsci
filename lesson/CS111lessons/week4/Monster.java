public class Monster {
    private final double BASE_EYE_SIGHT = 5.0;
    private boolean isSleep;
    private int positionX;
    private int positionY;
    private double eyeSight;
    private long expPoint;
    
    // Constructor
    public Monster() {
        eyeSight = BASE_EYE_SIGHT;
        positionX = 0;
        positionY = 0;
        isSleep = true;
        expPoint = 0L;
    }
    // Overloading Constructor
    public Monster(int positionX, int positionY) {
        this();
        this.positionX = positionX;
        this.positionY = positionY;
    }

    // get status
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public double getEyeSight() {
        return eyeSight;
    }
    public long getExpPoint() {
        return expPoint;
    }
    public boolean getSleepStatus() {
        return isSleep;
    }

}