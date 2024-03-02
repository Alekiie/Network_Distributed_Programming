package sockets.last;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int Port = 3000;
        try {
            ServerSocket s = new ServerSocket(Port);
            Socket socket = s.accept();
            System.out.println("Connected to client");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            String question = input.readLine();
            while (true) {
                String answer;
                if (question.equals("Are you okay?")) {
                    answer = "Yes,indeed i am.";
                } else {
                    answer = "I dont know";
                }
                output.println(answer);
                if (socket != null) {
                    socket.close();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

    }
}
