package domain;

/**
 * This class contains the tic tac toe game board
 * @author vpuurone
 */

public class Board {
    
    private int[][] board;
    private int need;
    int winner = 0;
    int aiBestPos = -10;
    int playerBestPos = 10;
    
    /**
     * Constructor sets up the game board and all its cells as blanks
     * @param x determines the size of the board
     * @param need needed length of winning row
     * 
     */
    public Board(int x, int need) {
        this.need = need;
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
    public boolean setCell(int x, int y, int cell) {

        if (cell == 0) {
            this.board[x][y] = cell;
            setWinner(0);
        }
        if (isFreeCell(x, y)) {
            this.board[x][y] = cell;
            if (positionValue(x, y, cell) == need * cell) {
                setWinner(cell);
            }
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
    public int checkWinner() {

        /*int player;

        
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
                return player;
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
                return player;
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
            return player;
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
                return player;
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
                return player;
            } else {
                col++;
            }
        }
        
        
        //check if there's a tie
        for (int[] state : board) {
            for (int i : state) {
                if (i == 0) {
                    return 0;
                }
            }
        }
        
        //-------------------------------------------------
        
        */
        return 0;
       
    }
    
    /**
     * This method returns the cell position value for minimax.It only checks values based on the last move, no need to iterate through the whole board
     * @param x row
     * @param y column
     * @param turn which player
     * @return optimal value of position
     */
    public int positionValue(int x, int y, int turn) {
        int r = x;
        int c = y;
        
        //row
        int[] row = board[r];

        //find row's optimal value for each player (1 or -10)
        int optSumCol;
        int optSumRow;
        if (turn == -10) {
            optSumRow = 10;
            optSumCol = 10;
        } else {
            optSumRow = -10;
            optSumCol = -10;
        }
        for (int i = 0; i <= row.length-need; i++) {
            int count = 0;
            int sum = 0;
            while (count < need) {
                sum = sum + row[i + count];
                count++;
            }
            if (turn == 1 & sum >= optSumRow & sum >= 0) {
                optSumRow = sum;
            } else if (turn == -10 & sum <= optSumRow & sum % 10 == 0) {
                optSumRow = sum;
            }
        }
        
        //column
        int[] column = new int[board.length];
        for (int i = 0; i < board[r].length; i++) {
            column[i] = board[i][c];
        }
        
        // optimal sum for column
        
        for (int i = 0; i <= board.length - need; i++) {
            int count = 0;
            int sum = 0;
            while (count < need) {
                sum = sum + column[i + count];
                count++;
            }
            if (turn == 1 & sum >= optSumCol & sum >= 0) {
                optSumCol = sum;
            } else if (turn == -10 & sum <= optSumCol & sum % 10 == 0) {
                optSumCol = sum;
            }
        }
        
        if (turn == 1) {
            if (optSumRow >= optSumCol) {
                setBestPosition(turn, optSumRow);
                return optSumRow;
            } else {
                setBestPosition(turn, optSumCol);
                return optSumCol;
            }
        } else {
            if (optSumRow <= optSumCol) {
                setBestPosition(turn, optSumRow);
                return optSumRow;
            } else {
                setBestPosition(turn, optSumCol);
                return optSumCol;
            }
        }
        
        //diagonals TODO

    }
    
    /**
     * This getter returns the cell value in a specified cell
     * @param x row of the board
     * @param y column of the board
     * @return Cell - blank, circle or cross
     */
    public int getCell(int x, int y) {
        return board[x][y];
    }
    
    /**
     * Get board size
     * @return int size (x*x)
     */
    public int getBoardSize() {
        return this.board.length;
    }
    
    /**
     * PositionValue only returns the best value of a position, if it finds a winning row, it sets the winner
     * @param w as in winning player 1 or -10
     */
    public void setWinner(int w) {
        this.winner = w;
    }
    
    /**
     * returns the winning player
     * @return winner 1 or -10
     */
    public int getWinner() {
        return this.winner;
    }
    
    public void setBestPosition(int cell, int posValue) {
        if (cell == -10 & posValue <= playerBestPos) {
            playerBestPos = posValue;
        }
        
        if (cell == 1 & posValue >= aiBestPos) {
            aiBestPos = posValue;
        }

    }
    
    public int getBestPosition(int cell) {
        switch (cell) {
            case 1:
                return aiBestPos;
            case -10:
                return playerBestPos;
            default:
                return 0;
        }
    }
    
    public int getWinningPoints(){
        return getWinner() * need;
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
                    case -10:
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
    
    public int getNeed() {
        return this.need;
    }
}
