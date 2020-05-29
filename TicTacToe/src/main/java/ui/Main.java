
package ui;
import domain.*;

/**
 *
 * @author vpuurone
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board board = new Board(3);
        board.setCell(1, 1, Cell.CIRCLE);
        System.out.println(board.checkWinner());
        System.out.println(board.printBoard());
        String[] posMoves = board.getPossibleMoves();
        for (int i = 0; i< posMoves.length; i++) {
            System.out.println(posMoves[i]);
        }
    }
    
}
