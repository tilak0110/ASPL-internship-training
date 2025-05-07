package stream;

import java.util.List;
import java.util.stream.Stream;

public class WithoutFlatMap {
    public static void main(String[] args) {
        List<String> list1 = List.of("A", "B", "C");
        List<String> list2 = List.of("D", "E", "F");

        Stream.of(list1, list2) // Creates a Stream<List<String>>
                .forEach(System.out::println); // Prints as two separate lists
    }
}

