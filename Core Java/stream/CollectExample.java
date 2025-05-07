package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList()); // Collects into List

        System.out.println(filteredNames);


        List<Integer> numbers = IntStream.rangeClosed(1, 5)
                .map(n -> n * 2)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(numbers);




        Set<String> name1 = Stream.of("Alice", "Bob", "Alice", "Charlie", "Bob")
                .collect(Collectors.toSet()); // Removes duplicates

        System.out.println(name1);


        Map<String, Integer> nameLengths = Stream.of("Java", "Spring", "Streams", "API")
                .collect(Collectors.toMap(name -> name, name -> name.length())); // Map<Name, Length>

        System.out.println(nameLengths);


        Set<Integer> sortedNumbers = IntStream.of(5, 3, 8, 1, 5, 3, 8, 10)
                .boxed() // Convert int to Integer
                .collect(Collectors.toCollection(TreeSet::new)); // Collect as TreeSet

        System.out.println(sortedNumbers);


    }
}
