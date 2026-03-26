// Wirakorn Thanabat
// 6809617415

package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import static one.Resource.*;

public class Board {
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
        playerBoard = new char[dimension.row()][dimension.col()];
    }
    public void setupBoard() {
        // Initialize board with '-'
        for (int i = 0; i < dimension.row(); i++) {
            ArrayList<OBJECTS> row = new ArrayList<>();
            for (int j = 0; j < dimension.col(); j++) {
                row.add(OBJECTS.NONE);
            }
            board.add(row);
        }

        // Initialize player board with 'X'
        for (char[] row : playerBoard) {
            Arrays.fill(row, 'X');
        }
        
        // Place landmines randomly
        HashSet<Dimension> placedLandmines = new HashSet<>();
        while (placedLandmines.size() < amountOfLandmines) {
            Dimension randomPos = new Dimension(
                rand.nextInt(dimension.row()), 
                rand.nextInt(dimension.col())
            );
            
            if (!placedLandmines.contains(randomPos)) {
                board.get(randomPos.row()).set(randomPos.col(), OBJECTS.LANDMINE);
                placedLandmines.add(randomPos);
            }
        }
    }

    // Methods
    // A player choose a position -> if revealed as landmine -> B0OM!
    // Ret: true if not boom, else is BO0M!
    public boolean choose(Dimension dimension) throws ArrayIndexOutOfBoundsException {
        int row = dimension.row();
        int col = dimension.col();
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
        for (int row = 0; row < dimension.row(); row++) {
            for (int col = 0; col < dimension.col(); col++) {
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
