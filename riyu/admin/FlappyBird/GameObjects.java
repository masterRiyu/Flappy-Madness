package riyu.admin.FlappyBird;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Administrator
 */

public abstract class GameObjects {
    
    protected int x;
    protected int y;
    protected int velocityX;
    protected int velocityY;
    protected ID id;
    
    public GameObjects(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    // getters
    public int getX() {
        return x;
    }    
    public int getY() {
        return y;
    }
    public int getVelocityX() {
        return velocityX;
    }
    public int getVelocityY() {
        return velocityY;
    }
    public ID getID() {
        return id;
    }
    
    // setters
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
    public void setID(ID id) {
        this.id = id;
    }
    
    // abstracts
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
}
