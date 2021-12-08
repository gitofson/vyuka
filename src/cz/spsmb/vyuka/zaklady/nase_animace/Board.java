package cz.spsmb.vyuka.zaklady.nase_animace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private SpaceShip spaceShip;
    private final int DELAY = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(spaceShip.getImage(), spaceShip.getX(),
                spaceShip.getY(), this);
    }

    public Board() {
        this.spaceShip = new SpaceShip();
        this.addKeyListener(this.spaceShip);
        this.timer = timer;
        this.setBackground(Color.black);
        this.setFocusable(true);
        timer = new Timer(this.DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        spaceShip.move();
        repaint();
    }
}
