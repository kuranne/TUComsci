// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

public class GameException {
    public static class InvalidBoardInitializeException extends RuntimeException {
        public InvalidBoardInitializeException (String message) {
            super(message);
        }
    }

    public static class InvalidGamePlayException extends RuntimeException {
        public InvalidGamePlayException (String message) {
            super(message);
        }
    }
}
