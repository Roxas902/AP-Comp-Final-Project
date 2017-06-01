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
    public Player(int health, int attack, int defense){
        super(health,attack,defense);
    }
    public void act(){
        //findClosest();
        //move(-1);
        followMouse(5);
      
        attack(100, 20);
        
       
        if (Greenfoot.isKeyDown("D")){
            supperSpeedy(100);
        }else{
            setImage("play.png");
            if(timer>0){
                timer--;
            }
        }
        foundItem();
        if (getHealth()<0){
            getWorld().removeObject(this);
        }
    }
    public void followMouse(int speed){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
            turnTowards(mouse.getX(),mouse.getY());
            getWorld().setCameraDirection(getRotation());
        }
        move(speed);
    }
    public void followMouse() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
            getWorld().setCameraDirection(getRotation());
        }
    }
    public void move(int speed) {
        if (Greenfoot.isKeyDown("w")) {
            getWorld().moveCamera(speed);
            if(getOneTouchedObject(Wall.class) != null){
                 getWorld().moveCamera(-speed);
                }
        }
        if (Greenfoot.isKeyDown("s")) {
            getWorld().moveCamera(-speed);
             if(getOneTouchedObject(Wall.class) != null){
                 getWorld().moveCamera(speed);
                }
        }
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
    public void attack(int range, int rate){
        GreenfootImage[] anim = {new GreenfootImage("atk.png"), new GreenfootImage("atk1.png"),
        new GreenfootImage("atk2.png")};
        if (Greenfoot.isKeyDown("a")){
            if (count==0){
                List<Enemy> close = getObjectsInRange(range, Enemy.class);
                if (close.size()>0){
                    for (int i = 0; i<close.size(); i++){
                        close.get(i).setHealth(close.get(i).getHealth()-(int)(getAttack()/close.get(i).getDefense()+1));
                        close.get(i).setPause(10);
                    }
                    /*for (int x = 0; x < anim.length; x++) {
                        setImage(anim[x]);
                        Greenfoot.delay(5);    
                    }*/
                }
                for (int x = 0; x < anim.length; x++) {
                        setImage(anim[x]);
                        Greenfoot.delay(5);    
                    }
            }
            count++;
            if(count>=rate){
                count=0;
            }
        }else{
            count=0;
        }
    }    
    public void supperSpeedy(int durration){
        if (timer<=durration){
            setImage(new GreenfootImage("rocket.png"));
            move(5);
        }else{
            setImage("play.png");
        }
        timer++;
    }
    public void nextLevel()
     {
                if (getOneObjectAtOffset(0,0,TeleportArena2.class) != null)
                {
                    ScrollWorld arena2 = new Arena2();
                    arena2.addObject(new Player(), 10, 200);
                    Greenfoot.setWorld(arena2);
                }
                if (getOneTouchedObject(TeleportArena3.class) != null)
                {
                    ScrollWorld arena3 = new Arena3();
                    arena3.addObject(this, 10, 200);
                    Greenfoot.setWorld(arena3);
                }
                if (getOneTouchedObject(TeleportArena4.class) != null)
                {
                    ScrollWorld arena4 = new Arena4();
                    arena4.addObject(this, 10, 200);
                    Greenfoot.setWorld(arena4);
                }
                if (getOneTouchedObject(TeleportSpawn.class) != null)
                {
                    ScrollWorld spawn = new SpawnArena1();
                    spawn.addObject(this, 10, 200);
                    Greenfoot.setWorld(spawn);
                }
     }
}
