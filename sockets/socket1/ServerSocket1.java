package sockets.socket1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket1 {
    public static void main(String[] args) {
        int SERVER_PORT = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(SERVER_PORT);
            System.out.println("Server running on port: " + SERVER_PORT);
            while(true){
                Socket clienSocket =server.accept();
                System.out.println("Client connected"+clienSocket.getInetAddress());
            }
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Error starting the server. "+e.getMessage());
        }finally{
            try {
                if(server !=null){
                    server.close();
                }
            } catch (IOException e) {
                // TODO: handle exception
                System.out.println("Error closing the server. "+e.getMessage());
            }
        }
    }
}
