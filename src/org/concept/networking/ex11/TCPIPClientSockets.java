package org.concept.networking.ex11;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class TCPIPClientSockets {
    /*
    TCP/IP Sockets:
    ===============
    Reliable, BiDirectional, Persistent, Point-To-Point,
    Stream-Based Connections Between Hosts on the Internet.
    */
    private static Logger LOG = Logger.getLogger(TCPIPClientSockets.class.getName());

    public static void main(String[] args) {
        executeClient();
    }

    public static void executeClient() {
        try {
            Socket socketClient = new Socket("localhost", 9999);
            InputStream streamIn = socketClient.getInputStream();
            OutputStream streamOut = socketClient.getOutputStream();
            // Send Request
            streamOut.write("Hi, Socket Server! Request".getBytes());
            // Get Response
            int data = -1;
            String response = "";
            while ((data = streamIn.read()) != -1) {
                response += data;
            }
            LOG.info(response);
            socketClient.close();
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
    }
}
