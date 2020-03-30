
package autoclicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * Auto-Clicker.
 * 
 * @author Alex Vasil
 */
public class AutoClicker {

    private int delay = 1;
    private Robot bot;
    
    public AutoClicker() {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    
    public void clicker() {
        bot.setAutoDelay(delay);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
    
}
