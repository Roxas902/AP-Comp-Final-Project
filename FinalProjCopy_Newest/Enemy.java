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
    private int count;
    private int pause;
    private int delay;
    private int animNum;
    public Enemy()
    {
        super();
    }
    public Enemy(int health, int attack, int defense){
        super(health,attack,defense);
    }
    /**
     * Do whatever the Enemy likes to to just now.
     */
    public void act()
    {
        if (pause==0){
            getExcited(100);
            attackPlayer(50,10);
            
    
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
    }else if (pause<0){
        pause=0;
    }else{
        pause--;
    }
    }
    public boolean findClosestPlayer(){
        
        for (int i=1; i<300; i+=10){
            List<Player> players = getObjectsInRange(i, Player.class);
            if (players.size()>0){
                turnTowards(players.get(0).getX(),players.get(0).getY());
                return true;
            }
        }
        return false;
    }
    
    public void attackPlayer(int range, int rate)
    {
       List<Player> close = getObjectsInRange(range, Player.class);
       if (close.size()>0){
           if(count==0){
               for (Player player: close){
                   player.setHealth(player.getHealth()-(int)(getAttack()/player.getDefense()+1));
                   getWorld().setCameraDirection(getRotation());
                   getWorld().moveCamera(80);
                   player.setImage("dmg.png");
                   Greenfoot.delay(8);
                   player.setImage("play.png");
                   //World world= getWorld();
                   //world.removeObject(close.get(0));
                }
            }
           count++;
           if(count>=rate){
               count=0;
           }
       
       }else{
           count = 0;
       }
    }
   public void getExcited(int range){
        
        GreenfootImage[] anim = {new GreenfootImage("en1_1.png"), new GreenfootImage("en1_2.png"),
        new GreenfootImage("en1_3.png"), new GreenfootImage("en1_4.png")};
        List<Player> players = getObjectsInRange(range, Player.class);
        if (players.size() >0) {
            if (delay == 0) {
                setImage(anim[animNum]);
                animNum++;
            }
            delay++;
            if (delay>=4){
                delay=0;
            }
        }else{
            setImage(anim[0]);
            delay=0;
            animNum=0;
        }
        if (animNum > 3) {
            animNum = 0;
        }
    }
    public void setPause(int time)
    {
        pause=time;
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
