import java.awt.*;
import javax.swing.*;

// an AUP: a rectangle, whose upper left corner
// is located at (location, bottom of the world)
class AUP {
    int location;
    int Height = 20;
    int Width = 40;
    int GunHeight = 10;
    int GunWidth = 5;

    // UFOWorld Height
    int Bottom = 500;
    Color aupColor = Color.RED;
    
    AUP(int location) {
        this.location = location;
    }

    public void draw (Graphics g) {
        g.setColor(aupColor);
        g.fillRect(location, Bottom - Height, Width, Height);
        g.fillRect(location + Width / 2 - GunWidth / 2, Bottom - Height - GunHeight, GunWidth, GunHeight);
    }

    public Shot fireShot () {
        return new Shot (new Posn (this.location + Width / 2 - GunWidth / 2, Bottom - Height));
    }
}