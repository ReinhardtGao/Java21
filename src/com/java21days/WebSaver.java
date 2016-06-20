package com.java21days;

import java.net.*;
import java.io.*;
import java.nio.file.*;

public class WebSaver {
    public WebSaver() {
        try {
            // Create input stream
            FileReader fr = new FileReader("ws" +
                File.separator + "fav.txt");
            BufferedReader in = new BufferedReader(fr);
            String line = null;
            while ((line = in.readLine()) != null ) {
                saveWebPage(line);
            }
        } catch (IOException exc) {
            System.out.println("Error: " + exc.toString());
        }
    }

    void saveWebPage(String address) {
        try {
            System.out.print(address + " g... ");
            URL page = new URL(address);
            HttpURLConnection conn = (HttpURLConnection)
                page.openConnection();
            conn.connect();
            // Create web page stream
            InputStreamReader isr = new InputStreamReader(
                (InputStream) conn.getContent());
            BufferedReader in = new BufferedReader(isr);
            // Create file output stream
            FileWriter fw = new FileWriter("ws" +
                File.separator + page.getHost() + ".html");
            BufferedWriter out = new BufferedWriter(fw);
            // Write web page to output file
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }
            System.out.println("done.");
        } catch (IOException ioe) {
            System.out.println("IO Error:" + ioe.getMessage());
        }
    }

    public static void main(String[] arguments) {
        new WebSaver();
    }
}
