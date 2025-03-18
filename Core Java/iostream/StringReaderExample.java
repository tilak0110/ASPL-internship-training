package iostream;

import java.io.StringReader;
import java.io.IOException;

public class StringReaderExample {
    public static void main(String[] args) {
        String data = "Hello, StringReader!";
        try (StringReader sr = new StringReader(data)) {
            int character;
            while ((character = sr.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
