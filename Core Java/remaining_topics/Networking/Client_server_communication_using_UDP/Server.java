package remaining_topics.Networking.Client_server_communication_using_UDP;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // Step 1: Bind server to port 4160
        DatagramSocket serverSocket = new DatagramSocket(4160);

        // Step 2: Prepare a buffer for incoming data
        byte[] rbuf = new byte[256];

        // Step 3: Create a packet to store incoming data
        DatagramPacket packet = new DatagramPacket(rbuf, rbuf.length);

        // Step 4: Wait for a packet (blocking call)
        serverSocket.receive(packet);

        // Step 5: Process and print the received message
        String response = new String(packet.getData()).trim();
        System.out.println("Response: " + response);

        // Step 6: Close the socket
        serverSocket.close();
    }
}

