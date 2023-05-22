import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{ 
    public Menu()
    {  
        super(900, 600, 1); 
        addObject(new HighestScoresTable(), 700, 200);
        addObject(new PlayButton(), 150, getHeight()-100);
        addObject(new LevelButton(), 450, getHeight()-100);
        addObject(new EquipmentButton(), 750, getHeight()-100);
    }
    public void act(){
        
    }
}
