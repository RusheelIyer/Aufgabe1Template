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
        
        String[] check = new String[6];
        int trues = 0;
        int rowNumber = row;
        if (rowNumber >= this.getBoardSize()) {
            rowNumber = row % this.getBoardSize();
        }
        
        for (int i = 0; i < this.getBoardSize() - 5; i++) {
            check[0] = this.getBoard()[row][i].getContent();
            check[1] = this.getBoard()[row][i + 1].getContent();
            check[2] = this.getBoard()[row][i + 2].getContent();
            check[3] = this.getBoard()[row][i + 3].getContent();
            check[4] = this.getBoard()[row][i + 4].getContent();
            check[5] = this.getBoard()[row][i + 5].getContent();
            
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
        
        int index = 0;
        while (index < 5) {
            int column = this.getBoardSize() - 5 + index;
            int internIndex = 0;
            while (column < this.getBoardSize()) {
                check[internIndex] = super.getState(String.valueOf(rowNumber), String.valueOf(column));
                internIndex++;
                column++;
            }
            while (internIndex < 6) {
                check[internIndex] = super.getState(String.valueOf(rowNumber), 
                        String.valueOf(column % this.getBoardSize()));
                internIndex++;
                column++;
            }
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
        
        String[] check = new String[6];
        int trues = 0;
        int columnNumber = column;
        if (columnNumber >= this.getBoardSize()) {
            columnNumber = column % this.getBoardSize();
        }
        
        for (int i = 0; i < this.getBoardSize() - 5; i++) {
            check[0] = this.getBoard()[i][column].getContent();
            check[1] = this.getBoard()[i + 1][column].getContent();
            check[2] = this.getBoard()[i + 2][column].getContent();
            check[3] = this.getBoard()[i + 3][column].getContent();
            check[4] = this.getBoard()[i + 4][column].getContent();
            check[5] = this.getBoard()[i + 5][column].getContent();
            
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
        
        int index = 0;
        while (index < 5) {
            int row = this.getBoardSize() - 5 + index;
            int internIndex = 0;
            while (row < this.getBoardSize()) {
                check[internIndex] = super.getState(String.valueOf(row), String.valueOf(columnNumber));
                internIndex++;
                row++;
            }
            while (internIndex < 6) {
                check[internIndex] = super.getState(String.valueOf(row % this.getBoardSize()), 
                        String.valueOf(columnNumber));
                internIndex++;
                row++;
            }
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
        }
        return false;
    }
    
    /**
     * Method to print out the desired row
     * 
     * @param row represents the desired row
     */
    @Override
    public void rowPrint(int row) {
       
       int rowNumber = row; 
       if (row < 0 || row >= this.getBoardSize()) {
           rowNumber = rowNumber % this.getBoardSize();
           if (rowNumber < 0) {
               rowNumber = rowNumber + this.getBoardSize(); 
           }
       }
       super.rowPrint(rowNumber);
    }
    
    /**
     * Method to print out the desired column
     * 
     * @param column represents the desired column
     */
    @Override
    public void columnPrint(int column) { 
        
        int columnNumber = column;
        if (column < 0 || column >= this.getBoardSize()) {
            columnNumber = columnNumber % this.getBoardSize();
            if (columnNumber < 0) {
                columnNumber = columnNumber + this.getBoardSize(); 
            }
        }
        super.columnPrint(columnNumber);
    }

}
