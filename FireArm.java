import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireArm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireArm extends Actor implements Weapon
{
    private int maxAmmo, damage, COUNTDOWN_SHOOTING_START_VALUE = 100, bulletSpeed;
    private int shootingDelay = COUNTDOWN_SHOOTING_START_VALUE, bulletsLeft = maxAmmo, bulletsShot = 0;
    private boolean reloaded = true;
    private String[][] spriteArray;
    GreenfootImage weaponImage;
    GreenfootImage bulletImage;
    public void setMaxAmmo(int maxAmmo){
        this.maxAmmo = maxAmmo;
    }
    public int getMaxAmmo(){
        return maxAmmo;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDamage(){
        return damage;
    }
    public void setShootingSpeed(int shootingSpeed){
        COUNTDOWN_SHOOTING_START_VALUE = shootingSpeed;
    }
    public int getShootingSpeed(){
        return COUNTDOWN_SHOOTING_START_VALUE;
    }
    public void setBulletSpeed(int bulletSpeed){
        this.bulletSpeed = bulletSpeed;
    }
    public int getBulletSpeed(){
        return bulletSpeed;
    }
    public void setPlayerSprites(String [][] spriteArray){
        this.spriteArray = spriteArray;
    }
    public String [][] getPlayerSprites(){
        return spriteArray;
    }
    public void setWeaponImage(GreenfootImage weaponImage){
        this.weaponImage = weaponImage;
    }
    public GreenfootImage getWeaponImage(){
        return weaponImage;
    }
    public void setBulletImage(GreenfootImage bulletImage){
        this.bulletImage = bulletImage;
    }
    public GreenfootImage getBulletImage(){
        return bulletImage;
    }
    public int getBulletsShot(){
        return bulletsShot;
    }
    public int getBulletsLeft(){
        return bulletsLeft;
    }
    public boolean isReloaded(){
        if(bulletsLeft > 0){reloaded = true;}
        else{reloaded = false;}
        return reloaded;
    }
    public void shootBullet(){
        shootingDelay--;
        if (shootingDelay == 0){
            if(bulletsLeft > 0){
                Game game = (Game) getWorld();
                Soldier player = game.getPlayer();
                Bullet bullet = new Bullet(bulletSpeed,damage);
                getWorld().addObject(bullet, player.getX(), player.getY()+10);
                bullet.setRotation(player.getRotation());
                bulletsLeft--;
                bulletsShot++;
                shootingDelay = COUNTDOWN_SHOOTING_START_VALUE;
            }
        }
    }
    public void reload(){
        bulletsLeft = maxAmmo;
        Greenfoot.playSound("sounds\\Reload\\ReloadGun.mp3");
    }
}
