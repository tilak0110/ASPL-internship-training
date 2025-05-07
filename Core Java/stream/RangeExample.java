package stream;

import java.util.stream.IntStream;

public class RangeExample {
    public static void main(String[] args) {
        IntStream.range(1, 5) // Generates 1, 2, 3, 4 (Excludes 5)
                .forEach(System.out::println);

        IntStream.rangeClosed(1, 5) // Generates 1, 2, 3, 4, 5 (Includes 5)
                .forEach(System.out::println);
    }
}
