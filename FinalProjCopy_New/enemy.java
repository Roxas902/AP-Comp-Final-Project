import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Collision
{
    private int HP = 1;
    private int delay = 0;
    private int animNum = 0;
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        atkAnim();
        getHit();
    }    
    public void atkAnim() {
        delay++;
        GreenfootImage[] anim = {new GreenfootImage("en1_1.png"), new GreenfootImage("en1_2.png"),
        new GreenfootImage("en1_3.png"), new GreenfootImage("en1_4.png")};
        Actor player = getOneIntersectingObject(Player.class);
        if (animNum > 2) {
            animNum = 0;
        }
        if (player != null) {
            if (delay%4 == 0) {
                setImage(anim[animNum]);
                animNum++;
            }
        }
        if (player == null) {
            setImage(anim[0]);
        }
    }
    public void getHit() {
        Player av = new Player();
        Actor player = getOneIntersectingObject(Player.class);
        if (av.atk()) {
            if (player != null) {
                HP--;
                if (HP <= 0) {
                    getWorld().removeObject(this);
                }
            }
        }
    }
}
