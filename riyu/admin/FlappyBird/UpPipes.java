package riyu.admin.FlappyBird;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */

public class UpPipes extends GameObjects {
    
    private ObjectHandler handler;
    private Image backgroundImage;
    private ImageIcon backgroundIcon = new ImageIcon("src/riyu/Img/Building-Up.png");
    
    public UpPipes(int x, int y, ID id, ObjectHandler handler){
        super(x, y, id);
        this.handler = handler;
        velocityX = 2;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 100, 200);
    }
    
    public void tick() {
        if (x == 220) {
            handler.addObject(new UpPipes(430, 0, ID.UpPipe, handler));
            if (x < 220) {
                return;
            }
        }
        x -= velocityX;
        y = Main.stopper(y, 0, 0);
    }
    
    public void render(Graphics graphics) {
        try {
            backgroundImage = backgroundIcon.getImage();
        } catch (Exception e) {}
        graphics.drawImage(backgroundImage, x, y, null);
    }
    
}
