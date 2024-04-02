import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        if (args.length < 1) {
            System.out.println("Usage: Java UDPServer<Port Number>");
            System.exit(1);
        }
        try {
            int socket_no = Integer.valueOf(args[0]).intValue();
            socket = new DatagramSocket(socket_no);
            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer,
                        buffer.length);
                socket.receive(request);
                DatagramPacket reply = new DatagramPacket(request.getData(),
                        request.getLength(), request.getAddress(),
                        request.getPort());
                socket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {

            if (socket != null)
                socket.close();
        }
    }
}
