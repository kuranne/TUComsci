// Wirakorn Thanabat
// 6809617415

package one;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Printer {
    private static final String BOLD = "\u001B[1m";
    private static final String RESET = "\u001B[0m";
    private final PrintWriter out;

    public Printer(OutputStream out) {
        this.out = new PrintWriter(new BufferedOutputStream(out));
    }

    public void println(String txt, boolean flush) {
        out.printf("%s\n", txt);
        if (flush) out.flush();
    }

    public void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                out.printf("%c ", col);
            }
            out.println();
        }
    }

    public void turnOf(String type) {
        out.printf("------- %s Turn -------\n", type);
    }

    public void openingGrid(int row, int col) {
        out.printf("Opening Grid %d , %d\n", row, col);
    }

    public void showHealthPointOf(String type, int amount) {
        out.printf("%s Life: %d\n", type, amount);
    }

    public void endGame(char[][] board) {
        out.println("\n------------- Game Ended. All Bombs' Location are -----------");
        printBoard(board); out.flush();
    }

    public void flush() {
        out.flush();
    }

    public String bold(String txt) {
        return String.format(BOLD + txt + RESET);
    }
}
