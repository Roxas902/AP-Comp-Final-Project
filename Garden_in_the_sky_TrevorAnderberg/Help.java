import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends ScrollActor
{
  
    GreenfootImage Instructions = new GreenfootImage("Instructions.png");
    GreenfootImage help = new GreenfootImage("help.png");
    /**
     * Act - do whatever the Help wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    
       if (Greenfoot.mouseClicked(this)) {
            setImage(Instructions);
           
    }    

    }    
}
