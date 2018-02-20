import static org.junit.jupiter.api.Assertions.*;

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
        for (int k = 0; k < 18; k++) {
            for (int i = 0; i < 13; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(k), String.valueOf(j), 
                            String.valueOf(k), String.valueOf(j + 1), "P1");
                }
                assertTrue(board.checkHorizontal(k, "P1"));
                board = new StandardBoard(18);
            }
        }
    }
    
    /**
     * check all possible combinations in all horizontal rows of the standard board with board size 20
     */
    @Test
    public void testHorizontal20() {
        Board board  = new StandardBoard(20);
        for (int k = 0; k < 20; k++) {
            for (int i = 0; i < 15; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(k), String.valueOf(j), 
                            String.valueOf(k), String.valueOf(j + 1), "P1");
                }
                assertTrue(board.checkHorizontal(k, "P1"));
                board = new StandardBoard(20);
            }
        }
    }

    /**
     * check all possible combinations in all vertical columns of the standard board with board size 18
     */
    @Test
    public void testVertical18() {
        Board board  = new StandardBoard(18);
        for (int k = 0; k < 18; k++) {
            for (int i = 0; i < 13; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(j), String.valueOf(k), 
                            String.valueOf(j + 1), String.valueOf(k), "P1");
                }
                assertTrue(board.checkVertical(k, "P1"));
                board = new StandardBoard(18);
            }
        }
    }
    
    /**
     * check all possible combinations in all vertical columns of the standard board with board size 20
     */
    @Test
    public void testVertical20() {
        Board board  = new StandardBoard(20);
        for (int k = 0; k < 20; k++) {
            for (int i = 0; i < 15; i++) {
                for (int j = i; j < i + 6; j++) {
                    board.setState(String.valueOf(j), String.valueOf(k), 
                            String.valueOf(j + 1), String.valueOf(k), "P1");
                }
                assertTrue(board.checkVertical(k, "P1"));
                board = new StandardBoard(20);
            }
        }
    }

    /**
     * check all possible diagonal combinations in the standard board with board size 18
     */
    @Test
    public void testDiagonal18() {
        Board board  = new StandardBoard(18);
        int startColumn = 0;
        while (startColumn < 13) {
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 6; j = j + 2) {
                    board.setState(String.valueOf(i + j), String.valueOf(j + startColumn), 
                            String.valueOf(i + j + 1), String.valueOf(j + startColumn + 1), "P1");
                }
                assertTrue(board.checkDiagonal(i, startColumn, "P1"));
                board = new StandardBoard(18);
            }
            startColumn++;
        }

        //reverse diagonal
        startColumn = 0;
        while (startColumn < 13) {
            for (int i = 17; i >= 5; i--) {
                for (int j = 0; j < 6; j = j + 2) {
                    board.setState(String.valueOf(i - j), String.valueOf(j + startColumn), 
                            String.valueOf(i - (j + 1)), String.valueOf(j + startColumn + 1), "P1");
                }
                assertTrue(board.checkDiagonal(i, startColumn, "P1"));
                board = new StandardBoard(18);
            }
            startColumn++;
        }
    }
    
    /**
     * check all possible diagonal combinations in the standard board with board size 20
     */
    @Test
    public void testDiagonal20() {
        Board board  = new StandardBoard(20);
        int startColumn = 0;
        while (startColumn < 15) {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 6; j = j + 2) {
                    board.setState(String.valueOf(i + j), String.valueOf(j + startColumn), 
                            String.valueOf(i + j + 1), String.valueOf(j + startColumn + 1), "P1");
                }
                assertTrue(board.checkDiagonal(i, startColumn, "P1"));
                board = new StandardBoard(20);
            }
            startColumn++;
        }

        //reverse diagonal
        startColumn = 0;
        while (startColumn < 13) {
            for (int i = 19; i >= 5; i--) {
                for (int j = 0; j < 6; j = j + 2) {
                    board.setState(String.valueOf(i - j), String.valueOf(j + startColumn), 
                            String.valueOf(i - (j + 1)), String.valueOf(j + startColumn + 1), "P1");
                }
                assertTrue(board.checkDiagonal(i, startColumn, "P1"));
                board = new StandardBoard(20);
            }
            startColumn++;
        }
    }

}
