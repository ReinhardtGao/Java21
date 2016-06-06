/* Solution to Chapter 10, Exercise 2 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import javax.swing.*;

public class TitleFrame extends JFrame {

    public TitleFrame() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        String title = JOptionPane.showInputDialog("Type title for main frame:");
        setTitle(title);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        TitleFrame frame = new TitleFrame();
    }
}
