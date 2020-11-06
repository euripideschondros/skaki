/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamejava;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author akis
 */
public class Game {
    Board x;
    Color currentPlayer;
    public Game(){
        currentPlayer = new Color();
        x = new Board();
        x.init();
    }
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(x.toString());
        do{
            System.out.println("Give coords:coords to move a piece, :h for help or :x for exit");
            System.out.print("Now Plays ");
            if(currentPlayer.getColor()==ColorEnum.WHITE)
            {System.out.println("WHITE");}
            else
            {System.out.println("BLACK");
            }

            String s = scanner.nextLine();
            char xx[] = new char[s.length()+1];
            xx = s.toCharArray();
            if(xx[0]==':'){
                if(xx[1]=='h'){
                    printHelp();
                }else if(xx[1]=='x'){
                    System.out.println("Exit Game");
                    exitGame();
                }else{
                    System.out.println("Wrong Input Command not Recognized");
                    continue;
                }
            }
            if(s.length() == 5){
                try {
                    handleMove(xx);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    continue;
                }
            }

        }while(true);
    }

    private void handleMove(char[] xx) throws Exception{
        Location from,to;
        from = new Location(0,0);
        to=new Location(0,0);
                String sz ="";
                sz = Character.toString(xx[0])+Character.toString(xx[1]);
                    from = new Location(sz);
                    if(x.matrix[from.r][from.c].color != currentPlayer.getColor()){
                        throw new Exception("Wrong Players Piece Try Again");
                    }
                    sz ="";
                    sz = Character.toString(xx[3])+Character.toString(xx[4]);
                    to = new Location(sz);
                    System.out.println(to.toString());
                    x.matrix[from.r][from.c].moveTo(to);
                    currentPlayer.nextColor();
                    System.out.println(x.toString());
                
    }

    /*private void saveGame() {
    }

    private void openGame() {
    }*/

    private void exitGame() {
        System.exit(1);
    }

    private void printHelp() {
        System.out.println("Oi entoles tou programmatos exoun ws eksis");
        System.out.println("Bazoume anw katw teleia kai patame");
        System.out.println("h gia na emfanistei keimeno boh8eias");
        System.out.println("s gia apo8hkeush tou paixnidiou");
        System.out.println("o gia fortwsh paixnidiou kai ");
        System.out.println("x gia eksodo apo to paixnidi");
    }
}
