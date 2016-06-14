/* Solution to Chapter 15, Exercise 1 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.io.*;

class HexReader2 {

    public static void main(String[] arguments) {
        HexReader2 hex = new HexReader2();
        try (
            FileReader file = new
                FileReader("hexfile.txt");
            BufferedReader br = new
                BufferedReader(file);) {

            String line = null;
            while ((line = br.readLine()) != null) {
                hex.readLine(line);
            }
        } catch (IOException exc) {
                System.out.println("Error -- " + exc.toString());
        }
    }

    void readLine(String code) {
        try {
            for (int j = 0; j + 1 < code.length(); j += 2) {
                String sub = code.substring(j, j + 2);
                int num = Integer.parseInt(sub, 16);
                if (num == 255) {
                    return;
                }
                System.out.print(num + " ");
            }
        } finally {
            System.out.println("**");
        }
    }
}
