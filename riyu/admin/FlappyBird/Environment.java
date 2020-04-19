package riyu.admin.FlappyBird;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */

public class Environment extends Canvas {
    
    public Environment(int width, int height, String title, Main main) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(main);
        main.start();
    }
    
}
