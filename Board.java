package edu.kit.informatik;

public abstract class Board {
        
    private Field[][] board;
    private int boardSize;
    private int turns;
    private boolean gameWon;
    
    /**
     * Constructor for a board
     * 
     * @param boardSize represents the desired dimensions/size of the board
     */
    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.board = new Field[boardSize][boardSize];
        this.turns = 1;
        this.gameWon = false;
        
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.board[i][j] = new Field();
            }
        }
    }
    
    /**
     * get the content of the position requested by the player
     * 
     * @param rowNumber represents the row number of the desired position
     * @param columnNumber represents the column number of the desired position 
     * @return the state of the field
     */
    public String getState(String rowNumber, String columnNumber) {
        
        int row = Integer.parseInt(rowNumber);
        int column = Integer.parseInt(columnNumber);
        
        try {
            if (row < 0 || row >= this.boardSize || column < 0 || column >= this.boardSize) {
                throw new IllegalArgumentException();
            } else {
              return this.board[row][column].getContent();  
            }
        } catch (IllegalArgumentException e) {
            return "Error, Please enter a valid row and column number";
        }
    }
    
    /**
     * Place a player's piece in the desired positions
     * 
     * @param rowOne represents the row number of the first piece
     * @param columnOne represents the column number of the first piece
     * @param rowTwo represents the row number of the second piece
     * @param columnTwo represents the column number of the second piece
     * @param content represents the current player, i.e P1/P2/P3/P4
     */
    public void setState(String rowOne, String columnOne, String rowTwo, String columnTwo, String content) {
        
        int rOne = Integer.parseInt(rowOne);
        int cOne = Integer.parseInt(columnOne);
        int rTwo = Integer.parseInt(rowTwo);
        int cTwo = Integer.parseInt(columnTwo);
        
        try {
            if (((rOne == rTwo) && (cOne == cTwo)) || rOne < 0 || rOne >= this.boardSize || cOne < 0 
                    || cOne >= this.boardSize || rTwo < 0 || rTwo >= this.boardSize || cTwo < 0 
                    || cTwo >= this.boardSize || !this.board[rOne][cOne].getContent().equals("**")
                    || !this.board[rTwo][cTwo].getContent().equals("**")) {
                throw new IllegalArgumentException();
            } else {
                this.turns = this.turns + 1;
                this.board[rOne][cOne].setContent(content);
                this.board[rTwo][cTwo].setContent(content);
                
                if (this.checkWin(rOne, cOne, rTwo, cTwo, content))  {
                    Terminal.printLine(content + " wins");
                } else if (this.isFull()) {
                    Terminal.printLine("draw");
                } else {
                    Terminal.printLine("OK");
                }
            }
        } catch (IllegalArgumentException e) {
            Terminal.printError("Please enter a valid row and column number");
        }
    }

    /**
     * get the size of the board for access in child class
     * 
     * @return the size/dimensions of the board
     */
    protected int getBoardSize() {
        return boardSize;
    }
    
    /**
     * Get the value of turns, so, find out number of turns played
     * 
     * @return number of turns played so far
     */
    public int getTurns() {
        return this.turns;
    }
    
    /**
     * Get the value of gameWon, so, find out if the game has been won yet or not
     * 
     * @return true if the game has been won, false if not
     */
    public boolean getWon() {
        return this.gameWon;
    }
    
    /**
     * Checks to see if there are any empty (**) fields on the board
     * 
     * @return true if there are no fields empty.
     */
    public final boolean isFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (this.board[i][j].getContent().equals("**")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Check the horizontal row on which the player last played, to see if the user has won with their last turn
     * 
     * @param row represents the row of the position in which the player last placed their piece
     * @param playerSymbol represents the symbol of the player to last play
     * @return true if the player has won, false if not
     */
    public abstract boolean horizontal(int row, String playerSymbol);
    
    /**
     * Check the vertical column on which the player last played, to see if the user has won with their last turn
     * 
     * @param column represents the column number of the position in which the player last placed their piece
     * @param playerSymbol represents the symbol of the player to last play
     * @return true if the player has won, false if not
     */
    public abstract boolean vertical(int column, String playerSymbol);
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
        
        while (playerRow != 0 && playerColumn != 0) {
            playerRow--;
            playerColumn--;
        }
        
        while ((playerRow < (this.getBoardSize() - 5)) && (playerColumn < (this.getBoardSize() - 5))) {
            check[0] = this.board[playerRow][playerColumn].getContent();
            check[1] = this.board[playerRow + 1][playerColumn + 1].getContent();
            check[2] = this.board[playerRow + 2][playerColumn + 2].getContent();
            check[3] = this.board[playerRow + 3][playerColumn + 3].getContent();
            check[4] = this.board[playerRow + 4][playerColumn + 4].getContent();
            check[5] = this.board[playerRow + 5][playerColumn + 5].getContent();
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
        return false;
    }
    
    /**
     * Combining the horizontal, vertical and diagonal methods to check if the player has one
     * 
     * @param rOne represents the row of the first position in which the player placed his piece
     * @param cOne represents the column of the first position in which the player placed his piece
     * @param rTwo represents the row of the second position in which the player placed his piece
     * @param cTwo represents the column of the second position in which the player placed his piece
     * @param content represents the player who last played
     * @return true if player has won, false if not
     */
    public final boolean checkWin(int rOne, int cOne, int rTwo, int cTwo, String content) {
        
        if (this.diagonal(rOne, cOne, content) || this.diagonal(rTwo, cTwo, content)
                || this.horizontal(rOne, content) || this.horizontal(rTwo, content)
                || this.vertical(cOne, content) || this.vertical(cTwo, content)) {
            this.gameWon = true;
            return true;
        }
        return false;
    }
    
    /**
     * Method to print out the desired row
     * 
     * @param row represents the desired row
     */
    public void rowPrint(int row) {
       try {
           if (row >= this.boardSize || row < 0) {
               throw new IllegalArgumentException();
           } else {
               String outputLine = "";
               for (int i = 0; i < this.boardSize; i++) {
                   outputLine += this.getState(String.valueOf(row), String.valueOf(i)) + " ";
               }
               Terminal.printLine(outputLine);
           }
       } catch (IllegalArgumentException e) {
           Terminal.printError("Please enter a valid row number");
       }
    }
    
    /**
     * Method to print out the desired column
     * 
     * @param column represents the desired column
     */
    public void columnPrint(int column) {
        try {
            if (column >= this.boardSize || column < 0) {
                throw new IllegalArgumentException();
            } else {
                String outputLine = "";
                for (int i = 0; i < this.boardSize; i++) {
                    outputLine += this.getState(String.valueOf(i), String.valueOf(column)) + " ";
                }
                Terminal.printLine(outputLine);
            }
        } catch (IllegalArgumentException e) {
            Terminal.printError("Please enter a valid column number");
        }
    }
    
    /**
     * Method to print the playing surface in it's current state.
     */
    public final void print() {
        for (int i = 0; i < this.boardSize; i++) {
            String outputLine = "";
            for (int j = 0; j < this.boardSize; j++) {
                outputLine += this.board[i][j].getContent() + " ";
                }
                Terminal.printLine(outputLine);
            }
        }
        
    }
