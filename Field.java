package edu.kit.informatik;

public class Field {
    
    private String content;
    
    /**
     * Field constructor sets the content of a field object to ** (Empty) when initialised.
     */
    public Field() {
        this.content = "**";
    }
    
    /**
     * get the content of the Field object on which the method is called
     * 
     * @return content of the Field
     */
    public String getContent() {
        return this.content;
    }
    
    /**
     * Change the content of the Field to the appropriate player's playing piece 
     * 
     * @param piece represents the piece of the player
     */
    public void setContent(String piece) {
        this.content = piece;
    }
}
