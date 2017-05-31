import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Overworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overworld extends ScrollWorld
{

    /**
     * Constructor for objects of class Overworld.
     * 
     */
    public Overworld()
    {    
        super(600, 600, 1, 2000, 2000);
        addObject(new enemy(), 600, 600);
        addCameraFollower(new Player(), 0, 0);
    }
}
