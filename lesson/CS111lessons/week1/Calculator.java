
import java.io.BufferedOutputStream;
import java.io.PrintWriter;

public class Calculator {
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) {
        Compute solve = new Compute(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        out.println(solve.plus());
        out.flush();
    }

    static class Compute {
        int a;
        int b;

        public Compute(int ia, int ib) {
            a = ia;
            b = ib;
        }

        public int plus() {
            return a + b;
        }

        public int minus() {
            return a - b;
        }

        public int multi() {
            return a * b;
        }

        public int divide() {
            return a / b;
        }
        
        public int modulo() {
            return a % b;
        }
    }
}
