package week6;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class random_in {
    private static final Random generator = new Random();
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            out.printf("%d ", generator.nextInt(99));
        }
        out.println();
        out.flush();
    }
}
