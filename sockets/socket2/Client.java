package sockets.socket2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        int SERVER_PORT = 8080;
        Socket client = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
            client = new Socket(address, SERVER_PORT);
            System.out.println("Successfully connected to server.");
        } catch (UnknownHostException e) {
            // TODO: handle exception
            System.out.println("The host is unknown.Please try again." + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error connecting to server." + e.getMessage());
        }
    }
}
