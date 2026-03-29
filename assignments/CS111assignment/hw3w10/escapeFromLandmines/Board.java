// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

import escapeFromLandmines.Model.BoardObj;
import escapeFromLandmines.Model.Vector2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Board {
    // Variable
    private static final Random rand = new Random();

    private final ArrayList<ArrayList<BoardObj>> board;
    private final char[][] playerBoard;
    // Use ArrayList for const board (Prefer hander to edit the value of its)
    // And char array for easiler to edit
    private final Vector2 scope;
    private final int amountOfLandmines;
    private int amountOfUsedLandmines;

    // Constructor
    public Board(Vector2 scope, int amountOfLandmines) {
        this.scope = scope;
        this.amountOfLandmines = amountOfLandmines;
        this.amountOfUsedLandmines = 0;

        board = new ArrayList<>();
        playerBoard = new char[scope.row()][scope.col()];
    }
    public void setupBoard() {
        // Initialize board with '-'
        for (int i = 0; i < scope.row(); i++) {
            ArrayList<BoardObj> row = new ArrayList<>();
            for (int j = 0; j < scope.col(); j++) {
                row.add(BoardObj.NONE);
            }
            board.add(row);
        }

        // Initialize player board with 'X'
        for (char[] row : playerBoard) {
            Arrays.fill(row, 'X');
        }
        
        // Place landmines randomly
        HashSet<Vector2> placedLandmines = new HashSet<>();
        while (placedLandmines.size() < amountOfLandmines) {
            Vector2 randomPos = new Vector2(
                rand.nextInt(scope.row()), 
                rand.nextInt(scope.col())
            );
            
            if (!placedLandmines.contains(randomPos)) {
                board.get(randomPos.row()).set(randomPos.col(), BoardObj.LANDMINE);
                placedLandmines.add(randomPos);
            }
        }
    }

    // Methods
    // A player choose a position -> if revealed as landmine -> B0OM!
    // Ret: true if not boom, else is BO0M!
    public boolean choose(Vector2 coordinate) throws ArrayIndexOutOfBoundsException {
        int row = coordinate.row();
        int col = coordinate.col();
        char area = playerBoard[row][col];

        if (area == 'X') { // If area is hidden -> make it appeal
            BoardObj what = board.get(row).get(col);
            playerBoard[row][col] = what.getChar();
            if (what == BoardObj.LANDMINE) amountOfUsedLandmines++;
            return what.isSafe();
        } else {
            return true;
        }
    }

    public boolean isReveal(Vector2 coordinate) {
        return playerBoard[coordinate.row()][coordinate.col()] != 'X';
    }

    // Copy each char in board to playerBoard
    public void revealAll() {
        for (int row = 0; row < scope.row(); row++) {
            for (int col = 0; col < scope.col(); col++) {
                playerBoard[row][col] = (board.get(row).get(col).isSafe()) ? '-' : 'b';
            }
        }
    }

    // For Check when all landmines are revealed
    public boolean isOutOfLandmine() {
        return amountOfLandmines == amountOfUsedLandmines;
    }

    // Getter Methods
    public char[][] getPlayerBoard() {
        return playerBoard;
    }
    public int getAmountOfLandmines() {
        return amountOfLandmines;
    }
    public int getAmountOfUsedLandmines() {
        return amountOfUsedLandmines;
    }
    
}
