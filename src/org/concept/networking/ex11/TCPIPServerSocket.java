package org.concept.networking.ex11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class TCPIPServerSocket {
    private static Logger LOG = Logger.getLogger(TCPIPServerSocket.class.getName());

    public static void main(String[] args) {
        executeServer();
    }

    public static void executeServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            DataInputStream streamIn = new DataInputStream(socket.getInputStream());
            String data = (String) streamIn.readUTF();
            LOG.info("Client Request : " + data);
            DataOutputStream streamOut = new DataOutputStream(socket.getOutputStream());
            data = "Server Response => " + data;
            streamOut.write(data.toUpperCase().getBytes());
            Thread.sleep(99999);
            serverSocket.close();
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
    }
}
