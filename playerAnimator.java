import greenfoot.*;

public class playerAnimator extends Actor
{
    private final int COUNTDOWN_CHANGE_DELAY_START_VALUE = 10;
    private int changeDelay = COUNTDOWN_CHANGE_DELAY_START_VALUE;
    private String[][] spriteArray;
    private Soldier player;
    private boolean isReloading = false;
    private int imageIndex = 0;
    
    public playerAnimator(Soldier player){
        this.player = player;
        setImage((GreenfootImage)null);
        setSprites();
    }
    public void act(){
        changeImage();
    }
    private void setSprites(){
        spriteArray = player.getWeaponSprites();
        GreenfootImage sprite = new GreenfootImage(spriteArray[0][0]);
        sprite.scale(50,50);
        player.setImage(sprite);
    }
    private void changeImage(){
        changeDelay--;
        if(changeDelay == 0){
            if(imageIndex == spriteArray.length || spriteArray[imageIndex][player.getAction()] == null){
                imageIndex = 0;
            }
            GreenfootImage sprite = new GreenfootImage(spriteArray[imageIndex][player.getAction()]);
            sprite.scale(50,50);
            player.setImage(sprite);
            imageIndex++;
            changeDelay = COUNTDOWN_CHANGE_DELAY_START_VALUE;
        }
    }
}
