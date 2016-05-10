package com.java21days;

class Averager {
    public static void main(String[] arguments) {
        int sum = 0;

        if (arguments.length > 0) {
            for (String argument : arguments) {
                sum += Integer.parseInt(argument);
            }
            System.out.println("Sum is: " + sum);
            System.out.println("Average is: " +
                (float) sum / arguments.length);
        }
    }
}
