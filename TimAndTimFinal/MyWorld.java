import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Tim Weaver & Tim O'Brien
 * @version 0.7
 */
public class MyWorld extends World
{
    private CountScore countScore;
    int score = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels. (Tim W.)
        super(1280, 720, 1); 

        //Place ground on map (Tim W.)
        addObject (new Ground(), 32,525);
        addObject (new Ground(), 97, 525);
        addObject (new Ground(), 162, 590);
        addObject (new Ground(), 1008, 655);
        addObject (new GroundHalf(), 487, 395);
        addObject (new GroundHalf(), 552, 395);
        addObject (new GroundHalf(), 617, 395);
        addObject (new GroundHalf(), 682, 395);
        addObject (new Rock(), 227, 460);
        addObject (new Rock(), 292, 460);
        addObject (new Rock(), 357, 460);
        addObject (new GroundAnimated(), 812, 460);
        addObject (new GroundNoGrass(), 1118, 590);
        addObject (new GroundNoGrass(), 1183, 590);
        addObject (new GroundNoGrass(), 1248, 590);

        //Place character on map (Tim W.)
        addObject (new Character(), 25, 454);

        //Place crystals on map (Tim W.)
        addObject (new Crystal(), 357, 397);
        addObject (new Crystal(), 292, 397);
        addObject (new Crystal(), 227, 397);
        addObject (new Crystal(), 1117, 526);
        addObject (new Crystal(), 1182, 526);
        addObject (new Crystal(), 1007, 599);
        
        //Add Monster (Tim W.)
        addObject (new Enemy(), 680, 335);
        
        //Place treasue chest (Tim W.)
        addObject (new TreasureChest(), 1247, 529); 

        //Add the Score Counter (Tim 0.)
        countScore = new CountScore();
        addObject(countScore, 700, 30);
       
    }

    //Adds to the score counter (Tim 0.)
    public void addScore(int a){
        countScore.add(a);
    }
    //(Tim 0.)
    public CountScore getScore(){
        return countScore;
    }
    
}
