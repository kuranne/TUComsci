import io.FastInput;
import store.*;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

public class StoreTest {
    private static final FastInput in = new FastInput(System.in);
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        out.print("Enter the number of customers: "); out.flush();
        Cashier opeCashier = new Cashier(in.nextInt());
        out.println();

        for (int i = 0; i < opeCashier.amountOfCustomers; i++) {
            out.printf("Enter the name of customers %d: ", i + 1); out.flush();
            final String name = in.next();
            out.println();

            out.printf("Enter the spending amount for %s: ", name); out.flush();
            final int amount = in.nextInt();
            opeCashier.bill(name, amount, i);

            out.printf("%s paid %.2f Baht\n\n\n", opeCashier.nameOf(i), opeCashier.payFor(i)); out.flush();
        }
    }
}
