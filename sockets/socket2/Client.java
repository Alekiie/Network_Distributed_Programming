package sockets.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out =new PrintWriter(client.getOutputStream(),true);
            while(true){
                String ask = "Good morning?";
                out.println(ask);
                // Receive answer
                String answer = in.readLine();
                System.out.println(answer);
            }

            

        } catch (UnknownHostException e) {
            // TODO: handle exception
            System.out.println("The host is unknown.Please try again." + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error connecting to server." + e.getMessage());
        }
    }
}
