import greenfoot.Actor;
import greenfoot.*;

public class Handgun extends FireArm
{
    private final int maxAmmo = 20;
    private final int damage = 25;
    private final int shootingSpeed = 15;
    private final int bulletSpeed = 5;
  
    private final int INDEX_IDLE = 0;
    private final int INDEX_WALKING = 1;
    private final int INDEX_RELOAD = 2;
    private final int INDEX_SHOOTING = 3;
    private final int INDEX_MELEE_ATTACK = 4;
    private String[][] spriteArray;
    
    GreenfootImage weaponImage = new GreenfootImage("images\\Weapons\\Handgun\\handgunImage.png");
    GreenfootImage bulletImage = new GreenfootImage("images\\Bullets\\HandgunBullets\\handgunBullet.png");
    
    public Handgun()
    {
        setFireArm();
    }
    private void setSprites(){
        spriteArray = new String[7][5];
        spriteArray[0][INDEX_IDLE] = "images\\Shooter\\idle\\Rifle\\shooter-idle_rifle_0.png";
        spriteArray[0][INDEX_WALKING] = "images\\Zombies\\export\\skeleton-attack_0.png";
        spriteArray[1][INDEX_WALKING] = "images\\Zombies\\export\\skeleton-attack_1.png";
        spriteArray[2][INDEX_WALKING] = "images\\Zombies\\export\\skeleton-attack_2.png";
        spriteArray[3][INDEX_WALKING] = "images\\Zombies\\export\\skeleton-attack_3.png";
        spriteArray[4][INDEX_WALKING] = "images\\Zombies\\export\\skeleton-attack_4.png";
        spriteArray[5][INDEX_WALKING] = "images\\Zombies\\export\\skeleton-attack_5.png";
        spriteArray[6][INDEX_WALKING] = "images\\Zombies\\export\\skeleton-attack_6.png";
        spriteArray[0][INDEX_RELOAD] = "images\\Shooter\\idle\\Knife\\shooter-idle_knife_0.png";
        spriteArray[0][INDEX_SHOOTING] = "images\\Shooter\\idle\\Shotgun\\shooter-idle_shotgun_0.png";
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
