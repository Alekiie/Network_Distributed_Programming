package sockets.socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static int SERVER_PORT = 5000;
    private int counter = 0;
    private Map<String, String> qaMap; // Map to store questions and answers

    public Server() {
        // Initialize the map with questions and answers
        qaMap = new HashMap<>();
        qaMap.put("what is the time?", new java.util.Date().toString());
        qaMap.put("who created you?", "Alexander is the owner.");
        qaMap.put("who is your best friend?", "Washington");
        qaMap.put("What is the capital of France?", "Paris");
        qaMap.put("How many continents are there?", "Seven");
        qaMap.put("Who wrote Romeo and Juliet?", "William Shakespeare");
        qaMap.put("What is the chemical symbol for water?", "H2O");
        qaMap.put("What is the largest planet in our solar system?", "Jupiter");
        qaMap.put("who painted the Mona Lisa?", "Leonardo da Vinci");
        qaMap.put("What is the currency of Japan?", "Japanese yen");
        qaMap.put("what is the tallest mountain in the world?", "Mount Everest");
        qaMap.put("Which animal is known as the 'king of the jungle'?", "Lion");
        qaMap.put("What is the square root of 64?", "8");
        qaMap.put("who invented the telephone?", "Alexander Graham Bell");
        qaMap.put("What is the tallest mammal?", "Giraffe");
        qaMap.put("What is the largest ocean on Earth?", "Pacific Ocean");
        qaMap.put("What is the freezing point of water in Celsius?", "0 degrees");
        qaMap.put("What is the chemical symbol for gold?", "Au");

        // Add more questions and answers as needed
    }

    // Helper method to run the server.
    private ServerSocket goOnline() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(SERVER_PORT);
            System.out.println("Server is now online using the port: " + SERVER_PORT);
        } catch (IOException e) {
            System.out.println("Error creating a server connection network: " + e.getMessage());
        }
        return server;
    }

    // Handle client requests
    private void handleRequests(ServerSocket server) {
        while (true) {
            try (Socket socket = server.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                // Read and process client request
                String request = in.readLine();
                System.out.println("Client: " + request);
                if (request != null) {
                    // request = request.toLowerCase();
                    String answer = qaMap.getOrDefault(request, "Unknown request: " + request);
                    out.println(answer);
                    counter++;
                }

            } catch (IOException e) {
                System.out.println("Server: Error communicating with the client: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
        ServerSocket ss = s.goOnline();
        if (ss != null) {
            s.handleRequests(ss);
        }
    }
}
