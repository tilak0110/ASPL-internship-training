package stream.questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class StreamProblems {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25, 30, 10, 15, 20);
        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Blueberry", "Tomato", "Tree");

        // 1. Find all even numbers
        System.out.println("Even Numbers:");
        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        // 2. Square each number
        System.out.println("\nSquares:");
        numbers.stream().map(n -> n * n).forEach(System.out::println);

        // 3. Find the longest string
        System.out.println("\nLongest String:");
        strings.stream().reduce((a, b) -> a.length() > b.length() ? a : b).ifPresent(System.out::println);

        // 4. Count how many strings start with 'A'
        long countA = strings.stream().filter(s -> s.startsWith("A")).count();
        System.out.println("\nStrings starting with 'A': " + countA);

        // 5. Convert strings to uppercase
        System.out.println("\nUppercase Strings:");
        strings.stream().map(String::toUpperCase).forEach(System.out::println);

        // 6. Sort numbers in reverse order
        System.out.println("\nSorted Reverse:");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // 7. Sum of all odd numbers
        int sumOdd = numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("\nSum of Odd Numbers: " + sumOdd);

        // 8. Remove duplicates
        System.out.println("\nUnique Numbers:");
        numbers.stream().distinct().forEach(System.out::println);

        // 9. Second highest number
        System.out.println("\nSecond Highest Number:");
        numbers.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().ifPresent(System.out::println);

        // 10. Check if all numbers are positive
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("\nAll numbers positive? " + allPositive);

        // 11. Average of numbers
        OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();
        average.ifPresent(avg -> System.out.println("\nAverage: " + avg));

        // 12. Partition numbers into even and odd
        System.out.println("\nPartition Even & Odd:");
        Map<Boolean, List<Integer>> partitioned = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even: " + partitioned.get(true));
        System.out.println("Odd: " + partitioned.get(false));

        // 13. Group strings by length
        System.out.println("\nGroup by Length:");
        Map<Integer, List<String>> groupedByLength = strings.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength);

        // 14. Join strings with commas
        String joined = strings.stream().collect(Collectors.joining(", "));
        System.out.println("\nJoined Strings: " + joined);

        // 15. Check if any string starts with "T"
        boolean anyStartsWithT = strings.stream().anyMatch(s -> s.startsWith("T"));
        System.out.println("\nAny string starts with 'T'? " + anyStartsWithT);

        // 16. Frequency of each word
        System.out.println("\nWord Frequency:");
        Map<String, Long> freqMap = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqMap);

        // 17. Common elements between two lists
        List<Integer> otherList = Arrays.asList(10, 35, 25, 40);
        System.out.println("\nCommon Elements:");
        numbers.stream().filter(otherList::contains).distinct().forEach(System.out::println);

        // 18. First element greater than 10
        System.out.println("\nFirst element > 10:");
        numbers.stream().filter(n -> n > 10).findFirst().ifPresent(System.out::println);

        // 19. Multiply all elements using reduce
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("\nProduct of All Numbers: " + product);

        // 20. Create a map from list of users (id -> name)
        List<User> users = Arrays.asList(
                new User(101, "Tilak"),
                new User(102, "Raj"),
                new User(103, "Sahu")
        );
        System.out.println("\nUser Map:");
        Map<Integer, String> userMap = users.stream().collect(Collectors.toMap(User::getId, User::getName));
        System.out.println(userMap);
    }

    static class User {
        private int id;
        private String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() { return id; }
        public String getName() { return name; }
    }
}
