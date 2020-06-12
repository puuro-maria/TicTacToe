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
    public boolean setCell(int x, int y, Cell cell) {
        int c = 0;

        if (cell == Cell.CROSS) {
            c = 1;
        }
        if (cell == Cell.CIRCLE) {
            c = (-1);
        }
        if (cell == Cell.BLANK) {
            c = 0;
            this.board[x][y] = c;
        }
        if (isFreeCell(x, y)) {
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
    public boolean isFreeCell(int x, int y) {
        if (this.board[x][y] == 0) {
            return true;
        }
        
        return false;
    }
    
    /**
     * This method is to check whether the game has been won or tied
     * @return Cell (CROSS, CIRCLE or BLANK in case of a tie)
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
        
        //diagonals in other direction
        int row = 0;
        int col;
        
        while (row <= getBoardSize() - 1) {
            int[] diagonal = new int[getBoardSize()];
            col = 0;
            int tempR = row;
            int i = 0;
            while (tempR >= 0) {
                if (board[tempR][col] == player && player != 0) {
                    diagonal[i] = board[tempR][col];
                    tempR--;
                    col++;
                    i++;
                } else {
                    break;
                }
            }
            if (diagonal[getBoardSize() - 1] == player && player != 0) {
                System.out.println(diagonal);
                return convertToCell(player);
            } else {
                row++;
            }
        }
        
        col = 1;
        while (col <= getBoardSize() - 1) {
            int[] diagonal = new int[getBoardSize()];
            int tempC = col;
            int i = 0;
            row = getBoardSize() - 1;
            while (tempC <= getBoardSize() - 1) {
                if (board[row][tempC] == player && player != 0) {
                    diagonal[i] = board[row][tempC];
                    row--;
                    tempC++;
                    i++;
                } else {
                    break;
                }
            }
            if (diagonal[getBoardSize() - 1] == player && player != 0) {
                System.out.println(diagonal);
                return convertToCell(player);
            } else {
                col++;
            }
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
     * @param x row of the board
     * @param y column of the board
     * @return Cell - blank, circle or cross
     */
    public Cell getCell(int x, int y) {
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
        String cell = "";
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
