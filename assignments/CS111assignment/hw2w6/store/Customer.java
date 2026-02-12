package store;

public class Customer {
    private String name;
    private int spending;
    
    //
    public String getName() {
        return name;
    }
    public int getSpending() {
        return spending;
    }
    
    //
    public void setName(String name) {
        this.name = name;
    }
    public void setSpending(int spending) {
        this.spending = spending;
    }
    
    //
    public double calculateDiscount() {
        if (spending >= 2000) {
            return 0.15;
        } else 
        if (spending >= 1000) {
            return 0.10;
        } else 
        if (spending >= 500) {
            return 0.05;
        } else {
            return 0.00;
        }
    }
}
