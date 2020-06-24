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
    private Board testBoard;
    private Board diagonalWin;
    private Board bigDiagonal;
    private Board diag;
    
    public BoardTest() {
    }
    
    @Before
    public void setUp() {
        board = new Board(3, 3);
        anotherBoard = new Board(4, 4);
        anotherBoard.setCell(1, 1, 1);
        winningBoard = new Board(3, 3);
        winningBoard.setCell(0, 0, -10);
        winningBoard.setCell(0, 1, -10);
        winningBoard.setCell(0, 2, -10);
        winningBoard.setCell(1, 1, 1);
        testBoard = new Board(3, 3);
        testBoard.setCell(0,0,1);
        testBoard.setCell(0, 1, -10);
        testBoard.setCell(1, 1, -10);
        diagonalWin = new Board(3, 3);
        diagonalWin.setCell(0,0,1);
        diagonalWin.setCell(1,1,1);
        bigDiagonal = new Board(4,3);
        bigDiagonal.setCell(0,0,-10);
        bigDiagonal.setCell(1,1,-10);
        bigDiagonal.setCell(2,2,-10);
        diag = new Board(4,3);
        diag.setCell(3,0,1);
        diag.setCell(2,1,1);
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
    public void printBoardWorks() {
        String print = winningBoard.printBoard();
        assertEquals("|O|O|O|\n| |X| |\n| | | |\n", print);
    }
    
    @Test
    public void getPositionValueWorks() {
        assertEquals(-30, winningBoard.positionValue(0,1,-10));
        assertEquals(0, winningBoard.positionValue(2,1,1)); //this column contains two opponents but row is free
        assertEquals(0, testBoard.positionValue(0, 2, 1)); // this row contains opponent but column is free
        assertEquals(10, testBoard.positionValue(1, 0, 1)); //this row contains opponent, column contains one cell
        assertEquals(-20, testBoard.positionValue(2,1,-10)); //this column already has two circles and this would be the winning move
        assertEquals(20, diagonalWin.positionValue(2,2,1));
        //assertEquals(20, diag.positionValue(3, 1, 1));
        //assertEquals(-29, diag.positionValue(3,1,-10));
        assertEquals(20, diag.positionValue(1, 2, 1));
    }
    
    @Test
    public void getWinnerWorks() {
        int winner = winningBoard.getWinner();
        assertEquals(-10, winner);
        
        testBoard.setCell(1,0,1);
        testBoard.setCell(2,0,1);
        winner = testBoard.getWinner();
        assertEquals(1, winner);
        
        diagonalWin.setCell(2,2,1);
        winner = diagonalWin.getWinner();
        assertEquals(1, winner);
        
        winner = bigDiagonal.getWinner();
        assertEquals(-10, winner);
        
        diag.setCell(1,2,1);
        winner = diag.getWinner();
        assertEquals(1, winner);
    }
    
    @Test
    public void closeToWinWorks() {
        assertTrue(diagonalWin.isOpponentCloseToWin(-10));
        assertTrue(testBoard.isOpponentCloseToWin(1));
        assertFalse(board.isOpponentCloseToWin(-10));
        board.setCell(1,1,1);
        board.setCell(0,0,-10);
        assertFalse(board.isOpponentCloseToWin(-10));
        assertTrue(diag.isOpponentCloseToWin(-10));
    }
}
