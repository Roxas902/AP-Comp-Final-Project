import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Collision
{
    private int moveDelay = 0;
    private int hp;
    private static final int MOVE_AMT = 5;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player() {
        this.hp = 3;
    }
    public void act() 
    {
       followMouse();
       move();
       atk();
       getHit();
       if (this.hp <= 0) {
           Greenfoot.stop();
        }
       
    }
    public void followMouse() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
            getWorld().setCameraDirection(getRotation());
        }
    }
    public void move() {
        if (Greenfoot.isKeyDown("w")) {
            getWorld().moveCamera(MOVE_AMT);
        }
        if (Greenfoot.isKeyDown("s")) {
            getWorld().moveCamera(-MOVE_AMT);
        }
    } 
    public boolean atk() {
        GreenfootImage[] anim = {new GreenfootImage("atk.png"), new GreenfootImage("atk1.png"),
        new GreenfootImage("atk2.png")};
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            if (Greenfoot.mouseClicked(null)) {
                for (int x = 0; x < anim.length; x++) {
                    setImage(anim[x]);
                    Greenfoot.delay(5);
                }
                setImage("play.png");
                return true;
            }
        }
        return false;
    }
    public void getHit() {
        Actor pl = getOneTouchedObject(enemy.class);
        if (!atk()) {
            if (pl != null) {
                this.hp--;
                getWorld().moveCamera(-80);
                setImage("dmg.png");
                Greenfoot.delay(8);
                setImage("play.png");
            }
        }
    }
}
