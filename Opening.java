import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Opening here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opening extends World
{
    private PlayButton playButton = new PlayButton();
    private GreenfootImage backgroundImage = new GreenfootImage("images\\Background\\MainMenu_background.jpg");
    public Opening()
    {  
        super(900, 600, 1); 
        Greenfoot.start();
        backgroundImage.scale(getWidth(), getHeight());
        setBackground(backgroundImage);
        addObject(playButton, 450, 300);
        Greenfoot.playSound("sounds\\AmbienceMusic\\terror-ambience.mp3");
    }
    public void act(){
        playButton.act();
    }
}
