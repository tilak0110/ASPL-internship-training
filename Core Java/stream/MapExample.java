package stream;

import java.util.Arrays;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.stream()
                .map(name -> name.toUpperCase()) // Convert each name to uppercase
                .forEach(System.out::println);
    }
}
