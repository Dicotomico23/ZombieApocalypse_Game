import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int bulletSpeed, damage;
    private boolean bulletHit = false;
    GreenfootImage bulletImage = new GreenfootImage("images\\Bullets\\HandgunBullets\\handgunBullet2.png");
    
    public Bullet(int bulletSpeed, int damage){
        this.bulletSpeed = bulletSpeed;
        this.damage = damage;
        bulletImage.scale(20,10);
        setImage(bulletImage);
        Greenfoot.playSound("sounds\\GunShot\\GunShot.mp3");
    }
    public void act()
    {
        move(bulletSpeed);
        CheckIfBulletIsOutOfBoundary();
    }
    private void CheckIfBulletIsOutOfBoundary(){
        if(this.isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    public int getDamage(){
        return damage;
    }
    public int getBulletSpeed(){
        return bulletSpeed;
    }
}
