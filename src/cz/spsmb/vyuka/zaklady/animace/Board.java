package cz.spsmb.vyuka.zaklady.animace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel
        implements ActionListener {

    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 2;

    private Image star;
    private Timer timer;
    private int x, y;
    private int dx = 1, dy = 1;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/resources/star.png");
        star = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x += this.dx;
        this.y += this.dy;

        if (y+this.star.getHeight(null) > B_HEIGHT ) {
            this.dx = -2;
            this.dy = -2;

            //y = INITIAL_Y;
            //x = INITIAL_X;
        }
        if (this.y < 0 ) {
            this.dx = 2;
            this.dy = 2;

            //y = INITIAL_Y;
            //x = INITIAL_X;
        }


        repaint();
    }
}
