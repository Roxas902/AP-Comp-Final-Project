import greenfoot.*;

/**
 * A little demo world to show you how this works.
 * 
 * @author Sven van Nigtevecht
 */
public class Labratory extends ScrollWorld
{
    /**
     * Constructor for objects of class DemoWorld.
     */
    public Labratory()
    {
        super(1000, 1000, 1, 10000, 10000);
        
         addObject(new Wall(), 300, 300);
         addObject(new Wall(), 300, 150);
         addObject(new Wall(), 0, 0);
         addObject(new Wall(), 0, 100);
         addObject(new Wall(), 0, 200);
         addObject(new Wall(), 200, 0);
         addObject(new Wall(),300, 0);
        
        addCameraFollower(new Bug(), 50, -150);
        int x=350;
        int y =150;
        //for(int i =0; i<8; i++){
        //    x+= 200;
       //     addObject(new Wall(), x, y);
       // }
        y = 300;
        x=300;
        for(int i =0; i<4; i++){
            y+=150;
            addObject(new Wall(), x, y);
        }
        x=350;
        y=0;
        for(int i =0; i<8; i++){
            x+= 200;
            addObject(new Wall(), x, y);
        }
        y = 150;
        x=0;
        for(int i =0; i<5; i++){
            y+=150;
            addObject(new Wall(), x, y);
        }
        
         for(int i =0; i<3; i++){
            y+=150;
            addObject(new Wall(), 600, y);
        }
        y-=450;
        for(int i =0; i<3; i++){
            y+=150;
            addObject(new Wall(), 300, y);
        }
        y-=450;
        for(int i =0; i<3; i++){
            y+=150;
            addObject(new Wall(), 100, y);
        }
        for(int i =0; i<2; i++){
            y-=150;
            addObject(new Wall(), 800, y);
        }
        y-=150;
        for(int i =0; i<4; i++){
            y+=150;
            addObject(new Wall(), 1000, y);
        }
         y=370;
        for(int i =0; i<7; i++){
            y+=150;
            addObject(new Wall(), 1200, y);
        }
        y=370;
       for(int i =0; i<7; i++){
            y+=150;
            addObject(new Wall(), 1400, y);
        }
        addObject(new FPS(), 85, 15); // FPS isn't a subclass of
        // ScrollActor, so it will looklike it's a camera follower
    }
}