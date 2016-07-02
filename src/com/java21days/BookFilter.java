package com.java21days;

import java.io.*;
import nu.xom.*;

public class BookFilter {
    public BookFilter() {
        try {
            Builder builder = new Builder();
            File bookFile = new File("books.xml");
            Document doc = builder.build(bookFile);

            Element root = doc.getRootElement();
            Elements books = root.getChildElements("book");
            for (int i = 0; i < books.size(); i++) {
                Element book = books.get(i);
                displayBookInfo(book);
            }
        } catch (IOException ioe) {
            System.out.println("IO Error: " + ioe.getMessage());
            System.exit(-1);
        } catch (ParsingException pe) {
            System.out.println("Parse Error: " + pe.getMessage());
            System.exit(-1);
        }
    }

    public void displayBookInfo(Element book) {
        // Get each Element in book.
        Element title = book.getFirstChildElement("title");
        Element author = book.getFirstChildElement("author");
        Element year = book.getFirstChildElement("year");
        // Get each Element's Text.
        Text titleText = (Text) title.getChild(0);
        Text authorText = (Text) author.getChild(0);
        Text yearText = (Text) year.getChild(0);

        if (authorText.getValue().equals("George R. R. Martin")) {
            System.out.println(
                "Title: " + titleText.getValue() + "\n" +
                "Author: " + authorText.getValue() + "\n" +
                "Year: " + yearText.getValue() + "\n");
        }
    }

    public static void main(String[] arguments) {
        new BookFilter();
    }
}
