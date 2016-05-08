package com.day04;

import com.java21days.DayCounter;

class Exercise01 {
    public static void main(String[] arguments) {
        final int YEAR = 2016;
        final int[] MONTHS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        final int[] days = new int[MONTHS.length];
        int i, j;

        for (i = 0; i < MONTHS.length; i++) {
            days[i] = DayCounter.countDays(MONTHS[i], YEAR);
        }

        for (i = 0; i < MONTHS.length; i++) {
            for (j = 1; j <= days[i]; j++) {
                System.out.println(MONTHS[i] + "/" + j + "/" + YEAR);
            }
        }
    }
}
