package com.day09;

import javax.swing.*;

public class Exercise02 extends JFrame {
    InnerFrame frame = new InnerFrame();

    public Exercise02() {
        super("Main frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        Exercise02 ans = new Exercise02();
    }
}

class InnerFrame extends JFrame {
    public InnerFrame() {
        super("Exercise 2");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField username = new JTextField(15);
        JPasswordField password = new JPasswordField(15);
        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");
        // Add buttons to panel.
        JPanel panel = new JPanel();
        panel.add(usernameLabel);
        panel.add(username);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(ok);
        panel.add(cancel);
        add(panel);
        pack();
        setVisible(true);
    }
}
