/* Solution to Chapter 12, Exercise 2 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator2 extends JFrame implements FocusListener {
    JTextField value1, value2;
    JLabel equals, sum;
    JButton plus, minus;
    JPanel buttons;
    int sign = 1; // used when FocusListener methods update sum

    public Calculator2() {
        super("Add Two Numbers");
        setSize(350, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);
        // create components
        value1 = new JTextField("0", 5);
        plus = new JButton("+");
        minus = new JButton("-");
        buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        value2 = new JTextField("0", 5);
        equals = new JLabel("=");
        sum = new JLabel("0");
        // add listeners
        value1.addFocusListener(this);
        value2.addFocusListener(this);
        plus.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               sign = 1;
               value1.requestFocus();
           }
        });
        minus.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               sign = -1;
               value1.requestFocus();
           }
        });
        // add components
        add(value1);
        buttons.add(plus);
        buttons.add(minus);
        add(buttons);
        add(value2);
        add(equals);
        add(sum);
        setVisible(true);
    }

    public void focusGained(FocusEvent event) {
        try {
            float total = Float.parseFloat(value1.getText()) +
                sign * Float.parseFloat(value2.getText());
            sum.setText("" + total);
        } catch (NumberFormatException nfe) {
            value1.setText("0");
            value2.setText("0");
            sum.setText("0");
        }
    }

    public void focusLost(FocusEvent event) {
        focusGained(event);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception exc) {
            System.err.println("Couldn't use the system "
                + "look and feel: " + exc);
        }
    }

    public static void main(String[] arguments) {
        Calculator2 frame = new Calculator2();
    }
}
