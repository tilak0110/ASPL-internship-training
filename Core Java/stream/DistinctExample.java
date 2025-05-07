package stream;

import java.util.Arrays;
import java.util.List;

public class DistinctExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        numbers.stream()
                .distinct() // Removes duplicates
                .forEach(System.out::println);
    }
}
