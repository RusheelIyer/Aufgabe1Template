import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.kit.informatik.Board;
import edu.kit.informatik.StandardBoard;

class StandardBoardTest {

    /**
     * check all possible combinations in all horizontal rows of the standard board with board size 18
     */
    @Test
    public void testHorizontal18() {
        Board board  = new StandardBoard(18);
        int trues = 0;
        for (int k = 0; k < 18; k++) {
            for (int i = 0; i < 13; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(k), String.valueOf(j), 
                            String.valueOf(k), String.valueOf(j + 1), "P1");
                }
                if (true == board.checkHorizontal(k, "P1")) {
                    trues++;
                }
                board = new StandardBoard(18);
            }
        }
        assertTrue(trues == 234);
    }
    
    /**
     * check all possible combinations in all horizontal rows of the standard board with board size 20
     */
    @Test
    public void testHorizontal20() {
        Board board  = new StandardBoard(20);
        int trues = 0;
        for (int k = 0; k < 20; k++) {
            for (int i = 0; i < 15; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(k), String.valueOf(j), 
                            String.valueOf(k), String.valueOf(j + 1), "P1");
                }
                if (true == board.checkHorizontal(k, "P1")) {
                    trues++;
                }
                board = new StandardBoard(20);
            }
        }
        assertTrue(trues == 300);
    }

    /**
     * check all possible combinations in all vertical columns of the standard board with board size 18
     */
    @Test
    public void testVertical18() {
        Board board  = new StandardBoard(18);
        int trues = 0;
        for (int k = 0; k < 18; k++) {
            for (int i = 0; i < 13; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(j), String.valueOf(k), 
                            String.valueOf(j + 1), String.valueOf(k), "P1");
                }
                if (true == board.checkVertical(k, "P1")) {
                    trues++;
                }
                board = new StandardBoard(18);
            }
        }
        assertTrue(trues == 234);
    }
    
    /**
     * check all possible combinations in all vertical columns of the standard board with board size 20
     */
    @Test
    public void testVertical20() {
        Board board  = new StandardBoard(20);
        int trues = 0;
        for (int k = 0; k < 20; k++) {
            for (int i = 0; i < 15; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(j), String.valueOf(k), 
                            String.valueOf(j + 1), String.valueOf(k), "P1");
                }
                if (true == board.checkVertical(k, "P1")) {
                    trues++;
                }
                board = new StandardBoard(20);
            }
        }
        assertTrue(trues == 300);
    }

}
