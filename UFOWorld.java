import java.awt.*;
import javax.swing.*;
// the world of UFOs, AUPs and Shots
class UFOWorld {
    UFO ufo;
    AUP aup;
    IShots shots;
    Color BACKG = Color.BLUE;
    int HEIGHT = 500;
    int WIDTH = 200;

    UFOWorld(UFO ufo, AUP aup, IShots shots) {
        this.ufo = ufo;
        this.aup = aup;
        this.shots = shots;
    }

    public void draw(Graphics g) {
        g.setColor(BACKG);
        g.fillRect(0,0,WIDTH,HEIGHT);
        ufo.draw(g);
        aup.draw(g);
        shots.draw(g);
    }

    public UFOWorld move () {
        return new UFOWorld (this.ufo.move(this), this.aup, this.shots.move());
    }

    public UFOWorld shoot () {
        return new UFOWorld (this.ufo, this.aup, new ConsShots(this.aup.fireShot(), this.shots));
    }
}