// Wirakorn Thanabat
// 6809617415

package store.human;

public class Customer {
    // Variable
    private String name;
    private int spending;

    // Method
    public double calculateDiscount() {
        return (spending >= 2000) ? 0.15 :
            (spending >= 1000) ? 0.10 :
            (spending >= 500) ? 0.05 : 0.0;
    }
    
    // Getter Method
    public String getName() {
        return name;
    }
    public int getSpending() {
        return spending;
    }
    
    // Setter Method
    public void setName(String name) {
        this.name = name;
    }
    public void setSpending (int spending) {
        this.spending = spending;
    }
}
