/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamejava;

import java.io.Serializable;

/**
 *
 * @author akis
 */
public class Board implements Serializable {
    Piece matrix[][];

    public void init()
    {
        matrix = new Piece[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                matrix[i][j]=null;
            }
        }
        matrix[0][0] = new Rook(new Location(0,0),this,ColorEnum.BLACK);
        matrix[0][1] = new Knight(new Location(0,1),this,ColorEnum.BLACK);
        matrix[0][2] = new Bishop(new Location(0,2),this,ColorEnum.BLACK);
        matrix[0][3] = new Queen(new Location(0,3),this,ColorEnum.BLACK);
        matrix[0][4] = new King(new Location(0,4),this,ColorEnum.BLACK);
        matrix[0][5] = new Bishop(new Location(0,5),this,ColorEnum.BLACK);
        matrix[0][6] = new Knight(new Location(0,6),this,ColorEnum.BLACK);
        matrix[0][7] = new Rook(new Location(0,7),this,ColorEnum.BLACK);
        for(int i =0;i<8;i++){
            matrix[1][i] = new Pawn(new Location(1,i),this,ColorEnum.BLACK);
        }
        matrix[7][0] = new Rook(new Location(7,0),this,ColorEnum.WHITE);
        matrix[7][1] = new Knight(new Location(7,1),this,ColorEnum.WHITE);
        matrix[7][2] = new Bishop(new Location(7,2),this,ColorEnum.WHITE);
        matrix[7][3] = new Queen(new Location(7,3),this,ColorEnum.WHITE);
        matrix[7][4] = new King(new Location(7,4),this,ColorEnum.WHITE);
        matrix[7][5] = new Bishop(new Location(7,5),this,ColorEnum.WHITE);
        matrix[7][6] = new Knight(new Location(7,6),this,ColorEnum.WHITE);
        matrix[7][7] = new Rook(new Location(7,7),this,ColorEnum.WHITE);
        for(int i =0;i<8;i++){
            matrix[6][i] = new Pawn(new Location(6,i),this,ColorEnum.WHITE);
        }

    }

    public Piece getPieceAt(Location loc)
    {
        return matrix[loc.r][loc.c];
    }

    public void movePiece(Location from, Location to)
    {
        
        matrix[to.r][to.c] = matrix[from.r][from.c];
        matrix[from.r][from.c]= null;
        matrix[to.r][to.c].loc.c=to.c;
        matrix[to.r][to.c].loc.r=to.r;
        
    }

    public void movePieceCapturing(Location from, Location to)
    {
       
        matrix[to.r][to.c] = matrix[from.r][from.c];
        matrix[from.r][from.c]= null;
        matrix[to.r][to.c].loc.c=to.c;
        matrix[to.r][to.c].loc.r=to.r;
        
    }

    public boolean freeHorizontalPath(Location from, Location to)
    {
        if(from.c < to.c){
            for(int i = from.c+1;i<to.c;i++){
                if(matrix[from.r][i]!=null){
                    return false;
                }
            }
            return true;
        }else{
            for(int i = from.c- 1;i>to.c;i--){
                if(matrix[from.r][i]!=null){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean freeVerticalPath(Location from, Location to)
    {
         if(from.r < to.r){
            for(int i = from.r+1;i<to.r;i++){
                if(matrix[i][from.c]!=null){
                    return false;
                }
            }
            return true;
        }else{
            for(int i = from.r-1;i>to.r;i--){
                if(matrix[i][from.c]!=null){
                    return false;
                }
            }
            return true;
        }

    }

    public boolean freeDiagonalPath(Location from, Location to)
    {
        int a, b;
        a = from.c - to.c;
        b = from.r - to.r;
        if(a>0 && b<0)
        {
            for(int i = 1; i < a; i++)
            {
                if(matrix[from.c-i][from.r+i]!=null){
                    return false;
                }
            }return true;
        }else{
            for(int i = 1; i < b; i++)
            {
                if(matrix[from.c+i][from.r-i]!=null){
                    return false;
                }
            }return true;
        }

    }

    public boolean freeAntidiagonalPath(Location from, Location to)
    {
        int a, b;

        a = from.c - to.c;
        b = from.r - to.r;
        if(a < 0 && b < 0)
        {
            for(int i = 1; i < -a; i++)
            {
                if(matrix[from.c+i][from.r+i]!=null){
                    return false;
                }
            }
            return true;
        }else{
            for(int i = 1; i< a; i++){
            if(matrix[from.c-i][from.r-i]!=null){
                    return false;
                }
            }
            return true;
        }
    }

    public String toString()
    {
        String S = "";
        S = S + " abcdefgh \n";
        S = S + "8";
        for(int i=0;i<8;i++){
            if(matrix[0][i]!=null){
                S = S + matrix[0][i].toString();
            }else{
                S = S + " ";
            }
        }
        S = S +"8\n";
        S = S + "7";
        for(int i=0;i<8;i++){
            if(matrix[1][i]!=null){
            S = S + matrix[1][i].toString();
            }else{
                S = S + " ";
            }
        }
        S = S +"7\n";
        S = S + "6";
        for(int i=0;i<8;i++){
            if(matrix[2][i]!=null){
            S = S + matrix[2][i].toString();
            }else{
                S = S + " ";
            }
        }
        S = S +"6\n";
        S = S + "5";
        for(int i=0;i<8;i++){
            if(matrix[3][i]!=null){
            S = S + matrix[3][i].toString();
            }else{
                S = S + " ";
            }
        }
        S = S +"5\n";
        S = S + "4";
        for(int i=0;i<8;i++){
            if(matrix[4][i]!=null){
            S = S + matrix[4][i].toString();
            }else{
                S = S + " ";
            }
        }
        S = S +"4\n";
        S = S + "3";
        for(int i=0;i<8;i++){
            if(matrix[5][i]!=null){
            S = S + matrix[5][i].toString();
            }else{
                S = S + " ";
            }
        }
        S = S +"3\n";
        S = S + "2";
        for(int i=0;i<8;i++){
            if(matrix[6][i]!=null){
            S = S + matrix[6][i].toString();
            }else{
                S = S + " ";
            }
        }
        S = S +"2\n";
        S = S + "1";
        for(int i=0;i<8;i++){
            if(matrix[7][i]!=null){
            S = S + matrix[7][i].toString();
            }else{
                S = S + " ";
            }
        }
        S = S +"1\n";
        S = S + " abcdefgh \n";
        return S;


    }

}
