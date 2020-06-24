import controls.*;
import domain.Board;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author vpuurone
 */
public class AITest {
    
    private Controls controls;
    private AI ai;
    private Board board;
    private Board board4;
    
    @Before
    public void setUp() {
        board = new Board(3,3);
        board4 = new Board(4,3);
    }
    
    @Test
    public void aiStopsOpponentFromWinning() {
        // 3x3 board
       board.setCell(0, 0, -10);
       board.setCell(0,2,1);
       board.setCell(1,1,-10);
       String move = AI.bestMove(board);
       assertEquals("2,2", move);
       
       // 4x4 board with 3 win
       board4.setCell(1,0,-10);
       board4.setCell(1,1,-10);
       board.setCell(2,1,1);
       
       move = AI.bestMove(board4);
       assertEquals("1,2", move);
    }
    
    @Test
    public void aiWinsBeforeStoppingOpponent() {
        board.setCell(0, 0, -10);
        board.setCell(0, 2, 1);
        board.setCell(1, 1, -10);
        board.setCell(2, 2, 1);
        
        String move = AI.bestMove(board);
        assertEquals("1,2", move);
        
        board4.setCell(0, 0, -10);
        board4.setCell(0,1,1);
        board4.setCell(1,0,-10);
        board4.setCell(0,2,1);
        
        move = AI.bestMove(board4);
        assertEquals("0,3", move);
    }
    
}
