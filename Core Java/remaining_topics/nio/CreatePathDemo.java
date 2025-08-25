package remaining_topics.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatePathDemo {
    public static void main(String[] args) {
        Path path1 = Paths.get("C:\\Users\\tilak\\Documents\\file.txt");
        Path path2 = Paths.get("students", "tilak.txt");

        System.out.println("Absolute Path 1: " + path1);
        System.out.println("Relative Path 2: " + path2);
    }
}
