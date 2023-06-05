import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.Writer;

public class Game extends World
{
    private int zombieSpawningSpeedLimit = 300, startingNumZombies = 10, zombiesPerRound = 10, powerUpSpawnDelay = 700, zombieSpeedLimit = 2, zombieHealth = 70;
    
    private final int randBoundaryX = 450, randBoundaryY = 300;
    private final int ammoTextPositionX = 100, ammoTextPositionY = getHeight()-150;
    private final int healthTextPositionX = 100, healthTextPositionY = getHeight()-180;
    private final int killsTextPositionX = 100, killsTextPositionY = getHeight()-210;
    private final int gunPicturePositionX = 60, gunPicturePositionY = getHeight()-130;

    private int contZombies = startingNumZombies, spawnDelayZombies = zombieSpawningSpeedLimit, spawnDelayPowerUps = powerUpSpawnDelay;
    private int RoundCont = 1, time = 0, kills = 0, auxKills = 0;
    private boolean keepSpawning = true, keepSpawningPowerUps = true, triggerSetRound = true;
    
    private Random rand = new Random();
    private Rifle weapon = new Rifle();
    private Soldier player = new Soldier(weapon);
    private playerAnimator animator = new playerAnimator(player);
    private GreenfootImage bg;
    
    public Game(String MapImagePath, String backgroundSoundPath)
    {    
        super(900, 600, 1, true);
        setMap(MapImagePath);
        showImages(); 
        spawnPlayer();
        addObject(animator, 450, 300);
        chooseWeapon();
        spawnInitialZombies();
        playZombieSounds();
    }
    public void act(){
        spawnZombies(zombieSpeedLimit);
        spawnPowerUps(); 
        showHud();
        setRound();
    }
    private void spawnPlayer(){
        addObject(player,450, 300);
    }
    private void chooseWeapon(){
        addObject(weapon,450, 300);
        weapon.setImage((GreenfootImage)null);
    }
    private void spawnInitialZombies(){
        for(int contInitialZombies=0; contInitialZombies < startingNumZombies; contInitialZombies++){
            int walkingSpeed = rand.nextInt(zombieSpeedLimit) + 1;
            setZombieSpawningPosition(walkingSpeed);
        }
    }
    private void spawnPowerUps(){
        if(keepSpawningPowerUps == true)
            spawnDelayPowerUps--;
        if(spawnDelayPowerUps == 0 && keepSpawningPowerUps == true){
            weapon.setNoReloading(false);
            player.activateShield(false);
            keepSpawningPowerUps = false;
            randomizePowerUps();
            spawnDelayPowerUps = powerUpSpawnDelay;
        }
    }
    private void randomizePowerUps(){
        int randomPowerUp = rand.nextInt(3);
        int randomPositionPowerUpX = rand.nextInt(getWidth()-100);
            int randomPositionPowerUpY = rand.nextInt(getHeight()-100);
        switch(randomPowerUp){
            case 0: addObject(new MaxHealth(), randomPositionPowerUpX, randomPositionPowerUpY);
            break;
            case 1: addObject(new Shield(), randomPositionPowerUpX, randomPositionPowerUpY);
            break;
            case 2: addObject(new NoReloading(), randomPositionPowerUpX, randomPositionPowerUpY);
            break;
        }
    }
    private void setRound(){
        showText("Round: "+(RoundCont-1), getWidth()-100, getHeight()-100);
        if((kills%zombiesPerRound) == 0  && triggerSetRound == true){
            triggerSetRound = false;
            zombieHealth += 20;
            RoundCont++;
            auxKills= kills;
        }
        if(kills == auxKills+1){triggerSetRound = true;}
    }
    private void spawnZombies(int zombieSpeedLimit){
        spawnDelayZombies--;
        if(spawnDelayZombies == 0){
            int walkingSpeed = rand.nextInt(zombieSpeedLimit) + 1; 
            setZombieSpawningPosition(walkingSpeed);
            int randomSpawnDelay = rand.nextInt(20+(zombieSpawningSpeedLimit-20));
            spawnDelayZombies = randomSpawnDelay;
            contZombies++;
        }
    }
    private void setZombieSpawningPosition(int walkingSpeed){
        int spawningCorner = rand.nextInt(4);
        Zombie zombie = new Zombie(walkingSpeed, zombieHealth);
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
        addObject(new zombieAnimator(zombie),0,0);
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
    private void playZombieSounds(){
        GreenfootSound backgroundMusic = new GreenfootSound("sounds\\AmbienceMusic\\BackgroundMusic.mp3");
        GreenfootSound zombieSounds = new GreenfootSound("sounds\\ZombieSounds\\ZombieHorde_0.mp3");
        backgroundMusic.playLoop();
        zombieSounds.playLoop();
    }
    public void gameOver() throws IOException {
        removeObjects(getObjects(Actor.class));
        showText("GAME OVER", 450, 300);
        showText(null, ammoTextPositionX, ammoTextPositionY);
        showText(null, healthTextPositionX, healthTextPositionY);
        saveHighScore();
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
        spawnDelayZombies = delay;
    }
    public void updateKillScore(){
        kills++;
    }
    public void setKeepSpawningPowerUps(boolean keepSpawningPowerUps){
        this.keepSpawningPowerUps = keepSpawningPowerUps;
    }
    public void setMap(String MapImagePath){
        bg = new GreenfootImage(MapImagePath);
        bg.scale(2700, 1800);
        setBackground(bg);
    }
    public void setDifficulty(int zombieSpawningSpeedLimit, int zombieSpeedLimit, int startingNumZombies, int zombiesPerRound, int powerUpSpawnSpeed){
        this.zombieSpawningSpeedLimit = zombieSpawningSpeedLimit;
        this.zombieSpeedLimit = zombieSpeedLimit;
        this.startingNumZombies = startingNumZombies;
        this.zombiesPerRound = zombiesPerRound;
        this.powerUpSpawnDelay = powerUpSpawnSpeed;    
    }
    private void saveHighScore() throws java.io.IOException {
        int newScore = kills;
        int previousScore = 0;
        try {
            File file = new File("files\\highScore.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else{
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextInt())
                {
                     previousScore = scanner.nextInt();
                }
                if(newScore > previousScore){
                    showText("new High Score: "+newScore, 450, 400);
                    Writer writer = null;
                    try {
                        writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file), "utf-8"));
                        writer.write(newScore);
                    } catch (IOException ex) {
                        System.out.println("Could not write on this file.");
                    } finally {
                       try {writer.close();} catch (Exception ex) {/*ignore*/}
                    }
                }
            }
        }catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
}
