package iostream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.txt")) {
            int byteData;
            while ((byteData = fis.read()) != -1) { // Read until end of file
                System.out.print((char) byteData); // Convert byte to character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
