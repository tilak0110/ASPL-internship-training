package stream;

import java.util.stream.Stream;
import java.util.Random;

public class GenerateExample {
    public static void main(String[] args) {
        Stream.generate(() -> new Random().nextInt(100))
                .limit(5)
                .forEach(System.out::println);

        Stream.generate(() -> "Tilak") // Always generates "Tilak"
                .limit(5)
                .forEach(System.out::println);
    }
}
