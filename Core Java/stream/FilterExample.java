package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FilterExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        names.stream()
                .filter(name -> name.startsWith("C")) // Keep names starting with 'C'
                .forEach(System.out::println);

        IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0) // Keeps only even numbers
                .forEach(System.out::println);
    }

}
