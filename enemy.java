import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Collision
{
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getHit();
    }    
    public void getHit() {
        Player av = new Player();
        Actor player = getOneIntersectingObject(Player.class);
        if (av.atk()) {
            if (player != null) {
                getWorld().removeObject(this);
            }
        }
    }
}
