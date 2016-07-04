package com.java21days;

import java.sql.*;
import java.util.*;

public class DmozHandlerImpl implements  DmozHandler {

    @Override
    public HashMap getRandomSite() {
        HashMap<String, String> response = new HashMap<>();
        try (Connection conn = getMySqlConnection();
            Statement st = conn.createStatement();) {
            st.setMaxRows(1);
            ResultSet rec = st.executeQuery(
                "SELECT * FROM COOL.WEBSITES ORDER BY RANDOM()");
            if (rec.next()) {
                response.put("url", rec.getString("url"));
                response.put("title", rec.getString("title"));
                response.put("description",
                    rec.getString("description"));
            } else {
                response.put("error", "no database record found");
            }
            st.close();
            rec.close();
            conn.close();
        } catch (SQLException sqe) {
            response.put("error", sqe.getMessage());
        }
        return response;
    }

    private Connection getMySqlConnection() {
        Connection conn = null;
        String data = "jdbc:derby://localhost:1527/cool";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.apache.derby.djbc.ClientDriver");
            conn = DriverManager.getConnection(
                data, "cool", "mrfreeze");
        } catch (SQLException s) {
            System.out.println("SQL Error: " + s.toString() + " "
                + s.getErrorCode() + " " + s.getSQLState());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString()
                + e.getMessage());
        }
        return conn;
    }
}
