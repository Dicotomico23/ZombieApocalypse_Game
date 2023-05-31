import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelButton extends ButtonTemplateMethod
{
    private Menu menu;
    public LevelButton(Menu menu){
        super("chooseLevel_button", 150, 150);
        this.menu = menu;
    }
    public void doWhenButtonIsPressed(){
        Greenfoot.setWorld(new ChooseMap(menu));
    }
}
