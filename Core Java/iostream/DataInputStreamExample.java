package iostream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamExample {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("data.dat"))) {
            System.out.println("Integer: " + dis.readInt());
            System.out.println("Double: " + dis.readDouble());
            System.out.println("Boolean: " + dis.readBoolean());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
