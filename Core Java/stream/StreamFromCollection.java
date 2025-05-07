package stream;

import java.util.Arrays;
import java.util.List;

public class StreamFromCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Creating stream from a list
        names.stream().forEach(System.out::println);
    }
}
