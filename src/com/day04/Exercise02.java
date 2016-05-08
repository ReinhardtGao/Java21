package com.day04;

class Exercise02 {
    public static void main(String[] arguments) {
        long ans;
        if (arguments.length == 1) {
            System.out.println(translateToInt(arguments[0]));
        }
    }

    static long translateToInt(String num) {
        long ans;
        switch (num) {
            case "one":
                ans = 1;
                break;
            case "two":
                ans = 2;
                break;
            case "three":
                ans = 3;
                break;
            case "four":
                ans = 4;
                break;
            case "five":
                ans = 5;
                break;
            case "six":
                ans = 6;
                break;
            case "seven":
                ans = 7;
                break;
            case "eight":
                ans = 8;
                break;
            case "nine":
                ans = 9;
                break;
            case "ten":
                ans = 10;
                break;
            default:
                ans = -1;
        }
        return ans;
    }
}
