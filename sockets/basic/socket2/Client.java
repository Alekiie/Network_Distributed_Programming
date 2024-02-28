package sockets.basic.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int port = 3000;
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userquiz = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please ask a question:");
            String quiz = userquiz.readLine();
            // Send question to the server
            out.println(quiz);

            // Read answer from the server
            String answer = in.readLine();
            System.out.println("The server says: " + answer);

            // Close Resources
            in.close();
            out.close();
            userquiz.close();
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
