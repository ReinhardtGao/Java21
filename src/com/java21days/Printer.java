package com.java21days;

class Printer {
    int x = 0;
    int y = 1;

    void printMe() {
        System.out.println("x is " + x + ", y is " + y);
        System.out.println("I am an instance of the class " +
            this.getClass().getName());
    }
}

class SubPrinter extends Printer {
    int z = 3;

    @Override
    void printMe() {
        System.out.println("x is " + x + ", y is " + y + ", z is " + z);
        System.out.println("I am an instance of the class " +
            this.getClass().getName());
    }

    public static void main(String[] arguments) {
        SubPrinter obj = new SubPrinter();
        obj.printMe();
    }
}
