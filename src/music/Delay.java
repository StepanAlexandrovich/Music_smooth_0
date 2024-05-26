package music;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Delay {
    private int delay;

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void delay(){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
