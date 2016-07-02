package com.java21days;

import java.io.*;
import nu.xom.*;

public class DomainWriter {
    public static void main(String[] args) throws IOException {
        try {
            if (args.length < 1) {
                System.out.println("Usage: java DomainWriter.java file.rss");
                System.exit(1);
            }
            // Create a tree from an XML document
            // specified as a command-line argument
            Builder builder = new Builder();
            File xmlFile = new File(args[0]);
            Document doc = builder.build(xmlFile);

            // Create a comment with the current time and date
            Comment timestamp = new Comment("File created "
                + new java.util.Date());

            // Add the comment above everything else in the
            // document
            doc.insertChild(timestamp, 0);

            // Create a file output stream to a new file
            FileOutputStream f = new FileOutputStream("feed3.rss");

            // Using a serializer with indention set to 2 spaces,
            // write the XML document to the file
            Serializer output = new Serializer(f, "ISO-8859-1");
            output.setIndent(2);
            output.write(doc);
        } catch (ParsingException pe) {
            System.out.println("Parsing error: " + pe.getMessage());
            pe.printStackTrace();
            System.exit(-1);
        }
    }
}
