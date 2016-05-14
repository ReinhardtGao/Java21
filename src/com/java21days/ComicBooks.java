package com.java21days;

import java.util.*;

public class ComicBooks {

    public ComicBooks() {
    }

    public static void main(String[] arguments) {
        // set up hash map
        HashMap<Conditions, Float> quality = new HashMap<>();
        quality.put(Conditions.PRISTINE_MINT, 5F);
        quality.put(Conditions.MINT, 3.00F);
        quality.put(Conditions.NEAR_MINT, 2.00F);
        quality.put(Conditions.VERY_FINE, 1.50F);
        quality.put(Conditions.FINE, 1.00F);
        quality.put(Conditions.GOOD, 0.50F);
        quality.put(Conditions.POOR, 0.25F);
        quality.put(Conditions.COVERLESS, 0.10F);
        // set up collection
        Comic[] comix = new Comic[5];
        comix[0] = new Comic("Amazing Spider-Man", "1A",
            Conditions.VERY_FINE, 12_000.00F);
        comix[1] = new Comic("Incredible Hulk", "181",
            Conditions.NEAR_MINT, 680.00F);
        comix[2] = new Comic("Cerebus", "1A",
            Conditions.GOOD, 190.00F);
        comix[3] = new Comic("Blue Moon", "142",
            Conditions.PRISTINE_MINT, 48_000.00F);
        comix[4] = new Comic("The Walking Dead", "5A",
            Conditions.COVERLESS, 1_000.00F);
        // set up prices
        for (int i = 0; i < comix.length; i++) {
            comix[i].setPrice(quality.get(comix[i].condition));
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
    Conditions condition;
    float basePrice;
    float price;

    Comic(String inTitle, String inIssueNumber,
        Conditions inCondition, float inBasePrice) {

        title = inTitle;
        issueNumber = inIssueNumber;
        condition = inCondition;
        basePrice = inBasePrice;
    }

    void setPrice(float factor) {
        price = basePrice * factor;
    }
}

enum Conditions {
    PRISTINE_MINT,
    MINT,
    NEAR_MINT,
    VERY_FINE,
    FINE,
    GOOD,
    POOR,
    COVERLESS
}
