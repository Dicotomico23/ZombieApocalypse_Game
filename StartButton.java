import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends ButtonTemplateMethod
{
    private int mapIndex = 1;
    public StartButton(){
        super("start_button", 300, 150);
    }
    public void doWhenButtonIsPressed(){
        switch(mapIndex){
            case 1: Level1 level1 = new Level1();
                    level1.setDifficulty(400, 1, 5, 10, 500);
                    Greenfoot.setWorld(level1);
                    break;
            case 2: Level2 level2 = new Level2();
                    level2.setDifficulty(300, 2, 10, 30, 700);
                    Greenfoot.setWorld(level2);
                    break;
            case 3: Level3 level3 = new Level3();
                    level3.setDifficulty(200, 4, 30, 50, 900);
                    Greenfoot.setWorld(level3); 
                    break;
        } 
    }
    public void setMapIndex(int mapIndex){
        this.mapIndex = mapIndex;
    }
}
