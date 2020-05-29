package domain;

/**
 * This class contains the tic tac toe game board
 * @author vpuurone
 */

public class Board {
    
    private int[][] board;
    
    /**
     * Constructor sets up the game board and all its cells as blanks
     * @param x determines the size of the board
     * 
     */
    public Board(int x) {
        this.board = new int[x][x];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 0;
            }
        }
    }
    
    /**
     * This method makes a move (inserts your cell on the board)
     * @param x
     * @param y
     * @param cell
     * @return 
     */
    public boolean setCell(int xx, int yy, Cell cell) {
        int c = 0;
        int x = xx-1;
        int y = yy-1;
        if (cell == Cell.CIRCLE) {
            c = -1;
        }
        if (cell == Cell.CROSS) {
            c = 1;
        }
        if (isFreeCell(xx,yy)) {
            this.board[x][y] = c;
            return true;
        }
        
        return false;
    }
    
    /**
     * This method checks if a certain cell is available for a move (true or false)
     * @param x
     * @param y
     * @return boolean
     */
    public boolean isFreeCell(int xx, int yy) {
        int x = xx-1;
        int y = yy-1;
        if (this.board[x][y] == 0) {
            return true;
        }
        
        return false;
    }
    
    /**
     * This getter returns the cell value in a specified cell
     * @param x row of the board
     * @param y column of the board
     * @return Cell - blank, circle or cross
     */
    public Cell getCell(int xx, int yy) {
        int x = xx-1;
        int y = yy-1;
        Cell c;
        switch (board[x][y]) {
            case 0:
                c = Cell.BLANK;
            case 1:
                c = Cell.CROSS;
            case -1:
                c = Cell.CIRCLE;
        }
        return c;
    }
    
    public int getBoardSize() {
        return this.board.length;
    }
    
}
