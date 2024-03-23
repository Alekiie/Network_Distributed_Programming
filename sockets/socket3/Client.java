package sockets.socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private BufferedReader in;
    private PrintWriter out;

    private void connectToServer() {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), Server.SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Client: Cannot connect to the server. " + e.getMessage());
            System.exit(-1);
        }
    }

    // Ask questions
    private void askQuestion(String Question) {
        connectToServer();
        out.println(Question);
        out.flush();
        try {
            String quiz = in.readLine();
            System.out.println("Server: " + quiz);
        } catch (IOException e) {
            System.out.println("Cannot receive response from server.");
        }
    }

    private static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
        delay();
        c.askQuestion("Which animal is known as the 'king of the jungle'?");
    }
}
