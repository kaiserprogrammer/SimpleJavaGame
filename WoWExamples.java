import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

class WoWExamples {
    // an anti-UFO platform placed in the center:
    static AUP a = new AUP(100);
    
    // a UFO placed in the center, near the top of the world
    static UFO u = new UFO (new Posn(100,5));
    
    // a UFO placed in the center, somewhat below u
    static UFO u2 = new UFO (new Posn(100,8));

    // a Shot, right after being fired from a
    static Shot s = new Shot(new Posn (110, 100));

    // another Shot, above s
    static Shot s2 = new Shot(new Posn (110,300));
    
    // an empty lists of shots
    static IShots le = new MtShots();

    // a list of one shot
    static IShots ls = new ConsShots(s, new MtShots());

    // a list of two shots, one above the other
    static IShots ls2 = new ConsShots(s2, new ConsShots(s, new MtShots()));

    // a complete world, with an empty list of shots
    static UFOWorld w = new UFOWorld(u,a,le);
    
    // a complete world, with two shots
    static UFOWorld w2 = new UFOWorld(u,a,ls2);

    public static void main(String[] args) {
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        JFrame f = new JFrame();
        Canvas c = new Canvas();

        f.getContentPane().add(c);
        f.setUndecorated(true);
        f.setIgnoreRepaint(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        device.setFullScreenWindow(f);

        c.createBufferStrategy(1);
        BufferStrategy strategy = c.getBufferStrategy();
        Graphics g = null;

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {}
            w2 = w2.move();
            drawWorld(strategy, w2);
        }
    }

    public static void drawWorld (BufferStrategy strategy, UFOWorld world) {
        Graphics g = strategy.getDrawGraphics();
        world.draw(g);
        g.dispose();
        strategy.show();
    }
}
