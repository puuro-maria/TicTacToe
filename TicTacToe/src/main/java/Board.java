/**
 * This class contains the tic tac toe game board
 * @author vpuurone
 */

public class Board {
    
    private Cell[][] board;
    
    /**
     * Constructor sets up the game board and all its cells as blanks
     * @param x determines the size of the board
     * 
     */
    public Board(int x) {
        this.board = new Cell[x][x];
        for (int i = 0; i <= board.length; i++) {
            for (int j = 0; j <= board[0].length; j++) {
                board[i][j] = Cell.BLANK;
            }
        }
    }
    
}
