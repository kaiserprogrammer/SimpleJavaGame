import java.awt.*;

import javax.swing.*;
import java.awt.image.*;

class WoWExamples {
  // an anti-UFO platform placed in the center:
  static AUP a = new AUP(100);

  // a UFO placed in the center, near the top of the world
  static UFO u = new UFO(new Posn(100, 5));

  // a Shot, right after being fired from a
  static Shot s = new Shot(new Posn(110, 100));

  // another Shot, above s
  static Shot s2 = new Shot(new Posn(110, 300));

  // a list of two shots, one above the other
  static IShots ls = new ConsShots(s2, new ConsShots(s, new MtShots()));

  // a complete world, with two shots
  static UFOWorld w = new UFOWorld(u, a, ls);

  public static void main(String[] args) throws InterruptedException {
    GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    JFrame frame = new JFrame(gc);
    frame.setVisible(true);
    frame.setIgnoreRepaint(true);
    frame.setSize(w2.WIDTH, w2.HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.createBufferStrategy(3);
    BufferStrategy strategy = frame.getBufferStrategy();

    for (int i = 0; i < 100; i++) {
      try {
        Thread.sleep(30);
      } catch (Exception e) {
      }
      w2 = w2.move();
      do {
        do {
          Graphics g = strategy.getDrawGraphics();
          w2.draw(g);
          g.dispose();
        } while (strategy.contentsRestored());
      } while (strategy.contentsLost());
      strategy.show();
    }
  }
}
