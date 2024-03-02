package exam.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        int Server_Port = 8080;
        ServerSocket socket = null;
        try {
            System.out.println("Server running on port " + Server_Port);
            socket = new ServerSocket(Server_Port);
            while (true) {

                Socket server = socket.accept();
                System.out.println("Connected to client " + server.getLocalAddress());

                BufferedReader input = new BufferedReader(new InputStreamReader(server.getInputStream()));
                PrintWriter output = new PrintWriter(server.getOutputStream(), true);
                String question = input.readLine();
                if (question != null) {
                    String answer;
                    if(question.equals("what is the time?")){
                        Date date = new Date();
                        answer = date.toString();
                        output.println(answer);
                    }else{
                        answer ="I don't know";
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                // TODO: handle exception
                System.out.println("Error closing server." + e.getMessage());
            }
        }
    }
}
