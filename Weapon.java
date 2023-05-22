import greenfoot.*;

public interface Weapon  
{
    void setDamage(int damage);
    int getDamage();
    void setPlayerSprites(String [][] spriteArray);
    String [][] getPlayerSprites();
    void setWeaponImage(GreenfootImage weaponImage);
    GreenfootImage getWeaponImage();
}
