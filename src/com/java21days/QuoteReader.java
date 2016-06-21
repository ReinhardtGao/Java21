package com.java21days;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class QuoteReader {
    public QuoteReader() {
        try (
            FileInputStream fis = new FileInputStream("stocks.txt");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(fis));) {

            String line;
            while ((line = br.readLine()) != null) {
                QuoteData qd = new QuoteData(line);
                String data = qd.retrieveQuote();
                System.out.println(data);
            }
        } catch (IOException ioe) {
            System.out.println("IO Error: " + ioe.getMessage());
        }
    }

    public static void main(String[] arguments) {
        new QuoteReader();
    }
}
