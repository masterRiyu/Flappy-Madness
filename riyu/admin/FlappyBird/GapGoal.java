package riyu.admin.FlappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Administrator
 */

public class GapGoal extends GameObjects {
    
    private ObjectHandler handler;
    
    public GapGoal(int x, int y, ID id, ObjectHandler handler) {
        super(x, y, id);
        this.handler = handler;
        velocityX = 2;
    }
    
    public void tick() {
        if (x == 320) {
            handler.addObject(new GapGoal(530, 532, ID.GapGoal, handler));
            if (x < 320) {
                return;
            }
        }
        x -= velocityX;
        y = Main.stopper(y, 0, 0);
        collision();
    }
    
    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObjects tempObjects = handler.object.get(i);
            if (tempObjects.getID() == ID.Player) {
                if (getBounds().intersects(tempObjects.getBounds())) {
                }
            }
        }
    }
    
    public void render(Graphics graphics) {
        graphics.setColor(new Color(51, 51, 51));
        graphics.fillRect(x, y, 0, 640);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 1, 640);
    }
    
}
