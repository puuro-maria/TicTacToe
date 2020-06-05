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
        winningBoard.setCell(0, 0, Cell.CIRCLE);
        winningBoard.setCell(0, 1, Cell.CIRCLE);
        winningBoard.setCell(0, 2, Cell.CIRCLE);
        winningBoard.setCell(1, 1, Cell.CROSS);
    }
    

    @Test
    public void constructorAndGetSizeWork() {
        assertTrue(board.getBoardSize() == 3);
    }
    
    @Test
    public void setCellAndGetCellWork() {
        assertEquals(Cell.BLANK, board.getCell(0, 0));
        assertEquals(Cell.CROSS, anotherBoard.getCell(1,1));
        board.setCell(1, 0, Cell.CIRCLE);
        assertTrue(board.setCell(1, 1, Cell.CROSS));
        assertFalse(board.setCell(1, 1, Cell.CIRCLE));
        assertEquals(Cell.CIRCLE, board.getCell(1,0));
    }
    
    @Test
    public void CheckWinnerWorks() {
        assertTrue(winningBoard.checkWinner() == Cell.CIRCLE);
        
        Board winningBoardTwo = new Board(3);
        winningBoardTwo.setCell(0, 0, Cell.CROSS);
        assertFalse(winningBoardTwo.checkWinner() == Cell.CROSS);
        winningBoardTwo.setCell(1, 0, Cell.CROSS);
        winningBoardTwo.setCell(2, 0, Cell.CROSS);
        assertTrue(winningBoardTwo.checkWinner() == Cell.CROSS);
        
        Board winningBoardThree = new Board(3);
        winningBoardThree.setCell(0, 0, Cell.CROSS);
        winningBoardThree.setCell(1, 1, Cell.CROSS);
        winningBoardThree.setCell(2, 2, Cell.CROSS);
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
        int[][] posMoves = winningBoard.getPossibleMoves();
        String posMovesPrint = "";
        for (int i = 0; i < posMoves.length; i++) {
            for (int j = 0; j < posMoves[i].length; j++) { 
                if (posMoves[i][j] == 1)
                    posMovesPrint += Integer.toString(i) + ", " + Integer.toString(j) + "\n";
            }
        } 
        
        assertTrue(posMovesPrint.contains("1, 0\n1, 2\n2, 0\n2, 1\n2, 2"));
        assertFalse(posMovesPrint.contains("0, 0"));
    }
}
