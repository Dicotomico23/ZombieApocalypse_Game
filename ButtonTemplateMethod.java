import greenfoot.*;

public abstract class ButtonTemplateMethod extends Actor
{
    private String buttonName;
    private int width, height;
    private GreenfootImage buttonImage; 
    private GreenfootImage buttonImageRed; 
    public ButtonTemplateMethod(String buttonName, int width, int height){
        this.buttonName = buttonName;
        buttonImage = new GreenfootImage("images\\Buttons\\"+buttonName+".png");
        buttonImageRed = new GreenfootImage("images\\Buttons\\"+buttonName+"_red.png");
        buttonImage.scale(width, height);
        buttonImageRed.scale(width, height);
        setImage(buttonImage);
    }
    public void act(){
        checkIfMouseIsOverButton();
        checkIfButtonIsPressed();
    }
    private void checkIfMouseIsOverButton(){
        if(Greenfoot.mouseMoved(this)){
            setImage(buttonImageRed);
        }else if(Greenfoot.mouseMoved(null)){
            setImage(buttonImage);
        }
    }
    private void checkIfButtonIsPressed(){
        if(Greenfoot.mouseClicked(this)){
            doWhenButtonIsPressed();
            Greenfoot.playSound("sounds\\ButtonSounds\\button-clicked.mp3");
        }
    }
    public abstract void doWhenButtonIsPressed();
    public GreenfootImage getButtonImage(){
        return buttonImage;
    }
    public GreenfootImage getButtonImageRed(){
        return buttonImageRed;
    }
}
