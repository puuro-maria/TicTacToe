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
    int move = 0;
    int bestPosMove = 0;
    
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
            move--;
            setWinner(0);
        }
        if (isFreeCell(x, y)) {
            this.board[x][y] = cell;
            move++;
            //System.out.println("Siirtosi position arvo on: " + positionValue(x,y,cell));
            if ((positionValue(x, y, cell) == need * cell & cell == -10) | (positionValue(x, y, cell) == need * 10 & cell == 1)) {
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

        int optSumRowO = 10;
        int optSumColO = 10;
        int optSumDiagOneO = 10;
        int optSumDiagTwoO = 10;

        int optSumRowX = -10;
        int optSumColX = -10;
        int optSumDiagOneX = -10;
        int optSumDiagTwoX = -10;
        
        for (int i = 0; i <= row.length-need; i++) {
            int count = 0;
            int sum = 0;
            while (count < need) {
                sum = sum + row[i + count];
                count++;
            }
            if (sum >= optSumRowX & sum >= 0) {
                optSumRowX = sum;
            }
            if (sum <= optSumRowO & sum % 10 == 0) {
                optSumRowO = sum;
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
            if (sum >= optSumColX & sum >= 0) {
                optSumColX = sum;
            }
            if (sum <= optSumColO & sum % 10 == 0) {
                optSumColO = sum;
            }
        }
        
        //diagonals 
        // downwards from left to right
        int tempRow = r;
        int tempCol = c;
        int[] diagOne = new int[board.length];
        while (tempCol >= 0 & tempRow >= 0) {
            diagOne[tempCol] = board[tempRow][tempCol];
            tempCol--;
            tempRow--;
        } 

        tempCol = c+1;
        tempRow = r+1;
        while (tempRow <= board.length - 1 & tempCol <= board.length - 1) {
            diagOne[tempCol] = board[tempRow][tempCol];
            tempCol++;
            tempRow++;
        } 
        
        //optimal sum for diagOne
        for (int i = 0; i <= board.length - need; i++) {
            int count = 0;
            int sum = 0; 
            while (count < need) {
                sum += diagOne[i + count];
                count++;
            }
            if (sum >= optSumDiagOneX & sum >= 0) {
                optSumDiagOneX = sum;
            }
            if (sum <= optSumDiagOneO & sum % 10 == 0) {
                optSumDiagOneO = sum;
            }
        }

        // upwards from left to right
        tempRow = r;
        tempCol = c;
        int[] diagTwo = new int[board.length];
        while (tempCol >= 0 & tempRow < board.length) {
            diagTwo[tempCol] = board[tempRow][tempCol];
            tempCol--;
            tempRow++;
        }
        if (r >= 1 & c <= board.length - 2) {
            tempRow = r-1;
            tempCol = c+1;
        
            while (tempCol < board.length & tempRow >= 0) {
                diagTwo[tempCol] = board[tempRow][tempCol];
                tempCol++;
                tempRow--;
            }
        }

        // optimal value for diagTwo
        for (int i = 0; i <= board.length - need; i++) {
            int count = 0;
            int sum = 0;
            while (count < need) {
                sum += diagTwo[i + count];
                count++;
            }
            if (sum >= optSumDiagTwoX & sum >= 0) {
                optSumDiagTwoX = sum;
            }
            if (sum <= optSumDiagTwoO & sum % 10 == 0) {
                optSumDiagTwoO = sum;
            }
        }
        // optimal value for position
        int optX = optSumRowX;
        int optO = optSumRowO;
        
        //find optimal value for X
        if (optSumColX >= optX) {
            optX = optSumColX;
        } 
        if (optSumDiagOneX >= optX) {
            optX = optSumDiagOneX;
        }
        if (optSumDiagTwoX >= optX) {
            optX = optSumDiagTwoX;
        }
        // find optimal value for O
        if (optSumColO <= optO) {
            optO = optSumColO;
        }
        if (optSumDiagOneO <= optO) {
            optO = optSumDiagOneO;
        }
        if (optSumDiagTwoO <= optO) {
            optO = optSumDiagTwoO;
        }

        if (turn == -10) {
            if (optX >= need - 1) {
                optO = -401;
            }
            setBestPosition(-10, optO);
            return optO;
        } else {
            if (optO <= need * -10 + 10) {
                optX = 401;
            }
            setBestPosition(1, optX * 10);
            return optX * 10;
        }
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
     * Check whether there are moves left on the board
     * @return boolean
     */
    public boolean movesLeft() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    return true;
                }
            }      
        }  
        return false;
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
    
    /**
     * In case minimax reaches depth max, this method returns the optimal position value
     * @param cell
     * @param posValue 
     */
    public void setBestPosition(int cell, int posValue) {
        if ((cell == -10 & posValue <= playerBestPos) | move > bestPosMove) {
            playerBestPos = posValue;
        }
        
        if ((cell == 1 & posValue >= aiBestPos) | move > bestPosMove) {
            aiBestPos = posValue;
        }
        
        if (move > bestPosMove) {
                bestPosMove++;
        }

    }
    
    /**
     * returns the best position value
     * @param cell
     * @return 
     */
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
    
    public boolean isOpponentCloseToWin(int turn) {
        if (turn == 1) {
            if (getBestPosition(-10) <= need * -10 + 10) {
                return true;
            }
        } else if (turn == -10) {
            if (getBestPosition(1) >= need - 1) {
                return true;
            }
        } 
        return false;
    }
    
    /**
     * returns winning points for minimax evaluation
     * @return points
     */
    public int getWinningPoints(){
        if (getWinner() == 1) {
            return need * 10;
        }
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
