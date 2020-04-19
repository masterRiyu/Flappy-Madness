package riyu.admin.FlappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */

public class Player extends GameObjects {
    
    private ObjectHandler handler;
    private Image backgroundImage;
    private ImageIcon backgroundIcon = new ImageIcon("src/riyu/Img/Jet.png");
    private boolean isHit = false;
      
    public Player(int x, int y, ID id, ObjectHandler handler) {
        super(x, y, id);
        this.handler = handler;
        velocityY = 2;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 63, 41);
    } 
    
    public void tick() {
        y += velocityY;
        collision();
    }
    
    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObjects tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.DownPipe || tempObject.getID() == ID.UpPipe) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    System.exit(0);
                }
            }
        }
    }
    
    public void render(Graphics graphics) {
        try {
            backgroundImage = backgroundIcon.getImage();
        } catch (Exception e) {}
        graphics.drawImage(backgroundImage, x, y, null);
    }
    
}
