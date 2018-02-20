import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.kit.informatik.Board;
import edu.kit.informatik.TorusBoard;

class TorusBoardTest {

    /**
     * check all possible combinations in all horizontal rows of the torus board with board size 18
     */
    @Test
    public void testHorizontal18() {
        Board board  = new TorusBoard(18);
        for (int k = 0; k < 18; k++) {
            for (int i = 0; i < 18; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(k), String.valueOf(j), 
                            String.valueOf(k), String.valueOf(j + 1), "P1");
                }
                assertTrue(board.checkHorizontal(k, "P1"));
                board = new TorusBoard(18);
            }
        }
    }
    
    /**
     * check all possible combinations in all horizontal rows of the torus board with board size 20
     */
    @Test
    public void testHorizontal20() {
        Board board  = new TorusBoard(20);
        for (int k = 0; k < 20; k++) {
            for (int i = 0; i < 20; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(k), String.valueOf(j), 
                            String.valueOf(k), String.valueOf(j + 1), "P1");
                }
                assertTrue(board.checkHorizontal(k, "P1"));
                board = new TorusBoard(20);
            }
        }
    }

    /**
     * check all possible combinations in all vertical columns of the torus board with board size 18
     */
    @Test
    public void testVertical18() {
        Board board  = new TorusBoard(18);
        for (int k = 0; k < 18; k++) {
            for (int i = 0; i < 18; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(j), String.valueOf(k), 
                            String.valueOf(j + 1), String.valueOf(k), "P1");
                }
                assertTrue(board.checkVertical(k, "P1"));
                board = new TorusBoard(18);
            }
        }
    }
    
    /**
     * check all possible combinations in all vertical columns of the torus board with board size 20
     */
    @Test
    public void testVertical20() {
        Board board  = new TorusBoard(20);
        for (int k = 0; k < 20; k++) {
            for (int i = 0; i < 20; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(j), String.valueOf(k), 
                            String.valueOf(j + 1), String.valueOf(k), "P1");
                }
                assertTrue(board.checkVertical(k, "P1"));
                board = new TorusBoard(20);
            }
        }
    }

}
