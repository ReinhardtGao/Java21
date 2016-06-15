package com.java21days;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProgressMonitor3 extends JFrame {
    JProgressBar current;
    int num = 0;
    boolean done = false;

    public ProgressMonitor3() {
        super("Progress Monitor 3");
        setLookAndFeel();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                // user has tried to close window
                if (done) {
                    // allow it
                    dispose();
                    System.exit(0);
                }
            }
        });
        setSize(400, 100);
        setLayout(new FlowLayout());
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        current.setPreferredSize(new Dimension(360, 48));
        add(current);
        setVisible(true);
        iterate();
    }

    public final void iterate() {
        while (num < 2000) {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 95;
        }
        done = true;
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
        new ProgressMonitor3();
   }
}