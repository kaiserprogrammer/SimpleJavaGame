import java.awt.*;
import javax.swing.*;

class Shot {
    Color shotColor = Color.YELLOW;
    Posn location;
    int ShotHeight = 5;
    int ShotWidth = 3;
    int Speed = 10;

    Shot (Posn location) {
        this.location = location;
    }

    public void draw (Graphics g) {
        g.setColor(shotColor);
        g.fillRect(location.x - ShotWidth / 2, location.y, ShotWidth, ShotHeight);
    }

    public Shot move () {
        return new Shot (new Posn (this.location.x, this.location.y - this.Speed));
    }
}