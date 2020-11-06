/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamejava;

/**
 *
 * @author akis
 */
public class King extends Piece {

    public King(Location loc, Board x, ColorEnum color) {
        super(loc, x, color);

    }

    @Override
    void moveTo(Location loc1) throws Exception {
        boolean flag = false;
        Integer a = new Integer(loc.c - loc1.c);
        Integer b = new Integer(loc.r - loc1.r);
        if ((a == 0 || Math.abs(a) == 1) && (b == 0 || Math.abs(b) == 1)) {
            if (!(a == 0 && b == 0)) {
                flag = true;
            }
        }
        if (flag) {
                    if (x.matrix[loc1.r][loc1.c] == null) {
                        x.movePiece(loc, loc1);
                        return;
                    }
                    if (x.matrix[loc1.r][loc1.c].color != color) {
                        x.movePiece(loc, loc1);
                        return;
                    }
                    throw new Exception("Wrong Input");

        } else {
            throw new Exception("Wrong Input");
        }
    }

    @Override
    public String toString() {
        if (color == ColorEnum.BLACK) {
            return "k";
        } else {
            return "K";
        }

    }
}
