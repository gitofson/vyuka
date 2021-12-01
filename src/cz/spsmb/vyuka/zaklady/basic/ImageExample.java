package cz.spsmb.vyuka.zaklady.basic;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ImageExample extends JFrame implements ActionListener {

    private double vx = 4;
    private double G = 0.1;
    private double vy = 0;
    public BoardImage bm = new BoardImage();
    private int xLocation = 0;
    private int yLocation = 0;
    private Timer timer;

    public ImageExample() {

        initUI();
    }

    private void initUI() {

        add(bm);

        pack();

        setTitle("FVE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        timer = new Timer(10, this);
        timer.start();
    }

    public static void main(String[] args) {
        ImageExample ex = new ImageExample();

        EventQueue.invokeLater(() -> {
            ex.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.xLocation += vx;
        if (((this.xLocation) > this.getToolkit().getScreenSize().width-this.getWidth()) ||
                this.xLocation < 0) {
            vx *= -1;
        }
        this.yLocation += vy;
        vy += G;
        if (vy < 0) {
            vy += G;
        }
        if (((this.yLocation) > this.getToolkit().getScreenSize().height-this.getHeight()) ||
                this.yLocation < 0) {
            vy *= -1;
            vx += vx > 0 ? -0.5 : 0.5;
            System.out.println(vx);
        }
        this.setLocation(this.xLocation, this.yLocation);

    }
}
