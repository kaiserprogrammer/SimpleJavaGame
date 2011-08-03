import java.awt.*;

class ConsShots implements IShots {
    Shot first;
    IShots rest;

    ConsShots (Shot first, IShots rest) {
        this.first = first;
        this.rest = rest;
    }

    public void draw (Graphics g) {
        first.draw(g);
        rest.draw(g);
    }

    public IShots move () {
        return new ConsShots(this.first.move(), this.rest.move());
    }
}