package com.java21days;

import java.io.*;
import nu.xom.*;

public class XmlCustomerReader {
    public static void main(String[] arguments) {
        try {
            Builder builder = new Builder();
            Document doc = builder.build(new File("customer-reporter.xml"));
            Element root = doc.getRootElement();
            Elements customers = root.getChildElements("customer");
            for (int i = 0; i < customers.size(); i++) {
                Element customer = customers.get(i);
                // Get query data.
                Element id = customer.getFirstChildElement("id");
                Element name = customer.getFirstChildElement("name");
                Element city = customer.getFirstChildElement("city");
                Element state = customer.getFirstChildElement("state");
                // Get each query element's text.
                Text idString = (Text) id.getChild(0);
                Text nameString = (Text) name.getChild(0);
                Text cityString = (Text) city.getChild(0);
                Text stateString = (Text) state.getChild(0);
                // Display query.
                System.out.println(
                    "CUSTOMER_ID: " + idString.getValue() + "\n" +
                    "NAME: " + nameString.getValue() + "\n" +
                    "CITY: " + cityString.getValue() + "\n" +
                    "STATE: " + stateString.getValue() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
