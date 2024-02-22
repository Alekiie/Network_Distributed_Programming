package sockets.socket1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket1 {
    public static void main(String[] args) {
        int SERVER_PORT = 5000;
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket socket = new Socket(address, SERVER_PORT);
            System.out.println("Successfully connected to the server.");
        } catch (UnknownHostException e) {
            // TODO: handle exception
            System.out.println("Host Unknown.");
        } catch (IOException e) {
            System.out.println("Cannot connect to the server.");
        }
    }
}
