// Wirakorn Thanabat
// 6809617415

package two;

import func.io.FastReader;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;

public class ItemReportTest {
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
    private static final FastReader in = new FastReader(System.in);

    public static void main(String[] args) {
        out.println("What is the name of this shopping list");
        ItemReport cart = new ItemReport(in.nextLine());
        String tmp;
        
        do {
            out.println("Add more items (name;price per unit;count) or exit (e)");
            tmp = in.nextLine();
            if (tmp.equals("e")) break;
            cart.addItem(new ShoppingItem(tmp));
        } while (true);

        cart.printList();
    }
}
