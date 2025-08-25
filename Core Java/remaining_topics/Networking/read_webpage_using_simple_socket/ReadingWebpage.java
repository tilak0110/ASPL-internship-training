package remaining_topics.Networking.read_webpage_using_simple_socket;

import java.io.*;
import java.net.Socket;

public class ReadingWebpage {
    public static void main(String[] args) throws IOException {

        // Step 1: Connect to stackoverflow.com on HTTP port 80
        Socket socket = new Socket("stackoverflow.com", 80);

        // Step 2: Prepare input and output streams
        OutputStream outStream = socket.getOutputStream();
        InputStream inStream = socket.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(outStream));

        // Step 3: Send a simple HTTP GET request
        writer.print("GET / HTTP/1.1\r\n");
        writer.print("Host: stackoverflow.com\r\n");
        writer.print("\r\n"); // Blank line signals end of request headers
        writer.flush();

        // Step 4: Read and print the HTTP response
        System.out.println(readFully(reader));

        // Step 5: Close the socket
        socket.close();
    }

    // Reads everything from the socket until the end of stream
    private static String readFully(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int BUFFER_SIZE = 1024;
        char[] buffer = new char[BUFFER_SIZE];
        int charsRead;
        while ((charsRead = rd.read(buffer, 0, BUFFER_SIZE)) != -1) {
            sb.append(buffer, 0, charsRead);
        }
        return sb.toString();
    }
}

