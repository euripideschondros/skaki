/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamejava;

/**
 *
 * @author akis
 */
public abstract class Piece{
    protected Location loc;
    protected Board x;
    protected ColorEnum color;

    public Piece(Location loc,Board x,ColorEnum color){
        this.loc = loc;
        this.x = x;
        this.color = color;
    }
    abstract void moveTo(Location loc) throws Exception;

    @Override
    abstract public String toString();
    
    

}
