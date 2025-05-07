package stream;

import java.util.Arrays;
import java.util.List;

public class SortedExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);

        numbers.stream()
                .sorted() // Sorts in ascending order
                .forEach(System.out::println);
    }
}
