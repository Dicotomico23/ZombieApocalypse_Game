import greenfoot.*;

/**
 * Write a description of class ButtonTemplateMethod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ButtonTemplateMethod extends Actor
{
    String buttonName;
    public ButtonTemplateMethod(String buttonName){
        this.buttonName = buttonName;
        GreenfootImage buttonImage = new GreenfootImage("images\\Buttons\\"+buttonName+".png");
        buttonImage.scale(200, 100);
        setImage(buttonImage);
    }
    public void act(){
        CheckIfMouseIsOverButton();
        CheckIfButtonIsPressed();
    }
    private void CheckIfMouseIsOverButton(){
        if(Greenfoot.mouseMoved(this)){
            GreenfootImage buttonImage = new GreenfootImage("images\\Buttons\\"+buttonName+"_red.png");
            buttonImage.scale(200, 100);
            setImage(buttonImage);
        }else if(Greenfoot.mouseMoved(null)){
            GreenfootImage buttonImage = new GreenfootImage("images\\Buttons\\"+buttonName+".png");
            buttonImage.scale(200, 100);
            setImage(buttonImage);
        }
    }
    private void CheckIfButtonIsPressed(){
        if(Greenfoot.mouseClicked(this)){
            DoWhenButtonIsPressed();
            Greenfoot.playSound("sounds\\ButtonSounds\\button-clicked.mp3");
        }
    }
    public abstract void DoWhenButtonIsPressed();
}
