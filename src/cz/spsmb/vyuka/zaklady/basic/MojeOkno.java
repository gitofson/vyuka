package cz.spsmb.vyuka.zaklady.basic;

import javax.swing.*;
import java.awt.*;

public class MojeOkno extends JFrame {
    private int pocet;

    public MojeOkno(String title, int pocet) throws HeadlessException {
        super(title);
        this.pocet = pocet;
    }

    public static void main(String[] args) {
        MojeOkno mo = new MojeOkno("Tohle je moje okno", 34);
        mo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mo.setSize(500,100);
        mo.setResizable(false);
        mo.setVisible(true);
    }
}
