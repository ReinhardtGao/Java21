package com.java21days;

import java.util.*;

public class ComicBooks {

    public ComicBooks() {
    }

    public static void main(String[] arguments) {
        // set up hash map
        HashMap quality = new HashMap();
        quality.put("pristine mint", 5F);
        quality.put("mint", 3.00F);
        quality.put("near mint", 2.00F);
        quality.put("very fine", 1.50F);
        quality.put("fine", 1.00F);
        quality.put("good", 0.50F);
        quality.put("poor", 0.25F);
        quality.put("coverless", 0.10F);
        // set up collection
        Comic[] comix = new Comic[5];
        comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00F);
        comix[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00F);
        comix[2] = new Comic("Cerebus", "1A", "good", 190.00F);
        comix[3] = new Comic("Blue Moon", "142", "pristine mint", 48_000.00F);
        comix[4] = new Comic("The Walking Dead", "5A", "coverless", 1_000.00F);
        // set up prices
        for (int i = 0; i < comix.length; i++) {
            comix[i].setPrice( (Float) quality.get(comix[i].condition) );
        }
        // display collection
        for (int i = 0; i < comix.length; i++) {
            System.out.println("Title: " + comix[i].title);
            System.out.println("Issue: " + comix[i].issueNumber);
            System.out.println("Condition: " + comix[i].condition);
            System.out.println("Price: $" + comix[i].price + "\n");
        }
    }
}

class Comic {
    String title;
    String issueNumber;
    String condition;
    float basePrice;
    float price;

    Comic(String inTitle, String inIssueNumber,
        String inCondition, float inBasePrice) {

        title = inTitle;
        issueNumber = inIssueNumber;
        condition = inCondition;
        basePrice = inBasePrice;
    }

    void setPrice(float factor) {
        price = basePrice * factor;
    }
}
