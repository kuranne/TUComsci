import java.io.BufferedOutputStream;
import java.io.PrintWriter;
public class StringOperator {
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) {
        String s1 = new String("Hello");
        // String s2 = new String("Hell");
        // String s2 = new String("hEllo");
        // String s2 = new String("Hello");
        String s2 = s1;
        
        out.println(s1 == s2); // Comparing THE REFERENCE (not the text)
        out.println(s1.compareTo(s2)); // Comparing like strcmp in C; return int number
        out.println(s1.equals(s2)); // return ture if all are EXACLY SAME (include case)
        out.println(s1.equalsIgnoreCase(s2)); // same as above but not comparing case

        out.flush();
    }
}