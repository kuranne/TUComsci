package store;

import java.util.ArrayList;

public class Cashier {
    public final int amountOfCustomers;
    private static final ArrayList<Customer> customers = new ArrayList<>();

    public Cashier(int amountOfCustomers) {
        this.amountOfCustomers = amountOfCustomers;
    }

    public void bill(String name, int amount, int index) {
        customers.add(new Customer());
        customers.get(index).setName(name);
        customers.get(index).setSpending(amount);
    }
    public String nameOf(int index) {
        return customers.get(index).getName();
    }
    public double payFor(int index) {
        return customers.get(index).getSpending() * (1 - customers.get(index).calculateDiscount());
    }
}
