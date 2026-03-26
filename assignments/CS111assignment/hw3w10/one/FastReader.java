// Wirakorn Thanabat
// 6809617415

package one;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FastReader {
    private final int BUF_SIZE = 1 << 16;
    private final DataInputStream in;
    private final byte[] buf;
    private int bufPointer, bytesRead;

    public FastReader(InputStream in) {
        this.in = new DataInputStream(in);
        buf = new byte[BUF_SIZE];
        bufPointer = bytesRead = 0;
    }

    public int nextInt() {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();

        boolean neg = c == '-';
        if (neg) c = read();
        do { 
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        
        return neg ? -ret : ret;
    }

    private byte read() {
        if (bytesRead == bufPointer) fillBuf();
        return buf[bufPointer++];
    }

    private void fillBuf() {
        try {
            bytesRead = in.read(buf, bufPointer = 0, BUF_SIZE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (bytesRead == 0) buf[0] = -1;
    }
}