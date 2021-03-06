import greenfoot.*;
import java.awt.Color;

/**
 * Displays the number of frames per second on 
 * a given scenario.
 * 
 * @author Michael Berry (mjrb4)
 * @version 06/07/08
 */
public class Display extends Actor
{
    /**
     * The two possbile modes the calculation can take.
     * 
     * Average will display the number of frames that 
     * were displayed in the previous second, thereby
     * giving you an average Display reading from the last
     * second.
     * 
     * Realtime will calculate the time difference 
     * between this frame and the last one and then
     * update the reading after each and every frame.
     * This is potentially more accurate if you want
     * to find accurateintermittent spikes in 
     * framerates, but less accurate for a simple reading.
     */
    public enum Mode {AVERAGE, REALTIME}
    /**
     * The mode that the Display reading should take.
     * For most uses, leave this as Mode.AVERAGE.
     */
    public static final Mode mode = Mode.REALTIME;
    
    private static final Color textColor = Color.BLACK;
    private static final String prefix = "Display: ";
    private static final int updateFreq = 20;
    private long countAct;
    private long prevTime;
    private double Display;
    
    /**
     * Create a new Display reading.
     */
    public Display()
    {
        countAct = 0;
        setImage(new GreenfootImage(150, 16));
        GreenfootImage image = getImage();
        updateImage("-");
    }
    
    /**
     * Set the value of the frames per second.
     * @param val the value to set the Display to.
     */
    private void setDisplay(Long val)
    {
        Display = val;
        updateImage(val.toString());
    }
    
    /**
     * Set the value of the frames per second.
     * @param val the value to set the Display to.
     */
    private void setDisplay(Double val)
    {
        Display = val;
        updateImage(val.toString());
    }
    
    /**
     * Get the number of frames per second.
     * @return the number of frames per second.
     */
    public double getDisplay()
    {
        return Display;
    }
    
    /**
     * Calculate the Display based on the mode, and
     * update the reading.
     */
    public void act()
    {
        countAct++;
        if (mode == Mode.REALTIME) {
            long gap = System.currentTimeMillis() - prevTime;
            if(gap != 0 && countAct%updateFreq == 0) {
                countAct = 0;
                setDisplay((1.0 /gap) *1000.0);
            }
            prevTime = System.currentTimeMillis();
        } else if (mode == Mode.AVERAGE) {
            long curTime = System.currentTimeMillis();
            if(curTime >= prevTime +1000) {
                setDisplay(countAct);
                prevTime = curTime;
                countAct = 0;
            }
        }
    }
    
    /**
     * Draw the image.<p>
     * Sven van Nigtevecht slightly changed this,
     * not so special though.
     * @param value the Display value
     */
    private final void updateImage(String value)
    {
        getImage().clear();
        GreenfootImage txt = new GreenfootImage(prefix +value, 16, textColor, null);
        getImage().drawImage(txt, 1, 1);
    }
}
