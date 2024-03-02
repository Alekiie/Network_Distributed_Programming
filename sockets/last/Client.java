package sockets.last;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int Port = 3000;
        try {
            Socket client = new Socket(InetAddress.getLocalHost(), Port);
            System.out.println("Connected to server");
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(),true);
          
                String question = "Are you okay?";
                output.println(question);

                // Answer
                String answer = input.readLine();
                System.out.println(answer);

                client.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
