 import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.Random;

/**
 * A world where wombats live.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class WombatWorld extends World
{
    /**
     * Create a new world with 8x8 cells and
     * with a cell size of 60x60 pixels
     */
    public WombatWorld() 
    {
        super(900, 900, 1);        
        //setBackground("wombat.gif");
    }

    /**
     * Populate the world with a fixed scenario of wombats and leaves.
     */    
    public void populate()
    {
        for (int i = 0; i<10; i++){
            Wombat wombat = new Wombat();
            addObject(wombat, (int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
        }
        
        Leaf leaf = new Leaf();
        addObject(leaf, 0, 900);
    }
    
    /**
     * Place a number of leaves into the world at random places.
     * The number of leaves can be specified.
     */
    public void randomLeaves(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            Leaf leaf = new Leaf();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(leaf, x, y);
        }
    }
}