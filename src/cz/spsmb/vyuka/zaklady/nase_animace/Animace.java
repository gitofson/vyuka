package cz.spsmb.vyuka.zaklady.nase_animace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Animace extends JFrame implements KeyListener, ActionListener {
    private int dx, dy, x, y;
    private final int DELAY = 10;
    private Timer timer;

    public Animace() throws HeadlessException {
        this.addKeyListener(this);
        this.add(new Board());
        this.setTitle("Animacni okenko");
        this.setSize(400,300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer = new Timer(this.DELAY, this);
        timer.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Animace an=new Animace();
                an.setVisible(true);
            }
        });


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy =1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy =0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x += this.dx;
        this.y += this.dy;
        this.setLocation(1,500);
    }
}
