/* Solution to Chapter 11, Exercise 2 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.awt.*;
import javax.swing.*;

public class TwoLayouts extends JFrame {
    public TwoLayouts() {
        super();
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create direction buttons.
        JButton nButton = new JButton("north");
        JButton eButton = new JButton("east");
        JButton sButton = new JButton("south");
        JButton wButton = new JButton("west");
        CenterPane cPane = new CenterPane();
        // Add components to frame.
        add(nButton, BorderLayout.NORTH);
        add(eButton, BorderLayout.EAST);
        add(sButton, BorderLayout.SOUTH);
        add(wButton, BorderLayout.WEST);
        add(cPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        TwoLayouts frame = new TwoLayouts();
    }
}

class CenterPane extends JPanel {
    public CenterPane() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        String[] words = { "the", "day", "the", "earth", "stood", "still" };
        for (String word : words) {
            add(new JLabel(word));
        }
    }
}
