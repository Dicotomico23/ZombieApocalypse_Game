import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FireArm extends Actor implements Weapon
{
    private int maxAmmo, damage, COUNTDOWN_SHOOTING_START_VALUE = 100, bulletSpeed;
    private int shootingDelay = COUNTDOWN_SHOOTING_START_VALUE, bulletsLeft = maxAmmo, bulletsShot = 0;
    private boolean reloaded = true, noReloading = false;
    private String[][] spriteArray;
    private GreenfootImage weaponImage;
    private GreenfootImage bulletImage;
    
    public boolean isReloaded(){
        if(bulletsLeft > 0 ){reloaded = true;}
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
                if(player.getRotation()>=0 && player.getRotation()<90){ getWorld().addObject(bullet, player.getX(), player.getY()+10);}
                if(player.getRotation()>=90 && player.getRotation()<180){getWorld().addObject(bullet, player.getX()-10, player.getY());}
                if(player.getRotation()>=180 && player.getRotation()<270){getWorld().addObject(bullet, player.getX(), player.getY()-10);}
                if(player.getRotation()>=270 && player.getRotation()<360){getWorld().addObject(bullet, player.getX()+10, player.getY());}
                bullet.setRotation(player.getRotation());
                if(noReloading == false)
                    bulletsLeft--;
                bulletsShot++;
                shootingDelay = COUNTDOWN_SHOOTING_START_VALUE;
            }
        }
    }
    public void reload(){
        bulletsLeft = maxAmmo;
    }
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
    public void setNoReloading(boolean noReloading){
        this.noReloading = noReloading;
    }
}
