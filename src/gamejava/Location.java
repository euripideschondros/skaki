/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamejava;

/**
 *
 * @author akis
 */

public class Location {
    
    int r, c;
    String loc;

    //InvalidLocationException invalidLocationException = new InvalidLocationException();

    public Location(int r, int c)
    {
             this.r = r;
             this.c = c;
    }

    public Location(String loc) throws Exception
    {

        if(loc.length()!=2){
            throw new Exception("InvalidLocationException");
        }
        char x[] = new char[3];
        x = loc.toCharArray();

        if(x[0] == 'a' || x[0] == 'b' || x[0] == 'c' || x[0] == 'd' || x[0] == 'e' || x[0] == 'f' || x[0] == 'g' || x[0] == 'h'){
            if(Character.getNumericValue(x[1])>0 && Character.getNumericValue(x[1])<=8){
                r = Character.getNumericValue(x[1]);
                r=r-1;
                switch(r){
            case 0:
                r=7;
                break;
            case 1:
                r=6;
                break;
            case 2:
                r=5;
                break;
            case 3:
                r=4;
                break;
            case 4:
                r=3;
                break;
            case 5:
                r=2;
                break;
            case 6:
                r=1;
                break;
            default:
                r=0;
                break;
        }
                switch(x[0]){
            case 'a':
                c=0;
                break;
            case 'b':
                c=1;
                break;
            case 'c':
                c=2;
                break;
            case 'd':
                c=3;
                break;
            case 'e':
                c=4;
                break;
            case 'f':
                c=5;
                break;
            case 'g':
                c=6;
                break;
            default:
                c=7;
                break;
        }
            }else{
                throw new Exception("InvalidLocationException");
            }
        }else{
             throw new Exception("InvalidLocationException");
        }

    }

    public int getRow()
    {
        return r;
    }

    public int getCol()
    {
        return c;
    }

    @Override
    public String toString()
    {
        String s;
        switch(c){
            case 0:
                s = "a";
                break;
            case 1:
                s = "b";
                break;
            case 2:
                s = "c";
                break;
            case 3:
                s = "d";
                break;
            case 4:
                s = "e";
                break;
            case 5:
                s = "f";
                break;
            case 6:
                s = "g";
                break;
            default:
                s = "h";
                break;
        }
        s = Integer.toString(r) + Integer.toString(c);
        return s;

    }

}
