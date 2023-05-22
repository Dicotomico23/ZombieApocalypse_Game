import greenfoot.Actor;
import greenfoot.*;

/**
 * Write a description of class Rifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rifle extends FireArm
{
    private final int maxAmmo = 50;
    private final int damage = 20;
    private final int shootingSpeed = 5;
    private final int bulletSpeed = 5;
    
    private final int INDEX_IDLE = 0;
    private final int INDEX_WALKING = 1;
    private final int INDEX_RELOAD = 2;
    private final int INDEX_SHOOTING = 3;
    private final int INDEX_MELEE_ATTACK = 4;
    private String[][] spriteArray;
    
    GreenfootImage weaponImage = new GreenfootImage("images\\Weapons\\Rifle\\rifleImage.png");
    GreenfootImage bulletImage = new GreenfootImage("images\\Bullets\\HandgunBullets\\handgunBullet.png");
    
    public Rifle()
    {
        setFireArm();
    }
    private void setSprites(){
        spriteArray = new String[9][5];
        spriteArray[0][INDEX_IDLE] = "images\\Shooter\\idle\\Rifle\\shooter-idle_rifle_0.png";
        spriteArray[0][INDEX_WALKING] = "images\\Shooter\\move\\Rifle\\survivor-move_rifle_0.png";
        spriteArray[1][INDEX_WALKING] = "images\\Shooter\\move\\Rifle\\survivor-move_rifle_1.png";
        spriteArray[0][INDEX_RELOAD] = "images\\Shooter\\reload\\Rifle\\survivor-reload_rifle_0.png";
        spriteArray[1][INDEX_RELOAD] = "images\\Shooter\\reload\\Rifle\\survivor-reload_rifle_1.png";
        spriteArray[2][INDEX_RELOAD] = "images\\Shooter\\reload\\Rifle\\survivor-reload_rifle_2.png";
        spriteArray[3][INDEX_RELOAD] = "images\\Shooter\\reload\\Rifle\\survivor-reload_rifle_3.png";
        spriteArray[4][INDEX_RELOAD] = "images\\Shooter\\reload\\Rifle\\survivor-reload_rifle_4.png";
        spriteArray[5][INDEX_RELOAD] = "images\\Shooter\\reload\\Rifle\\survivor-reload_rifle_5.png";
        spriteArray[6][INDEX_RELOAD] = "images\\Shooter\\reload\\Rifle\\survivor-reload_rifle_6.png";
        spriteArray[7][INDEX_RELOAD] = "images\\Shooter\\reload\\Rifle\\survivor-reload_rifle_7.png";
        spriteArray[8][INDEX_RELOAD] = "images\\Shooter\\reload\\Rifle\\survivor-reload_rifle_8.png";
        spriteArray[0][INDEX_SHOOTING] = "images\\Shooter\\shoot\\Rifle\\shooter-shooting_rifle_0.png";
    }
    private void setFireArm(){
        setSprites();
        setMaxAmmo(maxAmmo);
        setDamage(damage);
        setShootingSpeed(shootingSpeed);
        setBulletSpeed(bulletSpeed);
        setPlayerSprites(spriteArray);
        setWeaponImage(weaponImage);
        setBulletImage(bulletImage);
    }
}
