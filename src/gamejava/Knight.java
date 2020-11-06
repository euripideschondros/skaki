/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamejava;

/**
 *
 * @author akis
 */
public class Knight extends Piece {

    public Knight(Location loc, Board x, ColorEnum color) {
        super(loc, x, color);

    }

    @Override
    void moveTo(Location loc1) throws Exception {
        int a, b;
        a = loc.c - loc1.c;
        b = loc.r - loc1.r;
        if (Math.abs(a) == 1) {
            if (Math.abs(b) == 2) {
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
        } else if (Math.abs(a) == 2) {
            if (Math.abs(b) == 1) {
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
                System.out.println("loc.r= "+loc.r+" loc1.r= "+loc1.r);
                System.out.println("A: "+a+" B: "+b);
                throw new Exception("Wrong Input");
            }
        } else {
            throw new Exception("Wrong Input");
        }
    }

    @Override
    public String toString() {
        if (color == ColorEnum.BLACK) {
            return "n";
        } else {
            return "N";
        }

    }
}
