package remaining_topics.Networking.Client_server_communication_using_UDP;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // Step 1: Create a DatagramSocket (no need to bind to a port for sending)
        DatagramSocket clientSocket = new DatagramSocket();

        // Step 2: Get the server's IP address from arguments
        InetAddress address = InetAddress.getByName(args[0]);

        // Step 3: Prepare the message
        String message = "Hello, World!";
        byte[] buf = message.getBytes();

        // Step 4: Create a packet addressed to server's port 4160
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4160);

        // Step 5: Send the packet
        clientSocket.send(packet);

        // Step 6: Close the socket
        clientSocket.close();
    }
}

