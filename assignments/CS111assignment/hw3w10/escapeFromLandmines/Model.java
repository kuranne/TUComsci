// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

public class Model {
    // Object would use in Board
    public enum BoardObj {
        NONE('-'),
        LANDMINE('b');

        private final char description;

        private BoardObj(char description) {
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
    public enum PlayerType {
        HUMAN("Human"),
        COMPUTER("Computer"),
        OTHER("Other");
        
        private final String description;

        PlayerType(String description) {
            this.description = description;
        }

        public String getType() {
            return description;
        }
    }

    // Vector type to store (int, int)
    public record Vector2(int row, int col) {
        public int area() {
            return row * col;
        }
    }
}
