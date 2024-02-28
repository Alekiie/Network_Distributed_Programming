package sockets.basic.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int SERVER_PORT = 8080;

        try {
            System.out.println("Waiting for client. Please Wait....");
            ServerSocket server = new ServerSocket(SERVER_PORT);
            Socket socket = server.accept();
            System.out.println("Client connected successfully.");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String question = input.readLine();
            String answer = getAnswer(question);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(answer);
            // Close resources
            out.close();
            input.close();
            socket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getAnswer(String question) {
        if ("what is your name?".equals(question)) {
            return "Alexander Maina";
        } else {
            return "I don't know";
        }
    }
}
