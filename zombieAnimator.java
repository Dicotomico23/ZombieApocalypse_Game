import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class zombieAnimator extends Actor
{
    private final int COUNTDOWN_CHANGE_DELAY_START_VALUE = 10;
    private int changeDelay = COUNTDOWN_CHANGE_DELAY_START_VALUE;
    private String[][] spriteArray;
    private Zombie zombie;
    private int imageIndex = 0;
    
    public zombieAnimator(Zombie zombie){
        this.zombie = zombie;
        setImage((GreenfootImage)null);
        setSprites();
    }
    public void act(){
        ChangeImage();
    }
    private void setSprites(){
        spriteArray = zombie.getZombieSprites();
        GreenfootImage sprite = new GreenfootImage(spriteArray[0][0]);
        sprite.scale(50,50);
        zombie.setImage(sprite);
    }
    private void ChangeImage(){
        changeDelay--;
        if(changeDelay == 0){
            if(imageIndex == spriteArray.length || spriteArray[imageIndex][zombie.getAction()] == null){
                imageIndex = 0;
            }
            GreenfootImage sprite = new GreenfootImage(spriteArray[imageIndex][zombie.getAction()]);
            sprite.scale(50,50);
            zombie.setImage(sprite);
            imageIndex++;
            changeDelay = COUNTDOWN_CHANGE_DELAY_START_VALUE;
        }
    }
}