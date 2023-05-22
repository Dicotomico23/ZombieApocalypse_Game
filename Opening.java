import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Opening here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opening extends World
{
    private StartButton startButton = new StartButton();
    private GreenfootImage backgroundImage = new GreenfootImage("images\\Background\\MainMenu_background.jpg");
    public Opening()
    {  
        super(900, 600, 1); 
        Greenfoot.start();
        backgroundImage.scale(getWidth(), getHeight());
        setBackground(backgroundImage);
        addObject(startButton, 450, 300);
        Greenfoot.playSound("sounds\\AmbienceMusic\\terror-ambience.mp3");
    }
    public void act(){
        startButton.act();
    }
}
