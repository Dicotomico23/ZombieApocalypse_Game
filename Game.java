import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class Game extends World
{
    private final int ZOMBIE_SPAWN_DELAY_RAND_LIMIT = 300, TOTAL_NUM_ZOMBIES = 100, STARTING_NUM_ZOMBIES = 10;
    private final int randBoundaryX = 450, randBoundaryY = 300;
    private final int ammoTextPositionX = 100, ammoTextPositionY = getHeight()-150;
    private final int healthTextPositionX = 100, healthTextPositionY = getHeight()-180;
    private final int killsTextPositionX = 100, killsTextPositionY = getHeight()-210;
    private final int gunPicturePositionX = 60, gunPicturePositionY = getHeight()-130;
    
    private int contZombies = 0;
    private int spawnDelay = ZOMBIE_SPAWN_DELAY_RAND_LIMIT, zombieSpeedLimit = 2;
    private boolean keepSpawning = true;
    private Random rand = new Random();
    private Rifle weapon = new Rifle();
    private Soldier player = new Soldier(weapon);
    private playerAnimator animator = new playerAnimator(player);
    
    public int kills = 0;
    
    public Game()
    {    
        super(900, 600, 1);
        setBackground("images\\Background\\ZombieGame_background.png");
        addObject(animator, 450, 300);
        showImages();
        SpawnPlayer();
        chooseWeapon();
        SpawnInitialZombies();
        PlayZombieSounds();
    }
    public void act(){
        SpawnZombies(TOTAL_NUM_ZOMBIES, zombieSpeedLimit);
        showHud();
    }
    private void SpawnPlayer(){
        addObject(player,450, 300);
    }
    private void chooseWeapon(){
        addObject(weapon,450, 300);
        weapon.setImage((GreenfootImage)null);
    }
    private void SpawnInitialZombies(){
        for(int contInitialZombies=0; contInitialZombies < STARTING_NUM_ZOMBIES; contInitialZombies++){
            int walkingSpeed = rand.nextInt(zombieSpeedLimit) + 1;
            setZombieSpawningPosition(walkingSpeed);
        }
    }
    private void SpawnZombies(int numZombies, int zombieSpeedLimit){
        spawnDelay--;
        if(spawnDelay == 0 && keepSpawning == true){
            int walkingSpeed = rand.nextInt(zombieSpeedLimit) + 1;
            setZombieSpawningPosition(walkingSpeed);
            contZombies++;
            int randomSpawnDelay = rand.nextInt(20+(ZOMBIE_SPAWN_DELAY_RAND_LIMIT-20));
            spawnDelay = randomSpawnDelay;
        }
        if(contZombies == numZombies - STARTING_NUM_ZOMBIES){keepSpawning = false;}
    }
    private void setZombieSpawningPosition(int walkingSpeed){
        int spawningCorner = rand.nextInt(4);
        Zombie zombie = new Zombie(walkingSpeed);
        switch(spawningCorner){
            case 0: addObject(zombie, randBoundaryX + getWidth(), randBoundaryY + getHeight());
            break;
            case 1: addObject(zombie, randBoundaryX + getWidth(), randBoundaryY - getHeight());
            break;
            case 2: addObject(zombie, randBoundaryX - getWidth(), randBoundaryY - getHeight());
            break;
            case 3: addObject(zombie, randBoundaryX - getWidth(), randBoundaryY + getHeight());
            break;
        }
        addObject(new zombieAnimator(zombie), 450, 300);
    }
    private void showImages(){
        GreenfootImage Image = weapon.getWeaponImage();
        Image.scale(100, 70);
        getBackground().drawImage(Image, gunPicturePositionX, gunPicturePositionY);
    }
    private void showHud(){
        showText("Ammo: "+weapon.getBulletsLeft()+"/"+weapon.getMaxAmmo(), ammoTextPositionX, ammoTextPositionY);
        showText("Health: "+player.getHealth(), healthTextPositionX, healthTextPositionY);
        showText("Kills: "+kills, killsTextPositionX, killsTextPositionY);
    }
    private void PlayZombieSounds(){
        GreenfootSound backgroundMusic = new GreenfootSound("sounds\\AmbienceMusic\\BackgroundMusic.mp3");
        GreenfootSound zombieSounds = new GreenfootSound("sounds\\ZombieSounds\\ZombieHorde_0.mp3");
        backgroundMusic.playLoop();
        zombieSounds.playLoop();
    }
    public void GameOver(){
        removeObjects(getObjects(Actor.class));
        showText("GAME OVER", 450, 300);
        showText(null, ammoTextPositionX, ammoTextPositionY);
        showText(null, healthTextPositionX, healthTextPositionY);
        removeObjects(getObjects(null));
        Greenfoot.stop();
    }
    public Soldier getPlayer(){
        return player;
    }
    public Weapon getWeapon(){
        return weapon;
    }
    public void setZombieSpawnDelay(int delay){
        spawnDelay = delay;
    }
    public void updateKillScore(){
        kills++;
    }
}
