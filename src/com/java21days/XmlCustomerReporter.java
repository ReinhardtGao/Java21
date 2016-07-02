package com.java21days;

import java.io.*;
import java.sql.*;
import nu.xom.*;

public class XmlCustomerReporter {
    Element root;

    public XmlCustomerReporter() {
        root = new Element("root");
        String data = "jdbc:derby://localhost:1527/sample";
        try (
            Connection conn = DriverManager.getConnection(
                data, "app", "app");
            Statement st = conn.createStatement()) {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            ResultSet rec = st.executeQuery(
                "select CUSTOMER_ID, NAME, CITY, STATE " +
                "from APP.CUSTOMER ");
            writeResultSetToXml(rec);
        } catch (SQLException s) {
            System.out.println("SQL Error: " + s.toString() + " "
                + s.getErrorCode() + " " + s.getSQLState());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString()
                + e.getMessage());
        }
    }

    public void writeResultSetToXml(ResultSet rec) {
        try (
            FileOutputStream fos = new FileOutputStream("customer-reporter.xml");
        ) {
            Serializer output = new Serializer(fos, "UTF-8");
            output.setIndent(2);
            while (rec.next()) {
                // Store SQL query in a customer element.
                Element customer = createCustomerElement(rec);
                root.appendChild(customer);
            }
            Document doc = new Document(root);
            output.write(doc);
            System.out.println(doc.toXML());
        } catch (IOException ioe) {
            System.out.println("IO Error: " + ioe.getMessage());
        } catch (SQLException se) {
            System.out.println("SQL Error: " + se.getMessage());
        }
    }

    public Element createCustomerElement(ResultSet rec) {
        Element customer = new Element("customer");
        String idString, nameString, cityString, stateString;
        try {
            idString = rec.getString(1);
            nameString = rec.getString(2);
            cityString = rec.getString(3);
            stateString = rec.getString(4);
        } catch (SQLException se) {
            // If query fails, set all strings to empty.
            System.out.println("SQL Error: " + se.getMessage());
            idString = "";
            nameString = "";
            cityString = "";
            stateString = "";
        }
        // Add id element.
        Element id = new Element("id");
        id.appendChild(idString);
        customer.appendChild(id);
        // Add name element.
        Element name = new Element("name");
        name.appendChild(nameString);
        customer.appendChild(name);
        // Add city element.
        Element city = new Element("city");
        city.appendChild(cityString);
        customer.appendChild(city);
        // Add state element.
        Element state = new Element("state");
        state.appendChild(stateString);
        customer.appendChild(state);
        return customer;
    }

    public static void main(String[] arguments) {
        new XmlCustomerReporter();
    }
}
