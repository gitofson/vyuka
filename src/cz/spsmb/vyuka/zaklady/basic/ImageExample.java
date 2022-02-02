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
    private int time, dx=3, dy=2;
    public ImageExample() {

        initUI();
        this.timer = new Timer(2, this);
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
        /*this.time++;
        //double dy
        int dy = (int) Math.round(.5*this.time*this.time);
        if((this.xLocation += dy) > this.getToolkit().getScreenSize().width-this.getWidth()){
            this.xLocation = 0;
        }*/
        if(this.xLocation+this.getWidth() > this.getToolkit().getScreenSize().width ||
        this.xLocation < 0){
            this.dx *= -1;
        }
        if(this.yLocation+this.getHeight() > this.getToolkit().getScreenSize().height ||
                this.yLocation < 0){
            this.dy *= -1;
        }
        this.xLocation+=dx;
        this.yLocation+=dy;
        this.setLocation(this.xLocation, this.yLocation);
    }
}
