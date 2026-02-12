
import java.io.BufferedOutputStream;
import java.io.PrintWriter;

public class MonsterTest {
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    //
    public static void main(String[] args) {
        Monster mon1 = new Monster(1, 2);
        out.printf("position (%d, %d)\n",
            mon1.getPositionX(),
            mon1.getPositionY()
        );
        out.printf("now is %s\n",
            (mon1.getSleepStatus()) ? "Sleep" : "Awake"
        );
        out.flush();
    }
}
