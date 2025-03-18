package iostream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        String data = "Hello, Character Streams!";
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(data); // Writing string data to the file
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
