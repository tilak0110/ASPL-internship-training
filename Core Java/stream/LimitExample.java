package stream;

import java.util.stream.IntStream;

public class LimitExample {
    public static void main(String[] args) {
        IntStream.range(1, 10) // Numbers 1 to 9
                .limit(5) // Take only first 5
                .forEach(System.out::println);
    }
}
