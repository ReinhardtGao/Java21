package com.java21days;

import java.sql.*;

public class CustomerReporter2 {
    public static void main(String[] arguments) {
       String data = "jdbc:derby://localhost:1527/sample";
       try (
           Connection conn = DriverManager.getConnection(
               data, "app", "app");
           Statement st = conn.createStatement()) {

           Class.forName("org.apache.derby.jdbc.ClientDriver");

            ResultSet rec = st.executeQuery(
                "select PRODUCT_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, " +
                "MARKUP, AVAILABLE " +
                "from APP.PRODUCT " +
                "order by PRODUCT_ID");
            while (rec.next()) {
                System.out.println("PRODUCT_ID:\t"
                    + rec.getString(1));
                System.out.println("PRODUCT_CODE:\t" + rec.getString(2));
                System.out.println("PURCHASE_COST:\t" + rec.getString(3));
                System.out.println("QUANTITY_ON_HAND:\t" + rec.getString(4));
                System.out.println("MARKUP:\t" + rec.getString(5));
                System.out.println("AVAILABLE:\t" + rec.getString(6));
                System.out.println();
            }
            st.close();
        } catch (SQLException s) {
            System.out.println("SQL Error: " + s.toString() + " "
                + s.getErrorCode() + " " + s.getSQLState());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString()
                + e.getMessage());
        }
    }
}
