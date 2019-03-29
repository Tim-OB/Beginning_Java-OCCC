import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CountScore here.
 * 
 * @author Tim O'Brien & Tim Weaver 
 * @version (1.0)
 */
public class CountScore extends Actor
{
    private static final Color trans = new Color(0,0,0,0);
    int score;
    
    public CountScore(){
        setImage(new GreenfootImage("Score: " + score, 25, Color.BLACK, trans));
    }
    
    public void act(){
        setImage(new GreenfootImage("Score: " + score, 25, Color.BLACK, trans));
    }

    public void add(int a){
        score += a;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
}
