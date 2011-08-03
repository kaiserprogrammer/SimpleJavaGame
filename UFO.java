import java.awt.*;
import javax.swing.*;

// a UFO, whose center is located at location
class UFO {
    Posn location;
    Color colorUFO = Color.GREEN;
    int RecWidth = 40;
    int RecHeight = 5;
    int demiter = 20;
    int Speed = 3;

    UFO (Posn location) {
        this.location = location;
    }

    public void draw (Graphics g) {
        g.setColor(colorUFO);
        g.fillRect(location.x, location.y, RecWidth, RecHeight);
        g.fillOval(location.x + (RecWidth - demiter) / 2, location.y + RecHeight / 2 - demiter / 2, demiter, demiter);
    }

    public UFO move (UFOWorld w) {
        if (this.landed(w)) {
            return this;
        } else if (this.closeToGround(w)) {
            return new UFO (new Posn (this.location.x, w.HEIGHT));
        } else {
            return new UFO (new Posn (this.location.x, this.location.y + this.Speed));
        }
    }

    public boolean landed (UFOWorld w) {
        return w.HEIGHT == location.y;
    }

    public boolean closeToGround (UFOWorld w) {
        return w.HEIGHT <= (location.y + Speed);
    }
}