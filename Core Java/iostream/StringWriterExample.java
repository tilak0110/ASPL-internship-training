package iostream;

import java.io.StringWriter;
import java.io.IOException;

public class StringWriterExample {
    public static void main(String[] args) {
        try (StringWriter sw = new StringWriter()) {
            sw.write("Hello, StringWriter!");
            System.out.println("Written Data: " + sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
