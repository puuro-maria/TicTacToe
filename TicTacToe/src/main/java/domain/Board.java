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
        if (cell == Cell.CROSS) {
            c = 1;
        }
        if (cell == Cell.CIRCLE) {
            c = (-1);
        }
        if (cell == Cell.BLANK) {
            c = 0;
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
     * This method is to check whether the game has been won or tied
     * @return Cell (CROSS, CIRCLE or null in case of a tie)
     */
    public Cell checkWinner() {

        int player;

        
        //go through columns
        for (int i = 0; i < board.length; i++) {
            player = board[0][i];
            
            if (player == 0) {
                continue;
            }
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != player) {
                    player = 0;
                    break;
                }
            }
            if (player != 0) {
                    return convertToCell(player);
            }
        }
        
        //go through rows
        for (int[] states : board) {
            player = states[0];
            if (player == 0) {
                continue;
            }
            
            for (int i : states) {
                if (i != player) {
                    player = 0;
                    break;
                }
            }
            if (player != 0) {
                return convertToCell(player);
            }
        }
        
        //go through diagonals ei vielä tarkista muuta kuin vasemmalta keskidiagonaalin, todo
        player = board[0][0];
        for (int i = 0; i < board.length; i++) {
            if (player == 0) {
                continue;
            }
            if (board[i][i] != player) {
                player = 0;
                break;
            }
        }
        if (player != 0) {
            return convertToCell(player);
        }
        
        //check if there's a tie
        for (int[] state : board) {
            for (int i : state) {
                if (i == 0) {
                    return null;
                }
            }
        }
        
        return null;
    }
    
    /**
     * This getter returns the cell value in a specified cell
     * @param xx row of the board
     * @param yy column of the board
     * @return Cell - blank, circle or cross
     */
    public Cell getCell(int xx, int yy) {
        int x = xx-1;
        int y = yy-1;
        Cell c = convertToCell(board[x][y]);
        return c;
    }
    
    /**
     * Get board size
     * @return int size (x*x)
     */
    public int getBoardSize() {
        return this.board.length;
    }
    
    /**
     * Get board
     * @return int[][] board
     */
    public int[][] getBoard() {
        return board;
    }
    
    /**
     * Prints the game board for text UI
     * @return 
     */
    public String printBoard() {
        String print = "";
        String cell ="";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                switch (board[i][j]) {
                    case -1:
                        cell = "O";
                        break;
                    case 0:
                        cell = " ";
                        break;
                    case 1:
                        cell = "X";
                        break;
                }
                print += "|" + cell;
            }
            print += "|\n";
        }
        
        return print;
    }
    
    /**
     * Converts board value (-1, 0, 1) to its enum-value
     * @param value
     * @return Cell
     */
    public Cell convertToCell(int value) {
        Cell c = Cell.BLANK;
        switch (value) {
            case -1:
                c = Cell.CIRCLE;
                break;
            case 0:
                c = Cell.BLANK;
                break;
            case 1:
                c = Cell.CROSS;
                break;
        }
        
        return c;
    }
    
    public int[][] getPossibleMoves() {
        int[][] possibleMoves = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    possibleMoves[i][j] = 1;
                }
            }
        }
        
        return possibleMoves;
    }
    
}
