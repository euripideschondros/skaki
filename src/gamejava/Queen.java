/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamejava;

/**
 *
 * @author akis
 */
public class Queen extends Piece {

   public Queen(Location loc,Board x,ColorEnum color){
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
        Integer a = new Integer(loc.c - loc1.c);
        Integer b = new Integer(loc.r - loc1.r);
        if(Math.abs(a)==Math.abs(b) && a!=0){
            if((a<0 && b<0)||(a>0 && b>0)){
                flag = x.freeAntidiagonalPath(loc, loc1);
            }else{
                flag = x.freeDiagonalPath(loc, loc1);
            }
            if(flag == true){
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
        }else{
            throw new Exception("Wrong Input");
        }
    }

    @Override
    public String toString() {
        if(color == ColorEnum.BLACK){
            return "q";
        }else{
            return "Q";
        }

    }

}
