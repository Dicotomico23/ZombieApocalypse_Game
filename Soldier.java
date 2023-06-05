import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldier extends Actor
{
    private final int DIRECTION_RIGHT = 0;
    private final int DIRECTION_LEFT = 1;
    private final int DIRECTION_DOWN = 2;
    private final int DIRECTION_UP = 3;
    private final int NOT_MOVING = -1;
    private final int offsetX = 3, offsetY = 3;
    private final int COUNTDOWN_RELOAD_START_VALUE = 100;
    
    private int reloadingDelay = 0, zombieHitDelay = 0, direction = 0, action, health = 100;
    private boolean triggerReloadingDelay = false, triggerZombieDamage = false, zombieKilled = false, shield = false, noReloading = false;
    private FireArm weapon;

    public Soldier(FireArm weapon){
        this.weapon = weapon;
    }
    public void act()
    {
        checkMousePosition();
        checkKeyPressed();
        setDirection();
        checkIfShooting();
        checkIfWeaponIsLoaded();
        checkIfPlayerIsHit();
    }
    public String[][] getWeaponSprites(){
        return weapon.getPlayerSprites();
    }
    private void checkMousePosition(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            turnTowards(mouse.getX(), mouse.getY());
        }
    }
    private void checkKeyPressed(){
        if(Greenfoot.isKeyDown("a")){
            direction = DIRECTION_LEFT;
            action = 1;
        } else if(Greenfoot.isKeyDown("d")){
            direction = DIRECTION_RIGHT;
            action = 1;
        }else if(Greenfoot.isKeyDown("s")){
            direction = DIRECTION_DOWN;
            action = 1;
        }else if(Greenfoot.isKeyDown("w")){
            direction = DIRECTION_UP;
            action = 1;
        }else if(Greenfoot.isKeyDown("r")){
            triggerReloadingDelay = true;
            action = 2;
        }
        else{
            direction = NOT_MOVING;
            action = 0;
        }
    }
    private void setDirection(){
        if(direction >= 0){
            switch(direction){
                case DIRECTION_RIGHT:
                    setLocation(getX()+offsetX,getY());
                    break;
                case DIRECTION_LEFT:
                    setLocation(getX()-offsetX,getY());
                    break;
                case DIRECTION_DOWN:
                    setLocation(getX(),getY()+offsetY);
                    break;
                case DIRECTION_UP:
                    setLocation(getX(),getY()-offsetY);
                    break;
            }
        }
    }
    private void checkIfShooting(){
        if(Greenfoot.isKeyDown("space")){
            if(weapon.isReloaded() == true){
                weapon.shootBullet();
                action = 3;
            }
        }
    }
    private void checkIfWeaponIsLoaded(){
        if(reloadingDelay == 0){
            weapon.reload();
            triggerReloadingDelay = false;
            reloadingDelay = COUNTDOWN_RELOAD_START_VALUE;
        }
        if(triggerReloadingDelay == true && reloadingDelay == COUNTDOWN_RELOAD_START_VALUE){
            Greenfoot.playSound("sounds\\Reload\\ReloadGun.mp3");
        }
        if(triggerReloadingDelay == true){
            reloadingDelay--;
            action = 2;
        }
    }
    private void checkIfPlayerIsHit(){
        Zombie zombie = (Zombie) this.getOneIntersectingObject(Zombie.class);
        if(zombie!=null && zombieHitDelay == 0 && shield == false){
            health -= zombie.getDamage();
            triggerZombieDamage = true;
            zombie.setAction(1);
            if(health <= 0){
                Game scene = (Game) getWorld();
                try
                {
                    scene.gameOver();
                }
                catch (java.io.IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
        if(triggerZombieDamage == true){
            zombieHitDelay++;
            if(zombieHitDelay == 100){
                zombieHitDelay = 0;
                triggerZombieDamage = false;
            }
        }
    }
    public int getAction(){
        return action;
    }
    public int getPositionX(){
        return getX();
    }
    public int getPositionY(){
        return getY();
    }
    public int getHealth(){
        return health;
    }
    public void maxHealth(){
        health = 100;
    }
    public void activateShield(boolean shield){
        this.shield = shield;
    }
}
