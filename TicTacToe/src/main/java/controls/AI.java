package controls;

import domain.*;
/**
 * This class contains minimax and alpha-beta pruning for the game
 * @author vpuurone
 */
public class AI {
    
    public static Cell player = Cell.CIRCLE;
    public static Cell ai = Cell.CROSS;
    
    /**
     * Returns the optimal next move for the AI
     * @param board
     * @return 
     */
    public static int[] bestMove(Board board) {
        int[] bestMove = null;
        int[][] possibleMoves = board.getPossibleMoves();
        
        return bestMove;
    }
     /**
      * minimax-method
      * @param board
      * @return optimal points for the AI
      */
    public static int minimax(Board board) {
        Cell winner = board.checkWinner();
        int points;
        if (winner != null) { 
            if (winner == player) {
                points = -1;
                return points;
            } else if (winner == Cell.BLANK) {
                points = 0;
                return points;
            } else {
                points = 1;
                return points;
            }
        }
        
        int aiCount = 0;
        int playerCount = 0;
        
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (board.getCell(i, j) == player) {
                    playerCount++;
                } else if (board.getCell(i, j) == ai) {
                    aiCount++;
                }
            }
        }
        
        int optimalPoints;
        if (playerCount > aiCount) {
            optimalPoints = -1;
        } else {
            optimalPoints = 1;
        }
        
                
        for (int r = 0; r < board.getBoardSize(); r++) {
            for (int c = 0; c < board.getBoardSize(); c++) {
                if (board.getPossibleMoves()[r][c] == 1) {
                    board.setCell(r, c, playerCount > aiCount ? ai : player);
                    int currentPoints = minimax(board);
                    board.setCell(r, c, Cell.BLANK);
                    if (playerCount > aiCount ? currentPoints > optimalPoints : currentPoints < optimalPoints) {
                        optimalPoints = currentPoints;
                    }
                }
            }
        }
        
        return optimalPoints;
    }
    
}
