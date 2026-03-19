// Wirakorn Thanabat
// 6809617415

package one;

import func.io.FastReader;
import java.util.Random;

public interface Resource {
    // Constant
    public static final int MINIMUM_LANDMINE = 5;
    public static final int INITIAL_HEALT_POINT = 3;
    public static final int REAL_PLAYER_AMOUNT = 1;
    public static final int COMPUTER_PLAYER_AMOUNT = 1;
    public static final int BLAST_DAMAGE = 1;

    public static final Random rand = new Random();
    public static final FastReader stdin = new FastReader(System.in);

    // Enums
    // Object would use in Map
    public enum OBJECTS {
        NONE('-'),
        LANDMINE('b');

        char description;

        private OBJECTS(char description) {
            this.description = description;
        }
        public boolean isSafe() {
            return this.description == '-';
        }
        public char getChar() {
            return description;
        }
    }
    // Type of player
    public enum TYPE {
        PLAYER("Player"),
        COMPUTER("Computer"),
        OTHER("Other");
        
        private final String description;

        TYPE(String description) {
            this.description = description;
        }

        public String getType() {
            return description;
        }
    }

    // Record
    public record Dimension(int row, int col) {
        public int getRow() {
            return row;
        }
        public int getCol() {
            return col;
        }
    }
    
}
