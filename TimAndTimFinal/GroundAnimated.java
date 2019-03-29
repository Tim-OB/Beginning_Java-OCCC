import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GroundAnimated here.
 * 
 * @author Tim Weaver
 * @version 0.3
 */
public class GroundAnimated extends Actor
{
    //declare variables (Tim W.)
    private int speed = 2;
    private int leftTurn = 780;
    private int rightTurn = 1000;

    /**
     * Move in the direction we are currently moving in. Turn if we reach a turning point.
     */
    public void act() 
    {
        //set initial speed (Tim W.)
        setLocation (getX() + speed, getY());
        
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
    
    /**
     * Test if we are at one of the turning points.
     */
    public boolean atTurningPoint()
    {
        //moves inbetween left and right values (Tim W.)
        return (getX() <= leftTurn || getX() >= rightTurn);
    }   
}
