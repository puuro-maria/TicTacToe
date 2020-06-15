/*
 * Tests for the game board
 */

import domain.Board;

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
        anotherBoard.setCell(1, 1, 1);
        winningBoard = new Board(3);
        winningBoard.setCell(0, 0, -10);
        winningBoard.setCell(0, 1, -10);
        winningBoard.setCell(0, 2, -10);
        winningBoard.setCell(1, 1, 1);
    }
    

    @Test
    public void constructorAndGetSizeWork() {
        assertTrue(board.getBoardSize() == 3);
    }
    
    @Test
    public void setCellAndGetCellWork() {
        assertEquals(0, board.getCell(0, 0));
        assertEquals(1, anotherBoard.getCell(1,1));
        board.setCell(1, 0, -10);
        assertTrue(board.setCell(1, 1, 1));
        assertFalse(board.setCell(1, 1, -10));
        assertEquals(-10, board.getCell(1,0));
    }
    
    @Test
    public void CheckWinnerWorks() {
        assertTrue(winningBoard.checkWinner() == -10);
        
        Board winningBoardTwo = new Board(3);
        winningBoardTwo.setCell(0, 0, 1);
        assertFalse(winningBoardTwo.checkWinner() == 1);
        winningBoardTwo.setCell(1, 0, 1);
        winningBoardTwo.setCell(2, 0, 1);
        assertTrue(winningBoardTwo.checkWinner() == 1);
        
        Board winningBoardThree = new Board(3);
        winningBoardThree.setCell(0, 0, 1);
        winningBoardThree.setCell(1, 1, 1);
        winningBoardThree.setCell(2, 2, 1);
        assertTrue(winningBoardThree.checkWinner() == 1);
        
        assertTrue(anotherBoard.checkWinner() == 0);
    }
    
    
    @Test 
    public void printBoardWorks() {
        String print = winningBoard.printBoard();
        assertEquals("|O|O|O|\n| |X| |\n| | | |\n", print);
    }
    
}
