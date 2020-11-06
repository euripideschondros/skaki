/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamejava;

/**
 *
 * @author akis
 */
public class Rook extends Piece {

    public Rook(Location loc,Board x,ColorEnum color){
        super(loc,x,color);

    }
    @Override
    void moveTo(Location loc1) throws Exception {
        boolean flag;
        if((loc.c == loc1.c )){
            flag = x.freeVerticalPath(loc, loc1);
            if(flag){
                if(x.matrix[loc1.r][loc1.c]==null ){
                    x.movePiece(loc, loc1);
                    return;
                }
                if(x.matrix[loc1.r][loc1.c].color != color){
                    x.movePiece(loc, loc1);
                    return;
                }
                throw new Exception("Wrong Input");
            }else{
                throw new Exception("Wrong Input");
            }
        }
        if((loc.r == loc1.r))
        {
            flag = x.freeHorizontalPath(loc, loc1);
            if(flag){
                if(x.matrix[loc1.r][loc1.c]==null ){
                    x.movePiece(loc, loc1);
                    return;
                }
                if(x.matrix[loc1.r][loc1.c].color != color){
                    x.movePiece(loc, loc1);
                    return;
                }
                throw new Exception("Wrong Input");
            }else{
                throw new Exception("Wrong Input");
            }
        }
            throw new Exception("Wrong Input");
    }

    @Override
    public String toString() {
        if(color == ColorEnum.BLACK){
            return "r";
        }else{
            return "R";
        }

    }

}
