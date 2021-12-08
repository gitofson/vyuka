package cz.spsmb.vyuka.zaklady.basic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BoardImage extends JPanel implements ActionListener {

    private Image bardejov;
    private Timer timer;
    private int xLocation=0;
    private int yLocation=0;

    public BoardImage() {

        initBoard();
    }

    private void initBoard() {

        loadImage();

        int w = bardejov.getWidth(this);
        int h =  bardejov.getHeight(this);
        this.setPreferredSize(new Dimension(w, h));
        this.timer = new Timer(500, this);
        //this.timer.start();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/resources/fve.jpg");
        this.bardejov = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bardejov, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.xLocation++;
        this.yLocation++;
        System.out.println("Ahoj");
        this.setLocation(this.xLocation, this.yLocation);
    }
}
