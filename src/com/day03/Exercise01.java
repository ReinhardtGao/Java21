package com.day03;

import java.util.StringTokenizer;

class Exercise01 {

    public static void main(String[] arguments) {
        StringTokenizer bd;

        String date = "12/23/1989";
        System.out.println("Date: " + date);

        bd = new StringTokenizer(date, "/");
        System.out.println("Month: " + bd.nextToken());
        System.out.println("Day: " + bd.nextToken());
        System.out.println("Year: " + bd.nextToken());
    }
}
