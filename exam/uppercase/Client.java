package exam.uppercase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int port = 3000;
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), port);
            System.out.println("Connected to server " + InetAddress.getLocalHost());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String quiz = "What is your name?";
            if (quiz != null) {
                output.println(quiz);

                // Read answer
                String answer = input.readLine();
                System.out.println(answer);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

}
