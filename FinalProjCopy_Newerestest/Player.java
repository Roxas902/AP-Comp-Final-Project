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
    private int setloco;
    private int delay = 0;
    private int animNum;
    public Player()
    {
        super();
    }
    public Player(int health, int attack, int defense){
        super(health,attack,defense);
    }
    public void act(){
        GreenfootImage image = getImage();
        image.scale(100, 100);
        setImage(image);
        followMouse(5);
        //first follows mouse
        attack(100, 20);
        atkAnim();
        //then attacks if a is pressed
          if(getOneTouchedObject(TeleportArena2.class) != null){
           nextLevel();
           
        }  
        if(getOneTouchedObject(TeleportArena3.class) != null){
           nextLevel();
        }  
        if(getOneTouchedObject(TeleportArena4.class) != null){
           nextLevel();
        }  
        if(getOneTouchedObject(TeleportSpawn.class) != null){
           nextLevel();
        }  
         if(setloco==1){
             setLocation(1000,0);
            }
        //spawns a teleporter in SpawnArena1 after 10 enemys are killed
        if(elims>=10){
           getWorld().addObject(new TeleportArena2(), 900, 1400);
        }
        
        //spawns a teleporter in Arena2 after 20 enemys are killed
        if(elims>=20){
           getWorld().addObject(new TeleportArena3(), 1375, 1800);
        }
        
        //spawns a teleporter in Arena3 after 30 enemys are killed
        if(elims>=30){
           getWorld().addObject(new TeleportArena4(), 1250, 1150);
        }
        
        //spawns a teleporter in Arena4 after 40 enemys are killed
        if(elims>=40){
           getWorld().addObject(new TeleportSpawn(), 1250, 1150);
        }
        //sprints if "d" is pressed
        if(Greenfoot.isKeyDown("D")){
            supperSpeedy(100);
        }else{
            if(timer>0){
                timer--;
            }
        }
        //picks up an item if it passes over it
        foundItem();
        //dies if health is less than zero.
        if (getHealth()<0){
            getWorld().removeObject(this);
        }
    }
    
    /**
     * will set rotation so player is facing towrds the mouse and move forward at a given speed.
     * TA,NP
     */public void followMouse(int speed){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
            turnTowards(mouse.getX(),mouse.getY());
            getWorld().setCameraDirection(getRotation());
        }
        move(speed);
    }
    public void move(int speed) {
        if (Greenfoot.isKeyDown("w")) {
            getWorld().moveCamera(speed);
            /*if(getOneTouchedObject(Wall.class) != null){
                 getWorld().moveCamera(-speed);
                 
                }*/
                if(getOneTouchedObject(TeleportArena2.class) != null){
                 getWorld().moveCamera(-speed);
                }
        }
        if (Greenfoot.isKeyDown("s")) {
            getWorld().moveCamera(-speed);
            /* if(getOneTouchedObject(Wall.class) != null){
                 getWorld().moveCamera(speed);
                }*/
                if(getOneTouchedObject(TeleportArena2.class) != null){
                 getWorld().moveCamera(speed);
                }
        }
    } 
    /**
     * finds the closest enemy and turns twards them
     * TA
     */public void findClosest(){
        
        for (int i=1; i<12; i++){
            List<Enemy> close = getObjectsInRange(i, Enemy.class);
            if (close.size()>0){
                turnTowards(close.get(0).getX(),close.get(0).getY());
                break;
            }
        }
    }
    /**
     * will attack all enemies within the given range 
     * will attact everytime the key "a" is pressed, and will attack at a set rate if the key is held
     * health damage is determined by the ratio of the attack strenght and the enimies defense.
     * when enemies are attacked it will set thier pause time to 10.
     * TA
     */public boolean attack(int range, int rate){
        boolean attacked = false;
        if (Greenfoot.isKeyDown("a")){
            if (count==0){
                List<Enemy> close = getObjectsInRange(range, Enemy.class);
                if (close.size()>0){
                    for (int i = 0; i<close.size(); i++){
                        close.get(i).setHealth(close.get(i).getHealth()-(int)(getAttack()/close.get(i).getDefense()+1));
                        close.get(i).setPause(10);
                        close.get(i).setAttacked(true);
                    }
                    attacked = true;
                }
            }
            count++;
            if(count>=rate){
                count=0;
            }
        }else{
            count=0;
        }
        return attacked;
    }    
    /**
     * Allows for player to sprint for a durration amount of acts.
     * When not sprinting the amount of sprint time will increase back to the maximum
     * TA
     */public void supperSpeedy(int durration){
        if (timer<=durration){
            setImage(new GreenfootImage("rocket.png"));
            move(5);
        }else{
            setImage("play.png");
        }
        timer= 0;
    }
    public void nextLevel()
     {
                if (getOneTouchedObject(TeleportArena2.class) != null)
                {
                    ScrollWorld arena2 = new Arena2();
                    arena2.addCameraFollower(new Player(), 0, 0);
                    Greenfoot.setWorld(arena2);
                    elims=0;
                    
                }
                if (getOneTouchedObject(TeleportArena3.class) != null)
                {
                    ScrollWorld arena3 = new Arena3();
                    arena3.addCameraFollower(new Player(), 0, 0);
                    Greenfoot.setWorld(arena3);
                    elims=0;
                }
                if (getOneTouchedObject(TeleportArena4.class) != null)
                {
                    ScrollWorld arena4 = new Arena4();
                    arena4.addCameraFollower(new Player(), 0, 0);
                    Greenfoot.setWorld(arena4);
                    elims=0;
                }
                if (getOneTouchedObject(TeleportSpawn.class) != null)
                {
                    ScrollWorld spawn = new SpawnArena1();
                    spawn.addCameraFollower(new Player(), 0, 0);
                    Greenfoot.setWorld(spawn);
                    elims=0;
                }
     }
     public void atkAnim() {
        GreenfootImage def = new GreenfootImage("play.png");
        def.scale(100, 100);
        GreenfootImage im1 = new GreenfootImage("atk.png");
        im1.scale(100, 100);
        GreenfootImage im2 = new GreenfootImage("atk1.png");
        im2.scale(100, 100);
        GreenfootImage im3 = new GreenfootImage("atk2.png");
        im3.scale(100, 100);
        GreenfootImage[] anim = {im1, im2, im3};
        if (Greenfoot.isKeyDown("A") && count < 30) {
            if (delay == 0) {
                setImage(anim[animNum]);
                animNum++;
            }
            delay++;
            if (delay>=10){
                delay=0;
            }
            if (animNum > 2) {
                animNum = 0;
            }
        }
        else {
            setImage(def);
        }
    }
}
