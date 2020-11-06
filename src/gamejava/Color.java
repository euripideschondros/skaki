/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamejava;

/**
 *
 * @author akis
 */
public class Color{
private ColorEnum color;


public Color(){
    color = ColorEnum.WHITE;
}

public ColorEnum getColor(){
    return color;
}
public ColorEnum nextColor(){
    if(color == ColorEnum.BLACK){
        color = ColorEnum.WHITE;
    }else{
        color = ColorEnum.BLACK;
    }
    return color;
}




}

