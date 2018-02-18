package edu.kit.informatik;

public class TorusBoard extends Board {

    /**
     * Constructor for a TorusBoard
     * 
     * @param boardSize represents the dimensions of the new playing surface to be created.
     */
    public TorusBoard(int boardSize) {
        super(boardSize);
    }
    
    /**
     * get the content of the position requested by the player
     * 
     * @param rowNumber represents the row number of the desired position
     * @param columnNumber represents the column number of the desired position 
     * @return the state of the field
     */
    @Override
    public String getState(String rowNumber, String columnNumber) {
        
        int row = Integer.parseInt(rowNumber);
        int column = Integer.parseInt(columnNumber);
        if (row < 0 || row >= this.getBoardSize()) {
            row = row % this.getBoardSize();
            if (row < 0) {
                row = row + this.getBoardSize();
            }
        }
        if (column < 0 || column >= this.getBoardSize()) {
            column = column % this.getBoardSize();
            if (column < 0) {
                column = column + this.getBoardSize();
            }
        }
        return super.getState(String.valueOf(row), String.valueOf(column));  
    }
    
    /**
     * Place a player's piece in the desired positions
     * 
     * @param rowOne
     * @param columnOne
     * @param rowTwo
     * @param columnTwo
     * @param content
     */
    @Override
    public void setState(String rowOne, String columnOne, String rowTwo, String columnTwo, String content) {
        
        int rOne = Integer.parseInt(rowOne);
        int rTwo = Integer.parseInt(rowTwo);
        int cOne = Integer.parseInt(columnOne);
        int cTwo = Integer.parseInt(columnTwo);
        
        if (rOne < 0 || rOne >= this.getBoardSize()) {
            rOne = rOne % this.getBoardSize();
            if (rOne < 0) {
                rOne = rOne + this.getBoardSize();
            }
        }
        if (cOne < 0 || cOne >= this.getBoardSize()) {
            cOne = cOne % this.getBoardSize();
            if (cOne < 0) {
                cOne = cOne + this.getBoardSize();
            }
        }
        if (rTwo < 0 || rTwo >= this.getBoardSize()) {
            rTwo = rTwo % this.getBoardSize();
            if (rTwo < 0) {
                rTwo = rTwo + this.getBoardSize();
            }
        }
        if (cTwo < 0 || cTwo >= this.getBoardSize()) {
            cTwo = cTwo % this.getBoardSize();
            if (cTwo < 0) {
                cTwo = cTwo + this.getBoardSize();
            }
        }
        super.setState(String.valueOf(rOne), String.valueOf(cOne), String.valueOf(rTwo), String.valueOf(cTwo), content);
    }
    
    /**
     * Check the horizontal row on which the player last played, to see if the user has won with their last turn
     * 
     * @param row represents the row of the position in which the player last placed their piece
     * @param playerSymbol represents the symbol of the player to last play
     * @return true if the player has won, false if not
     */
    @Override
    public boolean horizontal(int row, String playerSymbol) {
        
        int size = this.getBoardSize();
        String[] check = new String[6];
        int trues = 0;
        
        for (int i = 0; i < this.getBoardSize(); i++) {
            check[0] = super.getState(String.valueOf(row % size), String.valueOf(i % size));
            check[1] = super.getState(String.valueOf(row % size), String.valueOf((i + 1) % size));
            check[2] = super.getState(String.valueOf(row % size), String.valueOf((i + 2) % size));
            check[3] = super.getState(String.valueOf(row % size), String.valueOf((i + 3) % size));
            check[4] = super.getState(String.valueOf(row % size), String.valueOf((i + 4) % size));
            check[5] = super.getState(String.valueOf(row % size), String.valueOf((i + 5) % size));
            
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
    @Override
    public boolean vertical(int column, String playerSymbol) {
        
        int size = this.getBoardSize();
        String[] check = new String[6];
        int trues = 0;
        
        for (int i = 0; i < this.getBoardSize(); i++) {
            check[0] = super.getState(String.valueOf(i % size), String.valueOf(column % size));
            check[1] = super.getState(String.valueOf((i + 1) % size), String.valueOf(column % size));
            check[2] = super.getState(String.valueOf((i + 2) % size), String.valueOf(column % size));
            check[3] = super.getState(String.valueOf((i + 3) % size), String.valueOf(column % size));
            check[4] = super.getState(String.valueOf((i + 4) % size), String.valueOf(column % size));
            check[5] = super.getState(String.valueOf((i + 5) % size), String.valueOf(column % size));
            
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
    public boolean diagonal(int row, int column, String playerSymbol) {
        
        String[] check = new String[6];
        int trues = 0;
        int playerRow = row;
        int playerColumn = column;
        int size = this.getBoardSize();
        
        while (playerRow != 0 && playerColumn != 0) {
            playerRow--;
            playerColumn--;
        }
        
        int index = 0;
        while (index < this.getBoardSize()) {
            check[0] = super.getState(String.valueOf(playerRow % size), String.valueOf(playerColumn % size));
            check[1] = super.getState(String.valueOf((playerRow + 1) % size), 
                    String.valueOf((playerColumn + 1) % size));
            check[2] = super.getState(String.valueOf((playerRow + 2) % size),
                    String.valueOf((playerColumn + 2) % size));
            check[3] = super.getState(String.valueOf((playerRow + 3) % size),
                    String.valueOf((playerColumn + 3) % size));
            check[4] = super.getState(String.valueOf((playerRow + 4) % size),
                    String.valueOf((playerColumn + 4) % size));
            check[5] = super.getState(String.valueOf((playerRow + 5) % size),
                    String.valueOf((playerColumn + 5) % size));
            for (int j = 0; j < check.length; j++) {
                if (check[j].equals(playerSymbol)) {
                    trues++;
                }
            }
            if (trues == 6) {
                return true;
            }
            trues = 0;
            index++;
            playerRow++;
            playerColumn++;
        }

        //checking diagonals in other direction
        playerRow = row;
        playerColumn = column;
        index = 0;
        while ((playerRow != 0) && (playerColumn != (this.getBoardSize() - 1))) {
            playerRow--;
            playerColumn++;
        }
        
        while (index < this.getBoardSize()) {
            check[0] = super.getState(String.valueOf(playerRow % size), String.valueOf(playerColumn % size));
            check[1] = super.getState(String.valueOf((playerRow + 1) % size), 
                    String.valueOf(((((playerColumn - 1) % size)) + size) % size));
            check[2] = super.getState(String.valueOf((playerRow + 2) % size),
                    String.valueOf(((((playerColumn - 2) % size)) + size) % size));
            check[3] = super.getState(String.valueOf((playerRow + 3) % size),
                    String.valueOf(((((playerColumn - 3) % size)) + size) % size));
            check[4] = super.getState(String.valueOf((playerRow + 4) % size),
                    String.valueOf(((((playerColumn - 4) % size)) + size) % size));
            check[5] = super.getState(String.valueOf((playerRow + 5) % size),
                    String.valueOf(((((playerColumn - 5) % size)) + size) % size));
            for (int j = 0; j < check.length; j++) {
                if (check[j].equals(playerSymbol)) {
                    trues++;
                }
            }
            if (trues == 6) {
                return true;
            }
            trues = 0;
            index++;
            playerRow++;
            playerColumn--;
        }
        return false;
    }
}