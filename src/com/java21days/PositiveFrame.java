/* Solution to Chapter 12, Exercise 1 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PositiveFrame extends JFrame {
    JTextField number;
    JTextField empty; // used to test focus listener
    JButton ok;

    public PositiveFrame() {
        super("PositiveFrame");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        number = new JTextField("0", 8);
        empty = new JTextField("", 5);
        ok = new JButton("Ok");
        FocusAdapter focus = new FocusAdapter() {
            public void focusGained(FocusEvent event) {
                try {
                    Float n = Float.parseFloat(number.getText());
                    if (n < 0) {
                        number.setText("" + n * -1);
                    }
                } catch (NumberFormatException nfe) {
                    number.setText("0");
                }
                repaint();
            }
        };
        number.addFocusListener(focus);
        empty.addFocusListener(focus);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                number.requestFocus();
            }
        });
        add(number);
        add(empty);
        add(ok);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        PositiveFrame frame = new PositiveFrame();
    }
}
