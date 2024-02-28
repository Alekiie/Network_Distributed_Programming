package sockets.basic.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client started... ");
            Socket socket = new Socket("localhost", 8080);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            
            // Read user input
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Kindly ask a question...");
            String question = userInput.readLine();
            
            // Send the question to the server
            output.println(question);
            
            // Receive and print the answer from the server
            String answer = input.readLine();
            System.out.println("Server's answer: " + answer);
            
            // Close resources
            userInput.close();
            output.close();
            input.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
