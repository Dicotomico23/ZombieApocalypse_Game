import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Zombie extends Actor
{
    private final int INDEX_WALKING = 0;
    private final int INDEX_ATTACK = 1;
    private final int damage = 2;
    private boolean triggerBulletDamage = false;
    private int movementSpeed = 1, bulletHitDelay = 0;
    private int health = 100;
    private int action;
    private String[][] spriteArray;
    
    public Zombie(int movementSpeed){
        this.movementSpeed = movementSpeed;
        setSprites();
    }
    public void act()
    {
        lookForPlayer();
        CheckIfZombieIsHit();
    }
    private void setSprites(){
        spriteArray = new String[7][2];
        spriteArray[0][INDEX_WALKING] = "images\\Zombies\\export\\skeleton-attack_0.png";
        spriteArray[0][INDEX_ATTACK] = "images\\Zombies\\export\\skeleton-attack_0.png";
        spriteArray[1][INDEX_ATTACK] = "images\\Zombies\\export\\skeleton-attack_1.png";
        spriteArray[2][INDEX_ATTACK] = "images\\Zombies\\export\\skeleton-attack_2.png";
        spriteArray[3][INDEX_ATTACK] = "images\\Zombies\\export\\skeleton-attack_3.png";
        spriteArray[4][INDEX_ATTACK] = "images\\Zombies\\export\\skeleton-attack_4.png";
        spriteArray[5][INDEX_ATTACK] = "images\\Zombies\\export\\skeleton-attack_5.png";
        spriteArray[6][INDEX_ATTACK] = "images\\Zombies\\export\\skeleton-attack_6.png";
    }
    public String[][] getZombieSprites(){
        return spriteArray;
    }
    public void setAction(int action){
        this.action = action;
    }
    public int getAction(){
        return action;
    }
    private void lookForPlayer(){
        move(movementSpeed);
        Game scene = (Game) getWorld();
        Soldier player = scene.getPlayer();
        turnTowards(player.getPositionX(), player.getPositionY());
        action = 0;
    }
    private void CheckIfZombieIsHit(){
        Bullet bullet = (Bullet) this.getOneIntersectingObject(Bullet.class);
        if(bullet!=null && bulletHitDelay == 0){
            health -= bullet.getDamage();
            triggerBulletDamage = true;
            getWorld().removeObject(bullet);
            if(health <= 0){
                Game scene = (Game) getWorld();
                GreenfootImage blood = new GreenfootImage("images\\Zombies\\export\\zombieBlood.png");
                blood.scale(40,40);
                scene.getBackground().drawImage(blood, getX(), getY());
                scene.updateKillScore();
                scene.removeObject(this);
            }
        }
        if(triggerBulletDamage == true){
            bulletHitDelay++;
            if(bulletHitDelay == 10){
                bulletHitDelay = 0;
                triggerBulletDamage = false;
            }
        }
    }
    public int getDamage(){
        return damage;
    }
}
