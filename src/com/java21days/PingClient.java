package com.java21days;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;

public class PingClient {
    XmlRpcClient client;

    public PingClient() {
        this("http://localhost:7667/");
    }

    public PingClient(String serverUrl) {
        try {
            // Create the client.
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            URL server = new URL(serverUrl);
            config.setServerURL(server);
            client = new XmlRpcClient();
            client.setConfig(config);
        } catch (MalformedURLException mue) {
            System.out.println("Bad URL: " + serverUrl);
        }
    }

    public HashMap ping(String siteName, String siteUrl)
            throws IOException, XmlRpcException {
        // Create the parameters for the request.
        ArrayList<String> params = new ArrayList();
        params.add(siteName);
        params.add(siteUrl);
        Object result = client.execute(
            "weblogUpdates.ping", params);
        if (result instanceof XmlRpcException) {
        	throw (XmlRpcException) result;
        }
        return (HashMap) result;
    }

    public static void main(String[] arguments) {
        if (arguments.length < 2) {
            System.out.println("Usage: java PingClient sitename url");
            System.exit(-1);
        }
        try {
            PingClient pinger = new PingClient();
            HashMap response = pinger.ping(arguments[0], arguments[1]);
            System.out.println("message: " + response.get("message"));
            System.out.println("legal: " + response.get("legal"));
            System.out.println("flerror: " + response.get("flerror"));
        } catch (IOException | XmlRpcException exception) {
            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();
        }
    }
}
