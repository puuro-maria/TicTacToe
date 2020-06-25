import controls.*;
import domain.Board;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vpuurone
 */
public class ControlsTest {
    
    private Controls controls;
    private Board board;
    
    @Before
    public void setUp() {
        controls = new Controls();
        board = controls.setUpGame(3,3);
    }
    
    @Test
    public void setUpGameWorks() {
        assertEquals(3, board.getBoardSize());
        assertEquals(3, board.getNeed());
    }
    
    @Test
    public void setCellWorks() {
        assertTrue(controls.setCell(0, 0, 1));
        controls.setCell(0, 0, 1);
        assertFalse(controls.setCell(0,0,-10));
        assertFalse(controls.setCell(1,1,26));
    }
    
    @Test
    public void aiTurnWorks() {
        controls.aiTurn();
        assertTrue(controls.printBoard().contains("X"));
    }
    
    @Test
    public void gameWonWorks() {
        controls.setCell(0, 0, -10);
        controls.setCell(0,1,1);
        controls.setCell(1,1,-10);
        assertFalse(controls.gameWon());
        controls.setCell(0,2,1);
        controls.setCell(2,2,-10);
        assertTrue(controls.gameWon());
    }
    
    @Test
    public void printBoardWorks() {
        controls.setCell(0,0,1);
        controls.setCell(0,1,-10);
        String print = controls.printBoard();
        assertEquals("|X|O| |\n| | | |\n| | | |\n", print);
    }
    
    @Test 
    public void whoWonWorks() {
        controls.setCell(0, 0, -10);
        controls.setCell(0,1,1);
        controls.setCell(1,1,-10);
        controls.setCell(0,2,1);
        controls.setCell(2,2,-10);
        assertTrue(controls.whoWon() == -10);
    }
    
    @Test
    public void movesLeftWorks() {
        controls.setCell(0, 0, -10);
        controls.setCell(0,1,1);
        controls.setCell(0,2,1);
        controls.setCell(1,0,1);
        controls.setCell(1,1,-10);
        controls.setCell(1,2,-10);
        assertTrue(controls.movesLeft());
        controls.setCell(2,1,1);
        controls.setCell(2,0,1);
        controls.setCell(2,2,-10);
        assertFalse(controls.movesLeft());
    }
}
