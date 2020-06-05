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
    public static int maxDepth = 10;
    public static int depth = 0;
     /**
      * minimax-method
      * @param board
     * @param isMax parameter defines whether it's the turn of minimizing or maximizing player
      * @return optimal points for the AI
      */
    public static int minimax(Board board, boolean isMax) {
        
        /*if (depth == maxDepth) {
            return cOptimalPoints;
        }*/
        depth++;
        
        Cell turn;
        if (isMax == true) {
            turn = ai;
        } else turn = player;
        
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
        
        /*int aiCount = 0;
        int playerCount = 0;
        
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (board.getCell(i, j) == player) {
                    playerCount++;
                } else if (board.getCell(i, j) == ai) {
                    aiCount++;
                }
            }
        }*/
        
        int bestPoints;
        
        if (isMax == false) {
            bestPoints = 100000;
        } else {
            bestPoints = -100000;
        }
        
       // cOptimalPoints = bestPoints;
        int currentPoints;
        
        for (int r = 0; r < board.getBoardSize(); r++) {
            for (int c = 0; c < board.getBoardSize(); c++) {
                if (board.getPossibleMoves()[r][c] == 1) {
                    board.setCell(r, c, turn);
                    if (isMax == true) {
                        currentPoints = minimax(board, false);
                    } else {
                        currentPoints = minimax(board, true);
                    }
                    board.setCell(r, c, Cell.BLANK);
                    if (isMax == true & currentPoints > bestPoints) {
                        bestPoints = currentPoints;
                    } else if (isMax == false & currentPoints < bestPoints) {
                        bestPoints = currentPoints;
                    }
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
                    int points = minimax(board, true); // AI is always maximizing player
                    board.setCell(i, j, Cell.BLANK);
                    if (points > bestPoints) {
                        bestPoints = points;
                        bestMove = Integer.toString(i) + "," + Integer.toString(j);
                    }
                }
            }
        }
        System.out.println("Paras move" + bestMove);
        return bestMove;
    }
    
    public void resetcOptimalPoints() {
        this.cOptimalPoints = 0;
    }
    
}
