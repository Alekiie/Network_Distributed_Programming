package sockets.basic.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        int port = 3000;
        try {
            System.out.println("Establishing connection...");
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            System.out.println("Client connected successfully.");
            BufferedReader input =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String question = input.readLine();
            String answer = getAnswer(question);
            PrintWriter out =new PrintWriter(socket.getOutputStream(),true);
            out.println(answer);



            // close
            out.close();
            input.close();
            socket.close();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    public static String getAnswer(String question){
        if (question.equals("what is the time?")) {
            Date date =new Date();
            SimpleDateFormat dateFormat =new SimpleDateFormat("HH:mm:ss");
            String formattedDate =dateFormat.format(date);
            return  "The time is: "+formattedDate;
        }else if(question.equals("who are you?")){
            return "I am Alexander";
        }
        else{
            return "No possible answer please";
        }

    }
}
