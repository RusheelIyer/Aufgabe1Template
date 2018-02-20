package edu.kit.informatik;

public class StandardBoard extends Board {
    
    /**
     * Constructor for the Standard Board Class
     * 
     * @param boardSize represents the desired board dimensions indicated by the user. 
     */
    public StandardBoard(int boardSize) {
        super(boardSize);
    }
    
    /**
     * Check the horizontal row on which the player last played, to see if the user has won with their last turn
     * 
     * @param row represents the row of the position in which the player last placed their piece
     * @param playerSymbol represents the symbol of the player to last play
     * @return true if the player has won, false if not
     */
    public boolean checkHorizontal(int row, String playerSymbol) {
        
        String[] check = new String[6];
        int trues = 0;
        
        for (int i = 0; i < this.getBoardSize() - 5; i++) {
            check[0] = super.getState(String.valueOf(row), String.valueOf(i));
            check[1] = super.getState(String.valueOf(row), String.valueOf(i + 1));
            check[2] = super.getState(String.valueOf(row), String.valueOf(i + 2));
            check[3] = super.getState(String.valueOf(row), String.valueOf(i + 3));
            check[4] = super.getState(String.valueOf(row), String.valueOf(i + 4));
            check[5] = super.getState(String.valueOf(row), String.valueOf(i + 5));
            
            for (int j = 0; j < check.length; j++) {
                if (check[j].equals(playerSymbol)) {
                    trues++;
                }
            }
            if (trues == 6) {
                return true;
            }
            trues = 0;
        }
        return false;
    }
    
    /**
     * Check the vertical column on which the player last played, to see if the user has won with their last turn
     * 
     * @param column represents the column of the position in which the player last placed their piece
     * @param playerSymbol represents the symbol of the player to last play
     * @return true if the player has won, false if not
     */
    public boolean checkVertical(int column, String playerSymbol) {
        
        String[] check = new String[6];
        int trues = 0;
        
        for (int i = 0; i < this.getBoardSize() - 5; i++) {
            check[0] = super.getState(String.valueOf(i), String.valueOf(column));
            check[1] = super.getState(String.valueOf(i + 1), String.valueOf(column));
            check[2] = super.getState(String.valueOf(i + 2), String.valueOf(column));
            check[3] = super.getState(String.valueOf(i + 3), String.valueOf(column));
            check[4] = super.getState(String.valueOf(i + 4), String.valueOf(column));
            check[5] = super.getState(String.valueOf(i + 5), String.valueOf(column));
            
            for (int j = 0; j < check.length; j++) {
                if (check[j].equals(playerSymbol)) {
                    trues++;
                }
            }
            if (trues == 6) {
                return true;
            }
            trues = 0;
        }
        return false;
        
    }
    
    /**
     * Check the diagonal line on which the player last played, to see if the user has won with their last turn
     * 
     * @param row represents the row of the position in which the player last placed their piece
     * @param column represents the column of the position in which the player last placed their piece
     * @param playerSymbol represents the symbol of the player to last play
     * @return true if the player has won, false if not
     */
    public boolean checkDiagonal(int row, int column, String playerSymbol) {
        
        String[] check = new String[6];
        int trues = 0;
        int playerRow = row;
        int playerColumn = column;
        
        while (playerRow != 0 && playerColumn != 0) {
            playerRow--;
            playerColumn--;
        }
        
        while ((playerRow < (this.getBoardSize() - 5)) && (playerColumn < (this.getBoardSize() - 5))) {
            check[0] = super.getState(String.valueOf(playerRow), String.valueOf(playerColumn));
            check[1] = super.getState(String.valueOf(playerRow + 1), String.valueOf(playerColumn + 1));
            check[2] = super.getState(String.valueOf(playerRow + 2), String.valueOf(playerColumn + 2));
            check[3] = super.getState(String.valueOf(playerRow + 3), String.valueOf(playerColumn + 3));
            check[4] = super.getState(String.valueOf(playerRow + 4), String.valueOf(playerColumn + 4));
            check[5] = super.getState(String.valueOf(playerRow + 5), String.valueOf(playerColumn + 5));
            for (int j = 0; j < check.length; j++) {
                if (check[j].equals(playerSymbol)) {
                    trues++;
                }
            }
            if (trues == 6) {
                return true;
            }
            trues = 0;
            playerRow++;
            playerColumn++;
        }

        //checking diagonals in other direction
        playerRow = row;
        playerColumn = column;
        while ((playerRow != 0) && (playerColumn != (this.getBoardSize() - 1))) {
            playerRow--;
            playerColumn++;
        }
        
        while ((playerRow <  (this.getBoardSize() - 5)) && (playerColumn > 4)) {
            check[0] = super.getState(String.valueOf(playerRow), String.valueOf(playerColumn));
            check[1] = super.getState(String.valueOf(playerRow + 1), String.valueOf(playerColumn - 1));
            check[2] = super.getState(String.valueOf(playerRow + 2), String.valueOf(playerColumn - 2));
            check[3] = super.getState(String.valueOf(playerRow + 3), String.valueOf(playerColumn - 3));
            check[4] = super.getState(String.valueOf(playerRow + 4), String.valueOf(playerColumn - 4));
            check[5] = super.getState(String.valueOf(playerRow + 5), String.valueOf(playerColumn - 5));
            for (int j = 0; j < check.length; j++) {
                if (check[j].equals(playerSymbol)) {
                    trues++;
                }
            }
            if (trues == 6) {
                return true;
            }
            trues = 0;
            playerRow++;
            playerColumn--;
        }
        
        return false;
    }
}