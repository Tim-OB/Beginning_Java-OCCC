import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls the actor Enemy.
 * 
 * @author (Tim W. & Tim O.) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    //declare variables (Tim W.)
    private int speed = 1;
    private int leftTurn = 480;
    private int rightTurn = 685;
    
    public void act() 
    {
             move();
             enemyShot();
    } 
    
    public void move()
    {
        //set initial speed (Tim W.)
        setLocation ( getX() + speed, getY() );
        
        //declare move (Tim W.)
        Actor move = getOneIntersectingObject(null);
        
        //make block move (Tim W.)
        if(move != null) 
        {
            move.setLocation (move.getX() + speed, move.getY());
        }
        
        //reverse direection once at turning point (Tim W.)
        if (atTurningPoint()) 
        {
            speed = -speed;
        }             
    }
    
    //If bullet hits the enemy add 10 points. (Tim O.)
    public void enemyShot(){
        Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
        MyWorld w = (MyWorld) getWorld();
        CountScore countScore = w.getScore();
        
        if(bullet != null){
            w.addScore(10);
            getWorld().removeObject(this);
        }
    }
    
    //moves inbetween left and right values (Tim W.)
    public boolean atTurningPoint()
    {
        return (getX() <= leftTurn || getX() >= rightTurn);
    } 
}
