package cz.spsmb.vyuka.zaklady.animace;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SwingTimerEx extends JFrame {

    public SwingTimerEx() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingTimerEx ex = new SwingTimerEx();
                ex.setVisible(true);
            }
        });
        /*
        EventQueue.invokeLater(() -> {
            SwingTimerEx ex = new SwingTimerEx();
            ex.setVisible(true);
        });*/
    }
}
