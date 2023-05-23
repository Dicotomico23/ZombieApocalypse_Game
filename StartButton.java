import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends ButtonTemplateMethod
{
    public StartButton(){
        super("start_button");
    }
    public void DoWhenButtonIsPressed(){
        Greenfoot.setWorld(new Game());
    }
}
