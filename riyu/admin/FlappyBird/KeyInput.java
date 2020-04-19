package riyu.admin.FlappyBird;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Administrator
 */

public class KeyInput extends KeyAdapter {
    
    private ObjectHandler handler;
    
    public KeyInput(ObjectHandler handler) {
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObjects tempObjects = handler.object.get(i);
            if (tempObjects.getID() == ID.Player) {
                if (key == KeyEvent.VK_SPACE) {
                    tempObjects.setVelocityY(-5);
                }
            }
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(0);
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObjects tempObjects = handler.object.get(i);
            if (tempObjects.getID() == ID.Player) {
                if (key == KeyEvent.VK_SPACE) {
                    tempObjects.setVelocityY(2);
                }
            }
        }
    }
    
}
