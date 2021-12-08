package cz.spsmb.vyuka.zaklady.basic;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ImageExample extends JFrame implements ActionListener {
    private int vx=1;
    private int xLocation=0;
    private int yLocation=0;
    private Timer timer;
    private int time;
    public ImageExample() {

        initUI();
        this.timer = new Timer(1, this);
        this.timer.start();
    }

    private void initUI() {

        add(new BoardImage());

        pack();

        setTitle("FVE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ImageExample ex = new ImageExample();
            ex.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.time++;
        //double dy
        int dy = (int) Math.round(.5*this.time*this.time);
        if((this.xLocation += dy) > this.getToolkit().getScreenSize().width-this.getWidth()){
            this.xLocation = 0;
        }
        //this.yLocation++;
        this.setLocation(this.xLocation, this.yLocation);
    }
}
