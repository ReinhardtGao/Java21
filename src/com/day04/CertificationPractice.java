package com.day04;

class CertificationPractice {
    public static void main(String[] arguments) {
        float x = 9;
        float y = 5;
        int z = (int) (x / y);
        switch (z) {
            case 1:
                x = x + 2;
            case 2:
                x = x + 3;
            default:
                x = x + 1;
        }
        System.out.println("Value of x: " + x);
    }
}
