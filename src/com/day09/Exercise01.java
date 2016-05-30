package com.day09;

import javax.swing.*;

public class Exercise01 extends JFrame {
    public Exercise01() {
        super("DVR");
        setSize(400, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create buttons.
        JButton play = new JButton("Play");
        JButton stop = new JButton("Stop");
        JButton rewind = new JButton("Rewind");
        JButton ff = new JButton("Fast-Forward");
        JButton pause = new JButton("Pause");
        // Add buttons to panel.
        JPanel panel = new JPanel();
        panel.add(play);
        panel.add(stop);
        panel.add(rewind);
        panel.add(ff);
        panel.add(pause);
        // Add panel to frame.
        add(panel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] arguments) {
        Exercise01.setLookAndFeel();
        Exercise01 ans = new Exercise01();
    }
}
