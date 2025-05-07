package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PeekExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .peek(n -> System.out.println("Original: " + n)) // Before processing
                .map(n -> n * 2)
                .peek(n -> System.out.println("Doubled: " + n)) // After processing
                .forEach(System.out::println);

        IntStream.rangeClosed(1, 10)
                .peek(n -> System.out.println("Original: " + n))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("After filter (Even only): " + n))
                .forEach(System.out::println);
    }
}

