import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.kit.informatik.Board;
import edu.kit.informatik.TorusBoard;

class TorusBoardTest {

    private Board board18 = new TorusBoard(18);
    private Board board20 = new TorusBoard(20);

    /**
     * check all possible combinations in all horizontal rows of the torus board with board size 18
     */
    @Test
    public void testHorizontal18() {
        for (int k = 0; k < 18; k++) {
            for (int i = 0; i < 18; i++) {
                for (int j = i; j < i + 6; j++) {
                    board18.setState(String.valueOf(k), String.valueOf(j), 
                            String.valueOf(k), String.valueOf(j + 1), "P1");
                }
                assertTrue(board18.checkHorizontal(k, "P1"));
                board18 = new TorusBoard(18);
            }
        }
    }
    
    /**
     * check all possible combinations in all horizontal rows of the torus board with board size 20
     */
    @Test
    public void testHorizontal20() {
        for (int k = 0; k < 20; k++) {
            for (int i = 0; i < 20; i++) {
                for (int j = i; j < i + 6; j++) {
                    board20.setState(String.valueOf(k), String.valueOf(j), 
                            String.valueOf(k), String.valueOf(j + 1), "P1");
                }
                assertTrue(board20.checkHorizontal(k, "P1"));
                board20 = new TorusBoard(20);
            }
        }
    }

    /**
     * check all possible combinations in all vertical columns of the torus board with board size 18
     */
    @Test
    public void testVertical18() {
        for (int k = 0; k < 18; k++) {
            for (int i = 0; i < 18; i++) {
                for (int j = i; j < i + 6; j++) {
                    board18.setState(String.valueOf(j), String.valueOf(k), 
                            String.valueOf(j + 1), String.valueOf(k), "P1");
                }
                assertTrue(board18.checkVertical(k, "P1"));
                board18 = new TorusBoard(18);
            }
        }
    }
    
    /**
     * check all possible combinations in all vertical columns of the torus board with board size 20
     */
    @Test
    public void testVertical20() {
        for (int k = 0; k < 20; k++) {
            for (int i = 0; i < 20; i++) {
                for (int j = i; j < i + 6; j++) {
                    board20.setState(String.valueOf(j), String.valueOf(k), 
                            String.valueOf(j + 1), String.valueOf(k), "P1");
                }
                assertTrue(board20.checkVertical(k, "P1"));
                board20 = new TorusBoard(20);
            }
        }
    }

    /**
     * check all possible diagonal combinations in the torus board with board size 18
     */
    @Test
    public void testDiagonal18() {
        int startColumn = 0;
        while (startColumn < 18) {
            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 6; j = j + 2) {
                    board18.setState(String.valueOf(i + j), String.valueOf(j + startColumn), 
                            String.valueOf(i + j + 1), String.valueOf(j + startColumn + 1), "P1");
                }
                assertTrue(board18.checkDiagonal(i, startColumn, "P1"));
                board18 = new TorusBoard(18);
            }
            startColumn++;
        }
        
        //reverse diagonal
        startColumn = 0;
        while (startColumn < 18) {
            for (int i = 17; i > -1; i--) {
                for (int j = 0; j < 6; j = j + 2) {
                    board18.setState(String.valueOf(i - j), String.valueOf(j + startColumn), 
                            String.valueOf(i - (j + 1)), String.valueOf(j + startColumn + 1), "P1");
                }
                assertTrue(board18.checkDiagonal(i, startColumn, "P1"));
                board18 = new TorusBoard(18);
            }
            startColumn++;
        }
    }
    
    /**
     * check all possible diagonal combinations in the torus board with board size 20
     */
    @Test
    public void testDiagonal20() {
        int startColumn = 0;
        while (startColumn < 20) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 6; j = j + 2) {
                    board20.setState(String.valueOf(i + j), String.valueOf(j + startColumn), 
                            String.valueOf(i + j + 1), String.valueOf(j + startColumn + 1), "P1");
                }
                assertTrue(board20.checkDiagonal(i, startColumn, "P1"));
                board20 = new TorusBoard(20);
            }
            startColumn++;
        }
        
      //reverse diagonal
        startColumn = 0;
        while (startColumn < 20) {
            for (int i = 19; i >= 0; i--) {
                for (int j = 0; j < 6; j = j + 2) {
                    board20.setState(String.valueOf(i - j), String.valueOf(j + startColumn), 
                            String.valueOf(i - (j + 1)), String.valueOf(j + startColumn + 1), "P1");
                }
                assertTrue(board20.checkDiagonal(i, startColumn, "P1"));
                board20 = new TorusBoard(20);
            }
            startColumn++;
        }
    }

    /**
     * Method to test that game returns "draw" when board is full with board size 18
     */
    @Test
    public void testDraw18() {
        int row = 0;
        int turn = 1;
        while (row < 18) {
            for (int column = 0; column < 18; column = column + 2) {
                int playerNumber = turn % 3;
                if (playerNumber == 0) {
                    playerNumber = 3;
                }
                board18.setState(String.valueOf(row), String.valueOf(column), 
                        String.valueOf(row), String.valueOf(column + 1), "P" + String.valueOf(playerNumber));
                turn++;
            }
            row++;
        }
        assertTrue(board18.isFull());
    }
    
    /**
     * Method to test that game returns "draw" when board is full with board size 20
     */
    @Test
    public void testDraw20() {
        int row = 0;
        int turn = 1;
        while (row < 20) {
            for (int column = 0; column < 20; column = column + 2) {
                int playerNumber = turn % 3;
                if (playerNumber == 0) {
                    playerNumber = 3;
                }
                board20.setState(String.valueOf(row), String.valueOf(column), 
                        String.valueOf(row), String.valueOf(column + 1), "P" + String.valueOf(playerNumber));
                turn++;
            }
            row++;
        }
        assertTrue(board20.isFull());
    }
}
