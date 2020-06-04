package controls;

import domain.*;
/**
 * This class contains minimax and alpha-beta pruning for the game
 * @author vpuurone
 */
public class AI {
    
    public static Cell player = Cell.CIRCLE;
    public static Cell ai = Cell.CROSS;
    
    public static int[] bestMove(Board board) {
        int[] bestMove = null;
        int[][] possibleMoves = board.getPossibleMoves();
        
        return bestMove;
    }
    
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
    }
    
}
