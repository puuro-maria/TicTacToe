/*
 * This class includes the application logic
 */
package controls;

import domain.*;

/**
 * This class contains the application logic of the game
 * @author vpuurone
 */
public class Controls {
    
    private Board board;
    private AI ai = new AI();

    
    /**
     * Sets up game board 
     * @param size of the board
     * @return game board
     */
    public Board setUpGame(int size) {
        this.board = new Board(size);
        
        return this.board;
    }
    
    /**
     * Player sets cell to board
     * @param x
     * @param y
     * @param cell
     * @return boolean
     */
    public boolean setCell(int x, int y, Cell cell) {
        if (this.board.setCell(x, y, cell)) {
            this.board.setCell(x, y, cell);
            return true;
        } else return false;
    }
    
    /**
     * AI sets cell to board
     * @param board
     */
    public void aiTurn() {
        String[] move = ai.bestMove(this.board).split(",");
        int x = Integer.parseInt(move[0]);
        int y = Integer.parseInt(move[1]);
        setCell(x, y, Cell.CROSS);
    }
    
    /**
     * Checks whether game is over
     * @return boolean
     */
    public boolean gameWon() {
        if (this.board.checkWinner() != null) {
            return true;
        } else return false;
    }
    
    /**
     * Empties the game board for the next game
     */
    public void gameOver() {
        this.board = null;
    }
    
    /**
     * Prints the game board for the player to view
     * @return String
     */
    public String printBoard() {
        return this.board.printBoard();
    }
    
    /**
     * Returns the winning player
     * @return Cell
     */
    public Cell whoWon() {
        return this.board.checkWinner();
    }
    
}
