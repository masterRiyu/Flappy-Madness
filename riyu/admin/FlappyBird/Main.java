package riyu.admin.FlappyBird;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */

public class Main extends Canvas implements Runnable {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 640;
    public static boolean running = false;
    public static int frameRate;
    private Thread thread;
    private ObjectHandler handler;
    private Random r;
    private FrameRate rate;
    private Image backgroundImage;
    private ImageIcon backgroundIcon = new ImageIcon("src/riyu/Img/Game.png");
    
    public Main() {  
        handler = new ObjectHandler();
        r = new Random();
        rate = new FrameRate();  
        this.addKeyListener(new KeyInput(handler));
        new Environment(WIDTH, HEIGHT, "Flappy Bird", this);
        handler.addObject(new Player(WIDTH/3 - 60, HEIGHT/2 - 32, ID.Player, handler));
        handler.addObject(new DownPipes(430, 532, ID.DownPipe, handler));  
        handler.addObject(new GapGoal(530, 532, ID.GapGoal, handler));
        handler.addObject(new UpPipes(430, 0, ID.UpPipe, handler));
    }
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            
        }
    }
    
    @Override
    public void run() {
        this.requestFocus();  
        // game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frameRate = frames;
                frames = 0;
            }
        }
        stop();
    }
    
    public void tick() {
        handler.tick();
    }
    
    public void render() {
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = buffer.getDrawGraphics();
        try {
            backgroundImage = backgroundIcon.getImage();
        } catch (Exception e) {}
        graphics.drawImage(backgroundImage, 0, 0, this);
        handler.render(graphics);
        rate.render(graphics);
        graphics.dispose();
        buffer.show();
    }
    
    public static int stopper(int variable, int min, int max) {
        if (variable > max)
            return variable = max;
        else if (variable < min)
            return variable = min;
        else
            return variable;
    }
    
    public static void main(String[] args) {       
        new Main();       
    }
    
}
