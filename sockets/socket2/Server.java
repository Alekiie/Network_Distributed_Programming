package sockets.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int SERVER_PORT = 8080;
        ServerSocket server = null;

        try {
            server = new ServerSocket(SERVER_PORT);
            System.out.println("Server running on port: " + SERVER_PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected successfully." + client.getInetAddress());
                // Add an answer to a question
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out =new PrintWriter(client.getOutputStream(),true);
                String question =in.readLine();
                if(question!=null){
                    String answer;
                    if(question.equals("Good morning?")){
                        answer = "Good morning dev?";
                    }else{
                        answer = "No answer defined";
                    }
                    out.println(answer);
                }
            }

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Cannot run server" + e.getMessage());
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                // TODO: handle exception
                System.out.println("Error closing server." + e.getMessage());
            }
        }
    }
}
