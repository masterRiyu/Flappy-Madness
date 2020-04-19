package riyu.admin.FlappyBird;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Administrator
 */

public class ObjectHandler {
    
    LinkedList<GameObjects> object = new LinkedList<GameObjects>();
    
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObjects tempObjects = object.get(i);
            tempObjects.tick();
        }
    }
    
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObjects tempObjects = object.get(i);
            tempObjects.render(g);
        }
    }
    
    public void addObject(GameObjects object) {
        this.object.add(object);
    }
    
    public void removeObject(GameObjects object) {
        this.object.remove(object);
    }
    
}
