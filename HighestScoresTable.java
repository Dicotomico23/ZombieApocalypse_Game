import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class HighestScoresTable extends Actor
{
    GreenfootImage buttonImage = new GreenfootImage("images\\Main_Menu\\HighScores_image.jpg");
    public HighestScoresTable(){
        buttonImage.scale(400, 400);
        setImage(buttonImage);
                if (UserInfo.isStorageAvailable())
        {
            List<UserInfo> users = UserInfo.getTop(10); // Big number to try to get all
            for (UserInfo user : users)
                getWorld().showText("User: "+(user.getString(0)), 400, 400);
        }
    } 
}
