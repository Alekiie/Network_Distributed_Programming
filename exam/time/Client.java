package exam.time;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int Port = 8080;
        try {
            System.out.println("Establishing connection to server");
            Socket socket = new Socket(InetAddress.getLocalHost(), Port);
            System.out.println("Connection established to server" + InetAddress.getLocalHost());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String question = "what is the time?";
                output.println(question);
                String answer = input.readLine();
                System.out.println(answer);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
