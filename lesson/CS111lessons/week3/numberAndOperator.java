
import java.io.BufferedOutputStream;
import java.io.PrintWriter;

public class numberAndOperator {
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int decimal = 123;
        int binary = 0b01111011;
        int heximal = 0173;
        int octimal = 0x7B;

        out.printf("%d %d %d %d\n",
            decimal,
            binary,
            heximal,
            octimal
        );
        out.flush();
    }
}
