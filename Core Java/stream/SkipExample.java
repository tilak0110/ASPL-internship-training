package stream;

import java.util.stream.IntStream;

public class SkipExample {
    public static void main(String[] args) {
        IntStream.range(1, 10) // Numbers 1 to 9
                .skip(5) // Skip first 5
                .forEach(System.out::println);
    }
}
