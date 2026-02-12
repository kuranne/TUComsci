// Wirakorn Thanabat
// 6809617415

package store.service;

import func.io.FastInput;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import store.human.Customer;

public class Cashier {
    private static final FastInput in = new FastInput(System.in);
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    // Variable
    private static int numberOfCustomer = 0;

    // Constructor
    public Cashier() {
        out.print("Enter the number of customers: "); out.flush();
        Cashier.numberOfCustomer = in.nextInt();
    }

    // Method
    public void cashing() {
        for (int i = 0; i < numberOfCustomer; i++) {
            out.printf("%s", (i == 0) ? "\n" : "\n\n\n\n");
            out.printf("Enter the name of customer %d: ", i + 1); out.flush();
            String name = in.next();
            out.printf("\nEnter the spending amount for %s: ", name); out.flush();
            int spending = in.nextInt();
            out.printf("\n%s paid %,.2f Baht", name, nextCustomerPayment(name, spending)); out.flush();
        }
        out.println(); out.flush();
    }

    public double nextCustomerPayment(String name, int spending) {
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setSpending(spending);
        return newCustomer.getSpending() * (1 - newCustomer.calculateDiscount());
    }

}
