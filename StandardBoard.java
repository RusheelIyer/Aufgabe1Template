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
    public boolean horizontal(int row, String playerSymbol) {
        
        String[] check = new String[6];
        int trues = 0;
        
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
        return false;
    }
    
    /**
     * Check the vertical column on which the player last played, to see if the user has won with their last turn
     * 
     * @param column represents the column of the position in which the player last placed their piece
     * @param playerSymbol represents the symbol of the player to last play
     * @return true if the player has won, false if not
     */
    public boolean vertical(int column, String playerSymbol) {
        
        String[] check = new String[6];
        int trues = 0;
        
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
        return false;
        
    }
    
}
