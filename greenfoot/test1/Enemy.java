import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy  extends Character
{
    private int direction;
    private int speed;
    public Enemy()
    {
        
    }
    /**
     * Do whatever the Enemy likes to to just now.
     */
    public void act()
    {
        attackPlayer(50);
            
    
        if(findClosestPlayer()){
            randomSpeed(2,6);
            move(speed);
        }else{
            moveRandom();
        }
        foundItem();
        if (getHealth()<0){
            getWorld().removeObject(this);
        }
    }
    public boolean findClosestPlayer(){
        
        for (int i=1; i<600; i+=10){
            List<Player> players = getObjectsInRange(i, Player.class);
            if (players.size()>0){
                turnTowards(players.get(0).getX(),players.get(0).getY());
                return true;
            }
        }
        return false;
    }
    /**
     * Check whether there is a Player in the same cell as we are.
     */
    public void attackPlayer(int range)
    {
       List<Player> close = getObjectsInRange(range, Enemy.class);
            if (close.size()>0){
                for (Player player: close){
                    player.setHealth(player.getHealth()-(int)(getAttack()/player.getDefense()-1));
                            //World world= getWorld();
                            //world.removeObject(close.get(0));
                }
            }
    }
    /**
     * Eat a Player.
     */
    public void eatPlayer()
    {
        Actor Player = getOneObjectAtOffset(0, 0, Player.class);
        if(Player != null) {
            // eat the Player...
            getWorld().removeObject(Player);
        }
    }
    public void moveRandom()
    {
        setRotation(getRotation()+(int)(Math.random()*10-5));
        randomSpeed(0,1);
        move(speed);
    }
    public void randomSpeed(int min,int max){
        if (speed>=max){
            speed=max-(int)(Math.random()*2);
        }else if (speed<=min){
            speed=min+(int)(Math.random()*2);
        }else{
            speed=speed+(int)(Math.random()*3)-1;
        }
    }
}
