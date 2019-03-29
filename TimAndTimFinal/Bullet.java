import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bullet's superclass is character, handles the actor bullet.
 * 
 * @author (Tim O. & Tim W.) 
 * @version (a version number or a date)
 */
public class Bullet extends Character
{
    //declare variables
    private int life = 20;
    private int speed = 30; 
    
    public Bullet()
    {
    }
   
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //removes bullet when life gets less than 0 (Tim W. & Tim O.)
        if(life<=0){
            getWorld().removeObject(this);
        }else{
            life--;
            move(speed);
        }
    }       
}
