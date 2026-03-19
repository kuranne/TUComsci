// Wirakorn Thanabat
// 6809617415

package three;

public class Novel implements ListableItem {
    // Variables
    private String name;
    private int dayRented;

    // Getter Methods
    @Override
    public float getTotalPrice() {
        return dayRented * 7;
    }
    public String getName() {
        return name;
    }
    @Override
    public int getCount() {
        return dayRented;
    }
    
    public Novel(String name, int dayRented) {
        this.name = name;
        this.dayRented = dayRented;
    }
    @Override
    public String getMessage() {
        return String.format("%s     price per day: %d rented for: %d days", name, 7, dayRented);
    }
}