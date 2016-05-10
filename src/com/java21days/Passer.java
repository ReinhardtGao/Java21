package com.java21days;

class Passer {

    void toUpperCase(String[] text) {
        for (int i = 0; i < text.length; i++) {
            text[i] = text[i].toUpperCase();
        }
    }

    public static void main(String[] arguments) {
        Passer passer = new Passer();
        passer.toUpperCase(arguments);
        for (String argument : arguments) {
            System.out.print(argument + " ");
        }
        System.out.println();
    }
}
