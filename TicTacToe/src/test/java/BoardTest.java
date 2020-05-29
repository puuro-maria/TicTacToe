/*
 * Tests for the game board
 */

import domain.Board;
import domain.Cell;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vpuurone
 */
public class BoardTest {
    
    private Board board;
    private Board anotherBoard;
    private Board winningBoard;
    
    public BoardTest() {
    }
    
    @Before
    public void setUp() {
        board = new Board(3);
        anotherBoard = new Board(4);
        anotherBoard.setCell(1, 1, Cell.CROSS);
        winningBoard = new Board(3);
        winningBoard.setCell(1, 1, Cell.CIRCLE);
        winningBoard.setCell(1, 2, Cell.CIRCLE);
        winningBoard.setCell(1, 3, Cell.CIRCLE);
        winningBoard.setCell(2, 2, Cell.CROSS);
    }
    

    @Test
    public void constructorAndGetSizeWork() {
        assertTrue(board.getBoardSize() == 3);
    }
    
    @Test
    public void setCellAndGetCellWork() {
        assertEquals(Cell.BLANK, board.getCell(1, 1));
        assertEquals(Cell.CROSS, anotherBoard.getCell(1,1));
        board.setCell(2, 1, Cell.CIRCLE);
        assertTrue(board.setCell(2, 2, Cell.CROSS));
        assertFalse(board.setCell(2, 2, Cell.CIRCLE));
        assertEquals(Cell.CIRCLE, board.getCell(2,1));
    }
    
    @Test
    public void CheckWinnerWorks() {
        assertTrue(winningBoard.checkWinner() == Cell.CIRCLE);
        
        Board winningBoardTwo = new Board(3);
        winningBoardTwo.setCell(1, 1, Cell.CROSS);
        winningBoardTwo.setCell(2, 1, Cell.CROSS);
        winningBoardTwo.setCell(3, 1, Cell.CROSS);
        assertTrue(winningBoardTwo.checkWinner() == Cell.CROSS);
        
        Board winningBoardThree = new Board(3);
        winningBoardThree.setCell(1, 1, Cell.CROSS);
        winningBoardThree.setCell(2, 2, Cell.CROSS);
        winningBoardThree.setCell(3, 3, Cell.CROSS);
        assertTrue(winningBoardThree.checkWinner() == Cell.CROSS);
        
        assertTrue(anotherBoard.checkWinner() == null);
    }
    
    @Test
    public void convertToCellWorks() {
        assertTrue(anotherBoard.convertToCell(1) == Cell.CROSS);
        assertTrue(board.convertToCell(0) == Cell.BLANK);
        assertTrue(board.convertToCell(-1) == Cell.CIRCLE);
    }
    
    @Test 
    public void printBoardWorks() {
        String print = winningBoard.printBoard();
        assertEquals("|O|O|O|\n| |X| |\n| | | |\n", print);
    }
    
    @Test 
    public void getPossibleMovesWorks() {
        String[] posMoves = winningBoard.getPossibleMoves();
        String posMovesPrint = "";
        for (int i = 0; i < posMoves.length; i++) {
            posMovesPrint += posMoves[i] + "\n";
        }
        
        assertTrue(posMovesPrint.contains("2,1\n2,3\n3,1\n3,2\n3,3"));
    }
}
