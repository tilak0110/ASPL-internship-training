package remaining_topics.Networking.Client_server_communication_using_soket;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/* ServerSocket: Listens for incoming connections.
*  accept(): Blocks until a client connects, then returns a Socket instance for communication
*  Each accept() call only handles one client. To support multiple simultaneous clients, use threads

 */

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2000)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

