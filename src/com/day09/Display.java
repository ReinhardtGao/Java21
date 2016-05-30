package com.day09;

import javax.swing.*;

public class Display extends JFrame {
    public Display() {
        super("Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel hello = new JLabel("Hello");
        JPanel pane = new JPanel();
        add(hello);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        Display ds = new Display();
    }
}
