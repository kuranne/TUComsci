// Wirakorn Thanabat
// 6809617415

package bookStore;

import java.util.Scanner;

public class ItemReport2Test {

    public static void main(String[] args) {
        ItemReport2 rentingList = new ItemReport2("Book rental list");
        ListableItem novel1 = new Novel("Twilight", 2);
        ListableItem cartoon1 = new Cartoon("Bleach", 30, 2, 35);
        ListableItem novel2 = new Novel("The wheel of time", 5);
        ListableItem cartoon2 = new Cartoon("One Piece", 50, 1, 45);
        ListableItem novel3 = new Novel("Digital Fortress", 3);
        rentingList.addItem(novel1);
        rentingList.addItem(cartoon1);
        rentingList.addItem(novel2);
        rentingList.addItem(cartoon2);
        rentingList.addItem(novel3);
        rentingList.printList();
    }
}
