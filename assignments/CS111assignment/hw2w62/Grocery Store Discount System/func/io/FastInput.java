// Wirakorn Thanabat
// 6809617415

package func.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastInput {
    BufferedReader br;
    StringTokenizer stt;

    public FastInput(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
        stt = new StringTokenizer("");
    }

    public String next() {
        while (!stt.hasMoreTokens()) {
            try {
                stt = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return stt.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    
}
