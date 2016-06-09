/* Solution to Chapter 13, Exercise 1 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Circle extends JFrame {
    public Circle(int x, int y, int radius, Color color) {
        super("Circle");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CirclePane circle = new CirclePane(x, y, radius, color);
        add(circle);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        int x, y, radius;
        int[] rgb = new int[3];
        Color color;

        if (arguments.length != 6) {
            System.out.println("Usage: java Circle x y radius r g b");
            System.exit(-1);
        }
        x = Integer.parseInt(arguments[0]);
        y = Integer.parseInt(arguments[1]);
        radius = Integer.parseInt(arguments[2]);
        rgb[0] = Integer.parseInt(arguments[3]);
        rgb[1] = Integer.parseInt(arguments[4]);
        rgb[2] = Integer.parseInt(arguments[5]);
        color = new Color(rgb[0], rgb[1], rgb[2]);
        Circle frame = new Circle(x, y, radius, color);
    }
}

class CirclePane extends JPanel {
    int x, y, radius;
    Color color;

    public CirclePane(int x, int y, int radius, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        // draw black background
        comp2D.setColor(Color.black);
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D.Float background = new Rectangle2D.Float(
            0F, 0F, getSize().width, getSize().height);
        comp2D.fill(background);
        // draw circle
        comp2D.setColor(this.color);
        Ellipse2D.Float circle = new Ellipse2D.Float(
            x, y, 2 * radius, 2 * radius);
        comp2D.fill(circle);
    }
}
