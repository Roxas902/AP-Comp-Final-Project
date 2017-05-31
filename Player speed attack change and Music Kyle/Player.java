import greenfoot.*;

/**
 * An demo class which is meant to be a camera follower.
 * It moves to face your mouse cursor, and it can move
 * back and forward.
 * 
 * @author Sven van Nigtevecht
 * @version 1.0
 */
public class Player extends ScrollActor
{
    /** The number of cells we move forward and backword */
    private static int MOVE_AMOUNT = 5;
    private static int TURN_AMOUNT = 5;
    private static int Attack = 1;
    private static int Defense = 2;
     private GreenfootSound backgroundMusic = new GreenfootSound("Interstellar 8-Bit Theme.mp3");
        
    
    public void gameOver(){
        backgroundMusic.stop();
    }
    /**
     * Move to face the mouse,
     * and listen to the up and down keys.
     */
    public void act()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        removePickUp();
        Actor Apple;
        backgroundMusic.playLoop();
        Apple = getOneIntersectingObject(Apple.class);
        if (m != null) {
            turnTowards(m.getX(), m.getY());
            // set the camera's direction to ours:
            getWorld().setCameraDirection(getRotation());
        }
        if (Greenfoot.isKeyDown("A")) {
            // move the camera backwards:
            getWorld().moveCamera(-MOVE_AMOUNT);
        }
        if (Greenfoot.isKeyDown("W")) {
            // move the camera forwards:
            getWorld().moveCamera(MOVE_AMOUNT);
        }

        
    }

    private void removePickUp()
    {
        
        Actor Player = getOneIntersectingObject(Player.class);
        Actor Apple;
        Actor Rock;
        Actor Mushroom = getOneIntersectingObject(Mushroom.class);
        Apple = getOneIntersectingObject(Apple.class);
        Rock = getOneIntersectingObject(Rock.class);
        if (Mushroom != null){
            World world;
            world = getWorld();
            world.removeObject(Mushroom);
            if (Attack < 3){
                Attack += 1;
            }
        }
        if (Apple != null)
        {
            World world;
            world = getWorld();
            world.removeObject(Apple);

            TURN_AMOUNT = 7;
            MOVE_AMOUNT = 7;

        }
        if (Rock != null){

            World world;
            world = getWorld();
            world.removeObject(Rock);            //This removes the ROck and ends the game when you touch it
            getWorld().addObject(new Rock(), (Greenfoot.getRandomNumber(1000)), (Greenfoot.getRandomNumber(70)));
            Defense--;
            if (Defense == 0){
                
                gameEnd();  
                gameOver();
            }
        }

    }

   

    

    public void gameEnd(){
        
        Greenfoot.stop();
        Greenfoot.playSound("Super Mario Death Sound - Sound Effect.mp3");
        
    }
}
/**
 * import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 *
 */