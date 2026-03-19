// Wirakorn Thanabat
// 6809617415

package two;

public class ShoppingItem {
    // Variables
    private String name;
    private float pricePerUnit;
    private int count;

    // Getter Methods
    public float getTotalPrice() {
        return pricePerUnit * count;
    }
    public String getName() {
        return name;
    }
    public float getPricePerUnit() {
        return pricePerUnit;
    }
    public int getCount() {
        return count;
    }
    public ShoppingItem(String itemInfo) {
        int index = itemInfo.indexOf(';');
        name = itemInfo.substring(0, index);
        pricePerUnit = Float.parseFloat(itemInfo.substring(index + 1, index = itemInfo.indexOf(';', index + 1)));
        count = Integer.parseInt(itemInfo.substring(index + 1, itemInfo.length()));
    }
    public String getMessage() {
        return String.format("%-20s price: %-5.1f count:%d items", name, pricePerUnit, count);
    }
}