import greenfoot.*;
/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld  extends World
{
    public TestWorld()
    {
        super(900, 900, 1);
    }
    public void populate()
    {
        for (int i = 0; i<10; i++){
            Enemy enemy = new Enemy();
            addObject(enemy, (int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
        }
        
        Player player = new Player();
        addObject(player, 0, 900);
    }
}
