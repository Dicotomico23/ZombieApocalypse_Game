import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{ 
    private int weaponStatsCont = 0;
    private final int NUMBER_OF_WEAPONS = 3;
    private String choosenWeapon;
    private int mapIndex = 1;
    private StartButton startButton = new StartButton();
    public Menu()
    {  
        super(900, 600, 1); 
        GreenfootImage bg = new GreenfootImage("images\\Main_Menu\\MainMenu_background.png");
        GreenfootImage highestScores = new GreenfootImage("images\\Main_Menu\\HighestScore_table.png");
        GreenfootImage weaponStats = new GreenfootImage("images\\Main_Menu\\weapon_stats_0.png");
        bg.scale(900,650);
        highestScores.scale(400,500);
        weaponStats.scale(500,400);
        setBackground(bg);
        getBackground().drawImage(highestScores, 500, 0);
        getBackground().drawImage(weaponStats, 30, 0);
        RightArrow rightArrow = new RightArrow();
        LeftArrow leftArrow = new LeftArrow();
        addObject(new SelectWeaponButton(), 270, getHeight()-165);
        addObject(leftArrow, 100, getHeight()-175);
        addObject(rightArrow, 440, getHeight()-175);
        addObject(startButton, 190, getHeight()-70);
        addObject(new LevelButton(this), 420, getHeight()-70);
    }
    public void act(){
        setWeapon();
        showText("Weapon: "+choosenWeapon, 600, getHeight()-90);
        showText("Map: Map "+mapIndex, 570, getHeight()-70);
    }
    public void setWeapon(){
        switch(weaponStatsCont){
            case 0: choosenWeapon = "Handgun";
            break;
            case 1: choosenWeapon = "Rifle";
            break;
            case 2: choosenWeapon = "Shotgun";
            break;
        }
    }
    public void chooseWeapon(){
        switch(weaponStatsCont){
            case 0: choosenWeapon = "Handgun";
            break;
            case 1: choosenWeapon = "Rifle";
            break;
            case 2: choosenWeapon = "Shotgun";
            break;
        }
    }
    public void rightArrow(){
        weaponStatsCont++;
        if(weaponStatsCont == NUMBER_OF_WEAPONS){
            weaponStatsCont = 0;
        }
        GreenfootImage weaponStats = new GreenfootImage("images\\Main_Menu\\weapon_stats_"+weaponStatsCont+".png");
        weaponStats.scale(500,400);
        getBackground().drawImage(weaponStats, 30, 0);
    }
    public void leftArrow(){
        weaponStatsCont--;
        if(weaponStatsCont == -1){
            weaponStatsCont = NUMBER_OF_WEAPONS-1;
        }
        GreenfootImage weaponStats = new GreenfootImage("images\\Main_Menu\\weapon_stats_"+weaponStatsCont+".png");
        weaponStats.scale(500,400);
        getBackground().drawImage(weaponStats, 30, 0);
    } 
    public void setMap(int mapIndex){
        this.mapIndex = mapIndex;
        startButton.setMapIndex(mapIndex);
    }
}
