package riyu.admin.FlappyBird;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Administrator
 */

public class FrameRate {
    
    public void render(Graphics graphics) {
        String rateStr = Integer.toString(Main.frameRate);
        graphics.setColor(Color.red);
        graphics.drawString("FPS: " + rateStr, 0, 10);
    }
    
}
