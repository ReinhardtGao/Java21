package com.day07;

public class NegativeNumberException extends Exception {
    public NegativeNumberException() {};

    public NegativeNumberException(String message) {
        super(message);
    }
}