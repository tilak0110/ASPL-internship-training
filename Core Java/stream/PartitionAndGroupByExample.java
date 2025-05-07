package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionAndGroupByExample {
    public static void main(String[] args) {
        Map<String, List<Integer>> groupedNumbers = IntStream.rangeClosed(1, 10)
                .boxed() // Convert IntStream to Stream<Integer>
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));

        System.out.println(groupedNumbers);

        Map<Boolean, List<Integer>> partitionedNumbers = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partitionedNumbers);

    }
}
