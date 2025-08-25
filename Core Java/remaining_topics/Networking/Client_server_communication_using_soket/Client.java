package remaining_topics.Networking.Client_server_communication_using_soket;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 2000)) {
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            writer.println("Hello world!");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
* Server Flow
    Start server (ServerSocket)
    Wait for clients
    For each client:
        Create a thread
        Read messages
        Cleanup after client disconnects(.flush())
* */