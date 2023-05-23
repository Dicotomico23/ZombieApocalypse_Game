import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{ 
    private int weaponStatsCont = 0;
    private final int NUMBER_OF_WEAPONS = 3;
    public Menu()
    {  
        super(900, 600, 1); 
        GreenfootImage bg = new GreenfootImage("images\\Main_Menu\\MainMenu_background.png");
        bg.scale(900,650);
        setBackground(bg);
        GreenfootImage highestScores = new GreenfootImage("images\\Main_Menu\\HighestScore_table.png");
        GreenfootImage weaponStats = new GreenfootImage("images\\Main_Menu\\weapon_stats_0.png");
        highestScores.scale(400,500);
        weaponStats.scale(500,400);
        getBackground().drawImage(highestScores, 500, 20);
        getBackground().drawImage(weaponStats, 30, 30);
        RightArrow rightArrow = new RightArrow();
        LeftArrow leftArrow = new LeftArrow();
        addObject(new SelectButton(), 270, getHeight()-135);
        addObject(leftArrow, 150, getHeight()-135);
        addObject(rightArrow, 390, getHeight()-135);
        addObject(new StartButton(), 150, getHeight()-60);
        addObject(new LevelButton(), 450, getHeight()-60);
    }
    public void rightArrow(){
        if(weaponStatsCont == NUMBER_OF_WEAPONS){
            weaponStatsCont = 0;
        }
        GreenfootImage weaponStats = new GreenfootImage("images\\Main_Menu\\weapon_stats_"+weaponStatsCont+".png");
        weaponStats.scale(500,400);
        getBackground().drawImage(weaponStats, 30, 30);
        weaponStatsCont++;
    }
    public void leftArrow(){
        GreenfootImage weaponStats = new GreenfootImage("images\\Main_Menu\\weapon_stats_"+weaponStatsCont+".png");
        weaponStats.scale(500,400);
        getBackground().drawImage(weaponStats, 30, 30);
        weaponStatsCont--;
        if(weaponStatsCont == -1){
            weaponStatsCont = NUMBER_OF_WEAPONS-1;
        }
    }
}
