import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends ButtonTemplateMethod
{
    public PlayButton(){
        super("play_button",200, 100);
    }
    public void doWhenButtonIsPressed(){
        Greenfoot.setWorld(new Menu());
    }
}
