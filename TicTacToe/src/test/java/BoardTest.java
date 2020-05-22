/*
 * Tests for the game board
 */

import domain.Board;
import domain.Cell;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vpuurone
 */
public class BoardTest {
    
    private Board board;
    private Board anotherBoard;
    
    public BoardTest() {
    }
    
    @Before
    public void setUp() {
        board = new Board(3);
        anotherBoard = new Board(4);
        anotherBoard.setCell(1, 1, Cell.CROSS);
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
        assertEquals(Cell.CIRCLE, board.getCell(2,1));
    }
}
