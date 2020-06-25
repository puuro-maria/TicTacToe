package controls;

import domain.*;
/**
 * This class contains minimax and alpha-beta pruning for the game
 * @author vpuurone
 */
public class AI {
    
    public static int maxDepth = 7;

     /**
      * minimax-method
      * @param board
      * @param isMax parameter defines whether it's the turn of minimizing or maximizing player
     * @param alpha
     * @param beta
     * @param depth current depth
      * @return optimal points for the AI
      */
    public static int minimax(Board board, boolean isMax, int alpha, int beta, int depth) {
        
        int turn;
        int opp;
        if (isMax == true) {
            turn = 1;
            opp = -10;
        } else {
            turn = -10;
            opp = 1;
        }
        
        //max depth reached, return position value
        if (depth == maxDepth) {
            return board.getBestPosition(turn);
        } 
        
        //game won, return winning points
        if (board.getWinner() != 0) {
            if (isMax == true) {
                return board.getWinningPoints() + depth;
            } else if (isMax == false) {
                return board.getWinningPoints() - depth;
            }
        }
        
        //tie i.e. no available moves and no winner
        if (board.getWinner() == 0 & board.movesLeft() == false) {
            return 0;
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
                if (board.getCell(r, c) == 0) {
                    board.setCell(r, c, turn);
                    if (isMax == true) {
                        currentPoints = minimax(board, false, alpha, beta, depth + 1);
                    } else if (isMax == false) {
                        currentPoints = minimax(board, true, alpha, beta, depth + 1);
                    } 
                    board.setCell(r, c, 0);
                    if ((isMax == true) & (currentPoints > bestPoints)) {
                        bestPoints = currentPoints;
                    } else if ((isMax == false) & (currentPoints < bestPoints)) {
                        bestPoints = currentPoints;
                    }

                    //alpha-beta pruning
                    if (isMax == true & bestPoints >= alpha) {
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
                    }
                    
                } 
            }
        }

        return bestPoints;
    }
    
    /**
     * Returns the optimal next move for the AI
     * @param board
     * @return String best move
     */
    public static String bestMove(Board board) {
        String bestMove = null;
        int bestPoints = -1000;
        
        //iterate through board
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (board.getCell(i, j) == 0) {
                    //if this move (i,j) would make AI win then set cell here
                    if (board.positionValue(i, j, 1) >= board.getNeed() * 10 - 10) {
                        board.setCell(i, j, i);
                        bestMove = Integer.toString(i) + "," + Integer.toString(j);
                        board.setCell(i, j, 0);
                        return bestMove;
                    }
                    //if opponent is close to win (next move or two moves in case of bigger board) then give this position a high value
                    if (((board.positionValue(i, j, -10) <= (board.getNeed() * -10 + 10) & (board.getBoardSize() - board.getNeed()) <= 1)) | (board.positionValue(i, j, -10) <= board.getNeed() * -10 + 20 & board.getBoardSize() - board.getNeed() > 1)) {
                        board.setCell(i, j, 1);
                        if (!board.isOpponentCloseToWin(1)) {
                            bestPoints = 4000; 
                            bestMove = Integer.toString(i) + "," + Integer.toString(j);
                            board.setCell(i, j, 0);
                        }
                    }
                    board.setCell(i, j, 1);
                    //if (i,j) is not a winning position, then call minimax
                    int points = minimax(board, true, -100, 100, 0); // AI is always maximizing player
                    board.setCell(i, j, 0);
                    if (points > bestPoints) {
                        bestPoints = points;
                        bestMove = Integer.toString(i) + "," + Integer.toString(j);
                    }
                }
            }
        }
        System.out.println("AI:n siirto: " + bestMove);
        return bestMove;
    }
    

    
}
