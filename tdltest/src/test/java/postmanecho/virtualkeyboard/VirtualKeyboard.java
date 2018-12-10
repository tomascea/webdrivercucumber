package postmanecho.virtualkeyboard;

import java.awt.*;

public class VirtualKeyboard {

    /*
      Simulate how a keyboard user presses and releases a key
     */
    public void enterKey(int key) {
        Robot robot = null;
        try {
            robot = new Robot();
            robot.keyPress(key);
            robot.keyRelease(key);
            //to see the entering text while looking at the UI, add a thread sleep
           /* try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /*
      To enter a string like using the keyboard
     */
    public void pressKeys(String string) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            enterKey(Character.toUpperCase(c));
        }
    }
}
