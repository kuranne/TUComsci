
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Integer> nextLineInt() {
        ArrayList<Integer> arr = new ArrayList<>();
        stt = new StringTokenizer(nextLine());

        while (stt.hasMoreTokens()) {
            try {
                arr.add(Integer.parseInt(stt.nextToken()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return arr;
    }

    public ArrayList<Double> nextLineDouble() {
        ArrayList<Double> arr = new ArrayList<>();
        stt = new StringTokenizer(nextLine());

        while (stt.hasMoreTokens()) {
            try {
                arr.add(Double.parseDouble(stt.nextToken()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return arr;
    }

}
