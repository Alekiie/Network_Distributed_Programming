package exam.uppercase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int Port = 3000;
        ServerSocket server = null;
        try {
            server = new ServerSocket(Port);
            System.out.println("Server running on port " + Port);
            Socket socket = server.accept();
            System.out.println("Server connected to client " + socket.getLocalPort());

            while (true) {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                String question = input.readLine();
                while (question != null) {
                    String answer = question.toUpperCase();
                    output.println(answer);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }
    }
}
