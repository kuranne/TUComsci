// Wirakorn Thanabat
// 6809617415

package convenienceStore;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ItemReport {
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private String header;
    private ArrayList<ShoppingItem> items;

    public void addAllItems(ArrayList<ShoppingItem> items) {
        this.items.addAll(items);
    }
    public void addItem(ShoppingItem item) {
        items.add(item);
    }
    public ArrayList<ShoppingItem> itemUnder(float price) {
        return new ArrayList<>(items.stream().filter(item -> item.getPricePerUnit() < price).collect(Collectors.toList()));
    }

    public ItemReport(String header) {
        this.header = header;
        items = new ArrayList<>();
    }

    public void printList() {
        String header = String.format("---------------- %s ----------------", this.header);
        out.println(header);
        int count = 0;
        float totalPrice = 0.0f;
        for (ShoppingItem item : items) {
            out.println(item.getMessage());
            count += item.getCount();
            totalPrice += item.getTotalPrice();
        }
        out.println();
        out.printf("Total Item: %d\n", items.size());
        out.printf("Total Item Count: %d pieces\n", count);
        out.printf("You need to pay: %.0f baht\n", totalPrice);

        String footer = "";
        for (int i = 0 ; i < header.length(); i++) {
            footer += '-';
        }

        out.println(footer);
        ArrayList<ShoppingItem> itemUnder20 = itemUnder(20);
        if (!itemUnder20.isEmpty()) {
            out.println("Item under 20 baht are:");
            for (ShoppingItem item : itemUnder20) {
                out.println(item.getMessage());
            }
        }
        out.flush();
    }
}
