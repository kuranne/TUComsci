// Wirakorn Thanabat
// 6809617415

package one.core.printer;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import one.Resource;

public class Printer implements Resource {
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final String BOLD = "\u001B[1m";
    private static final String RESET = "\u001B[0m";

    public static void println(String txt, boolean flush) {
        out.printf("%s\n", txt);
        if (flush) out.flush();
    }

    public static void printMap(char[][] map) {
        for (char[] row : map) {
            for (char col : row) {
                out.printf("%c ", col);
            }
            out.println();
        }
    }

    public static void turnOf(String type) {
        out.printf("------- %s Turn -------\n", type);
    }

    public static void openingGrid(Dimension dimension) {
        out.printf("Opening Grid %d , %d\n", dimension.getRow(), dimension.getCol());
    }

    public static void showHealtPointOf(String type, int amount) {
        out.printf("%s Life: %d\n", type, amount);
    }

    public static void endGame(char[][] map) {
        out.println("\n------------- Game Ended. All Bombs' Location are -----------");
        printMap(map); out.flush();
    }

    public static void flush() {
        out.flush();
    }

    public static String bold(String txt) {
        return String.format(BOLD + txt + RESET);
    }
}
