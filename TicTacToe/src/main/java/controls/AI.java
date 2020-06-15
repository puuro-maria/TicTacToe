package controls;

import domain.*;
/**
 * This class contains minimax and alpha-beta pruning for the game
 * @author vpuurone
 */
public class AI {
    
    public static Cell player = Cell.CIRCLE;
    public static Cell ai = Cell.CROSS;
    public static int maxDepth = 2000;
    public static int depth = 0;
     /**
      * minimax-method
      * @param board
      * @param isMax parameter defines whether it's the turn of minimizing or maximizing player
      * @return optimal points for the AI
      */
    public static int minimax(Board board, boolean isMax, int alpha, int beta) {
        
        depth++;
        Cell turn;
        if (isMax == true) {
            turn = ai;
        } else {
            turn = player;
        }
        
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
        
        int bestPoints;
        
        if (isMax == false) {
            bestPoints = 100;
        } else {
            bestPoints = -100;
        } 
        
        int currentPoints = 0;
        
        //recursion
        for (int r = 0; r < board.getBoardSize(); r++) {
            for (int c = 0; c < board.getBoardSize(); c++) {
                if (board.getPossibleMoves()[r][c] == 1) {
                    board.setCell(r, c, turn);
                    if (isMax == true && depth <= maxDepth) {
                        currentPoints = minimax(board, false, -100, 100);
                    } else if (isMax == false && depth <= maxDepth) {
                        currentPoints = minimax(board, true, -100, 100);
                    } 
                    board.setCell(r, c, Cell.BLANK);
                    if ((isMax == true) & (currentPoints > bestPoints)) {
                        bestPoints = currentPoints;
                    } else if ((isMax == false) & (currentPoints < bestPoints)) {
                        bestPoints = currentPoints;
                    }
                    
                    //alpha-beta pruning
                    /*if (isMax == true & bestPoints >= alpha) {
                        alpha = bestPoints;
                    }
                    if (isMax == true & beta <= alpha) {
                        break;
                    }
                    if (isMax == false & bestPoints <= beta) {
                        beta = bestPoints;
                    }
                    if (isMax == false & beta <= alpha) {
                        break;
                    }*/
                } 
            }
        }

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
                    int points = minimax(board, true, -100, 100); // AI is always maximizing player
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
