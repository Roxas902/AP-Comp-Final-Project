import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Leaf - a class for representing leafs.
 *
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Leaf extends Actor
{
    private int timer;
    private int count;
    public Leaf()
    {
    }
    public void act(){
        //findClosest();
        //move(-1);
        FollowMouse(5);
      
        attack(100, 10);
        
          
        
        if (Greenfoot.isKeyDown("S")){
            supperSpeedy(100);
        }else{
            setImage("car03.png");
            if(timer>0){
                timer--;
            }
        }
    }
    public void FollowMouse(int speed){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
            turnTowards(mouse.getX(),mouse.getY());
        }
        move(speed);
    }
    public void findClosest(){
        
        for (int i=1; i<12; i++){
            List<Wombat> close = getObjectsInRange(i, Wombat.class);
            if (close.size()>0){
                turnTowards(close.get(0).getX(),close.get(0).getY());
                break;
            }
        }
    }
    public void attack(int range, int rate){
        
        if (Greenfoot.isKeyDown("A")){
            if (count==0){
                List<Wombat> close = getObjectsInRange(range, Wombat.class);
                if (close.size()>0){
                    for (Wombat wombat: close){
                        World world= getWorld();
                        world.removeObject(close.get(0));
                    }
                }
            }
            count++;
            if(count==rate){
                count=0;
            }
        }else{
            count=0;
        }
    }    
    public void supperSpeedy(int durration){
        if (timer<=durration){
            setImage("rocket.png");
            move(5);
        }else{
            setImage("car03.png");
        }
        timer++;
    }
}