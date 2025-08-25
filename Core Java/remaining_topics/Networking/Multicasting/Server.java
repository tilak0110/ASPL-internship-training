package remaining_topics.Networking.Multicasting;

import java.io.IOException;
import java.net.*;

public class Server {
    private DatagramSocket serverSocket;
    private String ip;
    private int port;

    public Server(String ip, int port) throws SocketException {
        this.ip = ip;
        this.port = port;
        serverSocket = new DatagramSocket(); // Used for sending
    }

    public void send() throws IOException {
        byte[] message = "Multicasting...".getBytes();
        DatagramPacket packet = new DatagramPacket(
                message, message.length,
                InetAddress.getByName(ip), port
        );

        serverSocket.send(packet);
        System.out.println("Message sent to group " + ip + ":" + port);
    }

    public void close() {
        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            final String ip = args[0]; // e.g. "230.0.0.0"
            final int port = Integer.parseInt(args[1]); // e.g. 4446
            Server server = new Server(ip, port);
            server.send();
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
