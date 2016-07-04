package com.java21days;

import java.io.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.*;

public class PingServer {
    public static void main(String[] arguments) {
        try {
            startServer();
        } catch (IOException ioe) {
            System.out.println("Server error: " + ioe.getMessage());
        } catch (XmlRpcException xre) {
            System.out.println("XML-RPC error: " + xre.getMessage());
        }
    }

    public static void startServer()
        throws IOException, XmlRpcException {
            // Create the server.
            System.out.println("Starting weblogs server ...");
            WebServer server = new WebServer(7667);
            XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
            PropertyHandlerMapping phm = new PropertyHandlerMapping();

            // Register the handler.
            phm.addHandler("weblogUpdates", PingHandlerImpl.class);
            xmlRpcServer.setHandlerMapping(phm);

            // Start the server.
            server.start();
            System.out.println("Accepting requests ...");
        }
}
