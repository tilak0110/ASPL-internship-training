package stream;

import java.util.stream.IntStream;
import java.util.Comparator;
import java.util.stream.Stream;

public class SecondLargest {
    public static void main(String[] args) {
        int secondLargest = IntStream.of(15, 30, 10, 50, 20, 50, 40)
                .boxed() // Convert IntStream to Stream<Integer>
                .sorted(Comparator.reverseOrder()) // Sort in descending order
                .distinct() // Remove duplicates
                .skip(1) // Skip the largest element (first element)
                .findFirst() // Get the next element (second largest)
                .get(); // Retrieve the value

        System.out.println(secondLargest);
    }
}
