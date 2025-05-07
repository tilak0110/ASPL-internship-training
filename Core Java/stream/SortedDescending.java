package stream;

import java.util.stream.IntStream;
import java.util.Comparator;

public class SortedDescending {
    public static void main(String[] args) {
        IntStream.of(30, 10, 50, 20, 40)
                .boxed() // Convert IntStream to Stream<Integer>
                .sorted(Comparator.reverseOrder()) // Sort in descending order
                .forEach(System.out::println);
    }
}

