// Wirakorn Thanabat
// 6809617415

package two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FastInput {
    private final BufferedReader br;
    
    public FastInput(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
