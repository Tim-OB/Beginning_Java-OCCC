import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author Tim Weaver, Tim O'Brien
 * @version 0.8
 */
public class Character extends Actor
{ 
    private static final int acceleration = 1;      // down (gravity)
    private static final int speed = 5;             // running speed (sideways)
    private int vSpeed = 0;                         // current vertical speed
    private static final int jumpStrength = 15;     // jump strength
    private int reloadDelayCount, walkCount;                   // delay gun reload
    private static final int gunReloadTime = 5;     // reload time
    private int score;
   
    GreenfootImage Right = new GreenfootImage("CharacterRight.png"); //set image 
    GreenfootImage Left = new GreenfootImage("CharacterLeft.png");   //set image
    GreenfootSound walk = new GreenfootSound("Walking.wav");
    GreenfootSound jump = new GreenfootSound("Jumping.wav");
    
    //(Tim W.)
    public Character()
    {
        reloadDelayCount = 5; //set reload count to 5 (Tim W.)
        walkCount = 1;
    }
    
    //(Tim W. & Tim O.)
    public void act() 
    {
        reloadDelayCount++;    //add more bullets
        checkKeys();           
        isTouchingGem();
        isTouchingEnemy();
        checkFall(); 
        atChest();
        finalScore();    
    }
    
    //check which keys the player is pressing (Tim W.)
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left") )
        {
            setImage(Left);
            setRotation(180);
            moveLeft();      
            walk.play();
        }
        
        if (Greenfoot.isKeyDown("right") )
        {
            setImage(Right);
            setRotation(0);
            moveRight();
            walk.play();
        }
        
        if (Greenfoot.isKeyDown("up") )
        {
            if (onGround() || onRock() || onGroundHalf() || onGroundAnimated() || onGroundNoGrass())
            {
                jump();
                jump.play();
            }
        }
        
        if(Greenfoot.isKeyDown("space")){
            fireB();          
        }
        
    }    
    
    //jump up to jump strength then fall back down (Tim W.)
    private void jump()
    {
        setVSpeed(-jumpStrength);
        fall();
    }
    
    //fall if character is not on the ground (Tim W.)
    private void checkFall()
    {
        if (onGround() || onRock() || onGroundHalf() || onGroundAnimated() || onGroundNoGrass()) 
        {
            setVSpeed(0);
        }
        else 
        {
            fall();
        }
    }  
    
    //move character right (Tim W.)
    public void moveRight()
    {
        setLocation (getX() + speed, getY());
        //Greenfoot.playSound("Walking.wav");
    }
    
    //move character left (Tim W.)
    public void moveLeft()
    {
        setLocation (getX() - speed, getY());
        //Greenfoot.playSound("Walking.wav");
    }
    
    //check if on ground (Tim W.)
    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
        return under != null;
    }
    
    //check if on ground (Tim W.)
    public boolean onRock()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2, Rock.class);
        return under != null;
    }
    
    //check if on ground (Tim W.)
    public boolean onGroundHalf()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2, GroundHalf.class);
        return under != null;
    }

    //check if on ground (Tim W.)
    public boolean onGroundNoGrass()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2+8, GroundNoGrass.class);
        return under != null;
    }
    
    //check if on ground (Tim W.)
    public boolean onGroundAnimated()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2, GroundAnimated.class);
        return under != null;
    }
    
    //setter for vertical speed (Tim W.)
    public void setVSpeed(int speed)
    {
        vSpeed = speed;
    }
    
    //make character fall (Tim W.)
    public void fall()
    {
        setLocation (getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
        
        if (atBottom())
        {
            gameEnd(); //if at the bottom of the screen, end the game (Tim W.)
        }
    }
    
    //Gem collision. (Tim O.)
    public void isTouchingGem(){
        Crystal crystal = (Crystal) getOneIntersectingObject(Crystal.class);
        
        if(crystal != null){
            getWorld().removeObject(crystal);
            MyWorld world = (MyWorld)getWorld();
            world.addScore(5);
            Greenfoot.playSound("Gem.wav");
        }
    }

    //Final score screen. (Tim O.)
    public void finalScore(){
        MyWorld w = (MyWorld) getWorld();
        CountScore countScore = w.getScore();
        
        score = countScore.score;
        
        if(atBottom()){
            getWorld().removeObject(countScore);
            getWorld().addObject(new GameEnd("Game Over", score), 637, 357);
            Greenfoot.playSound("GameOver.wav");
        }
    }
    
    //Enemy Collision (Tim O.)
    public void isTouchingEnemy(){
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        
        MyWorld w = (MyWorld) getWorld();
        CountScore countScore = w.getScore();
        
        score = countScore.score;
        
        if(enemy != null){
            getWorld().removeObject(countScore);
            getWorld().addObject(new GameEnd("Game Over", score), 637, 357);
            Greenfoot.playSound("GameOver.wav");
            Greenfoot.stop();
        }
        
    }
    
    //Fire the bullet (Tim O. & Tim W.)
    public void fireB(){
        if(reloadDelayCount >= gunReloadTime)
        {
            Bullet bullet = new Bullet();
            getWorld().addObject (bullet, getX()+40, getY()+7);
            bullet.setRotation(getRotation());
            reloadDelayCount = 0; 
            Greenfoot.playSound("Blaster.wav");
        }
    }
    
    //End game once character reaches the chest (Tim W. & Tim O.)
    public void atChest()
    {
        TreasureChest chest = (TreasureChest) getOneIntersectingObject(TreasureChest.class);
        MyWorld w = (MyWorld) getWorld();
        CountScore countScore = w.getScore();
        
        score = countScore.score;
        
        if (chest != null){
            Greenfoot.stop();
            getWorld().removeObject(countScore);
            getWorld().addObject(new GameEnd("Game Over", score), 637, 357);
            Greenfoot.playSound("Victory.wav");
        } 
    }
    
    //returns y position at bottom (Tim W.)
    public boolean atBottom()
    {
        return getY() >= getWorld().getHeight() - 2;
    }
    
    //ends the game (Tim W.)
    private void gameEnd()
    {
        Greenfoot.stop();
    }
}

