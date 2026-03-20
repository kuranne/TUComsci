// Wirakorn Thanabat
// 6809617415

package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Board implements Resource {
    // Variable
    private final ArrayList<ArrayList<OBJECTS>> board;
    private final char[][] playerBoard;
    private final Dimension dimension;
    private final int amountOfLandmines;
    private int openedLandmines;

    // Constructor
    public Board(Dimension dimension, int amountOfLandmines) {
        this.dimension = dimension;
        this.amountOfLandmines = amountOfLandmines;
        this.openedLandmines = 0;

        board = new ArrayList<>();
        playerBoard = new char[dimension.getRow()][dimension.getCol()];
    }
    public void setupBoard() {
        // Make all in board is '-'
        for (int i = 0; i < dimension.getRow(); i++) {
            ArrayList<OBJECTS> newLineBoard = new ArrayList<>();
            for (int j = 0; j < dimension.getCol(); j++) {
                newLineBoard.add(OBJECTS.NONE);
            }
            board.add(newLineBoard);
        }

        // Make all in playerBoard is 'X'(hidden)
        for (char[] row : playerBoard) {
            Arrays.fill(row, 'X');
        }
        
        HashSet<Dimension> usedLandmineDimension = new HashSet<>();
        
        while (usedLandmineDimension.size() < amountOfLandmines) {
            // Random a position of new landmine
            Dimension nextRandom = new Dimension(
                rand.nextInt(dimension.getRow()), 
                rand.nextInt(dimension.getCol())
            );
            // Check isn't same as in used landmine position
            if (!usedLandmineDimension.contains(nextRandom)) {
                // Get old row of board then change a char in that -> readd to the board
                ArrayList<OBJECTS> subBoard = board.get(nextRandom.getRow());
                subBoard.set(nextRandom.getCol(), OBJECTS.LANDMINE);
                board.set(nextRandom.getRow(), subBoard);
                
                // Used landmine added
                usedLandmineDimension.add(nextRandom);
            }
        }
    }

    // Methods
    // A player choose a position -> if revealed as landmine -> B0OM!
    // Ret: true if not boom, else is BO0M!
    public boolean choose(Dimension dimension) throws ArrayIndexOutOfBoundsException {
        int row = dimension.getRow();
        int col = dimension.getCol();
        char area = playerBoard[row][col];

        if (area == 'X') { // If area is hidden -> make it appeal
            OBJECTS what = board.get(row).get(col);
            playerBoard[row][col] = what.getChar();
            if (what == OBJECTS.LANDMINE) openedLandmines++;
            return what.isSafe();
        } else {
            return true;
        }
    }

    public boolean isReveal(Dimension dimension) {
        return playerBoard[dimension.row()][dimension.col()] != 'X';
    }

    public void revealAll() {
        for (int row = 0; row < dimension.getRow(); row++) {
            for (int col = 0; col < dimension.getCol(); col++) {
                playerBoard[row][col] = (board.get(row).get(col).isSafe()) ? '-' : 'b';
            }
        }
    }

    public boolean isOutOfLandmine() {
        return amountOfLandmines == openedLandmines;
    }

    // Getter Methods
    public char[][] getPlayerBoard() {
        return playerBoard;
    }
    public int getAmountOfLandmines() {
        return amountOfLandmines;
    }
    public int getOpenedLandmines() {
        return openedLandmines;
    }
    
}
