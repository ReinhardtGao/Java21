package com.day02;

public class Exercise01 {
    public static void main(String[] arguments) {
        double balance = 14000;
        // First year: Increase value by 40%.
        balance *= 1.40;
        System.out.println("Balance (Year 1): " + balance);
        // Second year: Lose $1,500 in value.
        balance -= 1500.0;
        System.out.println("Balance (Year 2): " + balance);
        // Third year: Increase value by 12%.
        balance *= 1.12;
        System.out.println("Balance (Year 3): " + balance);
    }
}
