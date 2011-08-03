import java.awt.*;

class MtShots implements IShots {
    public void draw (Graphics g) {
        // nothing to do here
    }

    public IShots move () {
        return new MtShots();
    }
}