import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameEnd extends Actor
{
    private int score;
    private String m;
    
    public GameEnd(String m, int score){
        this.m = m;
        this.score = score;
        build();
    }
   
     public void build(){
        
        GreenfootImage image = new GreenfootImage(1280, 720);
       
        
        image.setColor(new Color(0, 0, 0, 120));
        image.fillRect(5, 5, 1280, 720);
        
        Font font = image.getFont();
        font = font.deriveFont(60);
        image.setFont(font);
        
        image.drawString(m , 640, 100);
        image.drawString("Score: " + score, 640, 300);
        setImage(image);   
    
    }
    
  
    
}
