import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Character
{
    private int timer;
    private int count;
    public Player()
    {
        super();
    }
    public void act(){
        //findClosest();
        //move(-1);
        FollowMouse(5);
      
        attack(100, getAttack(), 10);
        
          
        
        if (Greenfoot.isKeyDown("S")){
            supperSpeedy(100);
        }else{
            setImage("car03.png");
            if(timer>0){
                timer--;
            }
        }
        foundItem();
        if (getHealth()<0){
            getWorld().removeObject(this);
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
            List<Enemy> close = getObjectsInRange(i, Enemy.class);
            if (close.size()>0){
                turnTowards(close.get(0).getX(),close.get(0).getY());
                break;
            }
        }
    }
    public void attack(int range, int power, int rate){
        
        if (Greenfoot.isKeyDown("A")){
            if (count==0){
                List<Enemy> close = getObjectsInRange(range, Enemy.class);
                if (close.size()>0){
                    for (Enemy enemy: close){
                        enemy.setHealth(enemy.getHealth()-(int)(getAttack()/enemy.getDefense()-1));
                        //World world= getWorld();
                        //world.removeObject(close.get(0));
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
