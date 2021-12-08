package cz.spsmb.vyuka.zaklady.nase_animace;

import javax.swing.*;
import java.awt.*;

public class Animace extends JFrame {
    public Animace() throws HeadlessException {
        this.add(new Board());
        this.setTitle("Animacni okenko");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
