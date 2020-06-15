
package ui;

/**
 *
 * @author vpuurone
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Board board = new Board(3);
        board.setCell(1, 1, Cell.CIRCLE);
        board.setCell(1, 2, Cell.CROSS);
        System.out.println("Pelilauta kun siihen on sijoitettu nolla ja risti:\n" + board.printBoard());
        System.out.println("Testataan voittaja:\n" + board.checkWinner());
        board.setCell(2, 2, Cell.CIRCLE);
        board.setCell(2, 3, Cell.CROSS);
        board.setCell(3, 3, Cell.CIRCLE);
        System.out.println("\nNyt peliä on jatkettu ja lauta näyttää seuraavalta:\n" + board.printBoard());
        System.out.println("\nJa testataan voittaja uudelleen: \n" + board.checkWinner());
        int[][] posMoves = board.getPossibleMoves();
        for (int i = 0; i< posMoves.length; i++) {
            for (int j = 0; j < posMoves[i].length; j++) {
                if (posMoves[i][j] == 1)
                    System.out.println(i + ","  + j);
            }
        }*/
        UI ui = new UI();
        ui.start();
    }
    
}
