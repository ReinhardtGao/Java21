/* Solution to Chapter 11, Exercise 1 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class CalMonth extends JFrame {
    public CalMonth() {
        super("CalMonth");
        // Setup title panel.
        Date today = new Date();
        String m = new SimpleDateFormat("MMMM").format(today);
        String y = new SimpleDateFormat("YYYY").format(today);
        TitlePane titlePane = new TitlePane(m + " " + y);
        // Setup calendar panel.
        CalPane calPane = new CalPane();
        // Configure frame.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(2, 1));
        // Display panels and frame.
        add(titlePane);
        add(calPane);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        CalMonth frame = new CalMonth();
    }
}

class TitlePane extends JPanel {
    public TitlePane(String title) {
        super();
        add(new JLabel(title));
    }
}

class CalPane extends JPanel {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int weekday = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    int totalDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int i = 0; // keeps track of local index for date cells
    int j = 0; // keeps track of global index in GridLayout instance

    public CalPane() {
        GridLayout lm = new GridLayout(7, 7);
        setLayout(lm);
        // Add weekday strings.
        DateFormatSymbols symbols = new DateFormatSymbols(new Locale("en"));
        String[] days = symbols.getShortWeekdays();
        for (i = 1; i < days.length; i++, j++) {
            add(new JLabel(days[i]));
        }
        System.out.println("weekday: " + weekday);
        System.out.println("total days: " + totalDays);

        // Fill beginning of month with empty cells until first day.
        for (i = 0; i < weekday; i++, j++) {
            add(new JLabel(""));
        }
        // Add date strings.
        for (i = 1; i <= totalDays; i++, j++) {
            add(new JLabel("" + i));
        }
        // Fill end of month with empty cells.
        System.out.println("" + j);
        while (j++ < lm.getColumns() * lm.getRows()) {
            add(new JLabel(""));
        }
    }
}
