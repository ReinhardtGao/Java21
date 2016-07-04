package com.java21days;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;

public class SiteClient {
    public static void main(String arguments[]) {
        SiteClient client = new SiteClient();
        try {
            HashMap<String, String> resp = client.getRandomSite();
            // Report the results
            if (resp.size() > 0) {
                System.out.println("URL: " + resp.get("url")
                    + "\nTitle: " + resp.get("title")
                    + "\nDescription: " + resp.get("description"));
            }
        } catch (IOException ioe) {
            System.out.println("Exception: " + ioe.getMessage());
        } catch (XmlRpcException xre) {
            System.out.println("Exception: " + xre.getMessage());
        }
    }

    public HashMap getRandomSite()
        throws IOException, XmlRpcException {

            // Create the client
            XmlRpcClientConfigImpl config = new
                XmlRpcClientConfigImpl();
            URL server = new URL("http://localhost:4413/");
            config.setServerURL(server);
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);
            // Create the parameters for the request
            ArrayList params = new ArrayList();
            // Send the request and get the response
            HashMap result = (HashMap) client.execute(
                "dmoz.getRandomSite", params);
            return result;
    }
}
