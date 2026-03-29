// Wirakorn Thanabat
// 6809617415

package bookStore;

public class Cartoon implements ListableItem {
    private int volumeNO;
    private int dayRented;
    private float price;
    private String name;

    public int getVolumeNO() {
        return volumeNO;
    }
    public int getDayRented() {
        return dayRented;
    }
    public float getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }

    public Cartoon(String name, int volumeNO, int dayRented, float price) {
        this.name = name;
        this.volumeNO = volumeNO;
        this.dayRented = dayRented;
        this.price = price;
    }

    @Override
    public int getCount() {
        return dayRented;
    }

    @Override
    public String getMessage() {
        return String.format("%s vol. %d     price per day : %d rented for:%d days", name, volumeNO, (int)price / 10, dayRented);
    }

    @Override
    public float getTotalPrice() {
        return ((int)price / 10) * dayRented;
    }

    
    
}
