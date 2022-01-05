package cz.spsmb.vyuka.zaklady.nase_animace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Animace extends JFrame implements KeyListener, ActionListener {
    private final int DELAY = 10;
    private int dx, dy, x, y;
    private Timer timer;

    public Animace() throws HeadlessException {

        this.add(new Board());
        this.setTitle("Animacni okenko");
        this.setSize(400,300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer = new Timer(this.DELAY, this);
        timer.start();
        //this.addKeyListener(this);
        //this.setFocusable(true);
        //this.setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Animace an = new Animace();
                    an.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = -1;
        }

        if (key == KeyEvent.VK_D) {
            dx = 1;
        }

        if (key == KeyEvent.VK_W) {
            dy = -1;
        }

        if (key == KeyEvent.VK_S) {
            dy =1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy =0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x += this.dx;
        this.y += this.dy;
        this.setLocation(this.x, this.y);
    }
}