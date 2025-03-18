package iostream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamExample {
    public static void main(String[] args) {
        byte[] data = "Hello, ByteArrayInputStream!".getBytes();
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data)) {
            int byteData;
            while ((byteData = bais.read()) != -1) {
                System.out.print((char) byteData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
