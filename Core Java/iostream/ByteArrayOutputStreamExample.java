package iostream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamExample {
    public static void main(String[] args) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write("Hello, ByteArrayOutputStream!".getBytes());
            System.out.println("Written Data: " + baos.toString()); // Convert byte array to string
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
