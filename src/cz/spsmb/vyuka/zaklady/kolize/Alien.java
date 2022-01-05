package cz.spsmb.vyuka.zaklady.kolize;
import java.awt.*;
public class Alien extends Sprite {

    private final int INITIAL_X = 400;
    protected final int[] xsAlBorder = {0,4,7,10,10,8,3,0};
    protected final int[] ysAlBorder = {3,0,0,2,7,9,9,5};
    public Alien(int x, int y) {
        super(x, y);
        initAlien();
    }

    private void initAlien() {

        loadImage("src/resources/alien.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
    public Polygon getAlBorder() {
        Polygon p = new Polygon();
        for (int i = 0; i < this.xsAlBorder.length; i++) {
            p.addPoint(this.x+this.xsAlBorder[i], this.y+this.ysAlBorder[i]);
        }
        return p;
    }
}