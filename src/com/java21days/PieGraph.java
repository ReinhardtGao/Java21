/* Solution to Chapter 13, Exercise 2 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class PieGraph extends JFrame {
    public PieGraph() {
        super("PieGraph");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PieGraphPane pie = new PieGraphPane();
        add(pie);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        PieGraph frame = new PieGraph();
    }
}

class PieGraphPane extends JPanel {
    static int WIDTH = 120;
    static int HEIGHT = WIDTH;
    static int X = 400 - WIDTH / 2;
    static int Y = 300 - HEIGHT / 2;

    public void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        // draw background
        comp2D.setColor(Color.darkGray);
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D.Float background = new Rectangle2D.Float(
            0F, 0F, getSize().width, getSize().height);
        comp2D.fill(background);
        // draw pie chart
        comp2D.setColor(Color.red);
        Arc2D.Float redSlice = new Arc2D.Float(
            X, Y, WIDTH, HEIGHT, 90, -60, Arc2D.PIE);
        comp2D.fill(redSlice);
        comp2D.setColor(Color.green);
        Arc2D.Float greenSlice = new Arc2D.Float(
            X, Y, WIDTH, HEIGHT, 30, -80, Arc2D.PIE);
        comp2D.fill(greenSlice);
        comp2D.setColor(Color.blue);
        Arc2D.Float blueSlice = new Arc2D.Float(
            X, Y, WIDTH, HEIGHT, -50, -220, Arc2D.PIE);
        comp2D.fill(blueSlice);
    }
}
