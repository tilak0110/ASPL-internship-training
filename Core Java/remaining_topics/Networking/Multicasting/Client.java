package remaining_topics.Networking.Multicasting;

import java.io.IOException;
import java.net.*;

public class Client {
    private MulticastSocket socket;

    public Client(String ip, int port) throws IOException {
        socket = new MulticastSocket(port); // Must use MulticastSocket, not DatagramSocket
        socket.joinGroup(InetAddress.getByName(ip));
    }

    public void printMessage() throws IOException {
        byte[] message = new byte[256];
        DatagramPacket packet = new DatagramPacket(message, message.length);
        socket.receive(packet); // Blocking until message arrives
        System.out.println("Received: " + new String(packet.getData()).trim());
    }

    public void close() throws IOException {
        socket.leaveGroup(InetAddress.getByName("230.0.0.0")); // Example group
        socket.close();
    }

    public static void main(String[] args) {
        try {
            final String ip = args[0]; // e.g. "230.0.0.0"
            final int port = Integer.parseInt(args[1]); // e.g. 4446
            Client client = new Client(ip, port);
            client.printMessage();
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

