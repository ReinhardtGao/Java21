/* Solution to Chapter 10, Exercise 2 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.awt.*;
import javax.swing.*;

public class ProgressMonitor2 extends JFrame {

    JProgressBar current;
    JTextField field = new JTextField(4);
    JTextArea out;
    JButton find;
    int num = 0;

    public ProgressMonitor2() {
        super("Progress Monitor 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(480, 60);
        setLayout(new FlowLayout());
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        add(field);
        add(current);
    }

    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            field.setText(Integer.toString(num));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 95;
        }
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Couldn't use the system "
                + "look and feel: " + e);
        }
    }

    public static void main(String[] arguments) {
        ProgressMonitor2 frame = new ProgressMonitor2();
        frame.setVisible(true);
        frame.iterate();
   }
}
