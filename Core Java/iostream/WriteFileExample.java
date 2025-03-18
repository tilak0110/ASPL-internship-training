package iostream;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileExample {
    public static void main(String[] args) {
        String data = "Hello, Java I/O!";
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            fos.write(data.getBytes()); // Convert string to bytes
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
