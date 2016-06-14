/* Solution to Chapter 15, Exercise 2 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.io.*;

public class FileWiper {
    static String fileName;
    static int count;

    public static void main(String[] arguments) {
        if (arguments.length != 1) {
            System.out.println("Usage: java FileWiper junkfile.dat");
            System.exit(-1);
        }
        fileName = arguments[0];
        count = 0;
        getByteCount();
        wipeFile();
    }

    public static void getByteCount() {
        try (FileInputStream file = new FileInputStream(fileName)) {

            boolean eof = false;
            while (!eof) {
                int input = file.read();
                if (input == -1)
                    eof = true;
                else
                    count++;
            }
            file.close();
           // System.out.println("Bytes: " + count);
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }

    public static void wipeFile() {
        try (FileOutputStream file = new
            FileOutputStream(fileName)) {

            while (count-- > 0) {
                file.write(0);
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}
