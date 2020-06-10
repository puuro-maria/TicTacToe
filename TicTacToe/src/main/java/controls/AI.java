package controls;

import domain.*;
/**
 * This class contains minimax and alpha-beta pruning for the game
 * @author vpuurone
 */
public class AI {
    
    public static Cell player = Cell.CIRCLE;
    public static Cell ai = Cell.CROSS;
    public static int cOptimalPoints;
    public static int maxDepth = 20;
    public static int depth = 0;
     /**
      * minimax-method
      * @param board
      * @param isMax parameter defines whether it's the turn of minimizing or maximizing player
      * @return optimal points for the AI
      */
    public static int minimax(Board board, boolean isMax) {
        
        Cell turn;
        if (isMax == true) {
            turn = ai;
        } else turn = player;
        
        Cell winner = board.checkWinner();
        if (winner != null) { 
            if (winner == player) {
                return -1;
            } else if (winner == Cell.BLANK) {
                return 0;
            } else {
                return 1;
            }
        }
        
        int bestPoints = 0;
        
        if (isMax == false) {
            bestPoints = 0;
        } else if (isMax == true) {
            bestPoints = 0;
        } 
        
        int currentPoints = 0;
        
        for (int r = 0; r < board.getBoardSize(); r++) {
            for (int c = 0; c < board.getBoardSize(); c++) {
                if (board.getPossibleMoves()[r][c] == 1) {
                    board.setCell(r, c, turn);
                    if (isMax == true && depth <= maxDepth) {
                        currentPoints = minimax(board, false);
                    } else if (isMax == false && depth <= maxDepth) {
                        currentPoints = minimax(board, true);
                    } 
                    board.setCell(r, c, Cell.BLANK);
                    if ((isMax == true) & (currentPoints > bestPoints)) {
                        bestPoints = currentPoints;
                    } else if ((isMax == false) & (currentPoints < bestPoints)) {
                        bestPoints = currentPoints;
                    }
                } 
            }
        }
        System.out.println(bestPoints);
        return bestPoints;
    }
    
    /**
     * Returns the optimal next move for the AI
     * @param board
     * @return int[] best move
     */
    public static String bestMove(Board board) {
        String bestMove = null;
        int bestPoints = -1000;
        int[][] possibleMoves = board.getPossibleMoves();
        depth = 0;
        
        for (int i = 0; i < possibleMoves.length; i++) {
            for (int j = 0; j < possibleMoves[i].length; j++) {
                if (possibleMoves[i][j] == 1) {
                    board.setCell(i, j, ai);
                    int points = minimax(board, true); // AI is always maximizing player
                    board.setCell(i, j, Cell.BLANK);
                    if (points > bestPoints) {
                        bestPoints = points;
                        bestMove = Integer.toString(i) + "," + Integer.toString(j);
                    }
                }
            }
        }
        System.out.println("AI:n paras siirto: " + bestMove);
        return bestMove;
    }
    

    
}
