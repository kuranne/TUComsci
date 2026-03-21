// Wirakorn Thanabat
// 6809617415

package one;

import java.util.Random;

public interface Resource {
    // Special
    public static final boolean MINIMAL_MODE = false; // For assignment sending if true

    // Constant
    public static final int MINIMUM_LANDMINE = 5;
    public static final int INITIAL_HEALT_POINT = 3;
    public static final int HUMAN_PLAYER_AMOUNT = 1;
    public static final int COMPUTER_PLAYER_AMOUNT = 1;
    public static final int BLAST_DAMAGE = 1;
    public static final Dimension BOARD_SIZE = new Dimension(5, 5);

    public static final Random rand = new Random();
    public static final FastReader stdin = new FastReader(System.in);

    // Enums
    // Object would use in Board
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
        HUMAN("Human"),
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
        public int getArea() {
            return row * col;
        }
    }
    public record BoardValid(boolean status, String reason) {
        public boolean getStatus() {
            return status;
        }
        public String getReason() {
            return reason;
        }
    }
    
}
