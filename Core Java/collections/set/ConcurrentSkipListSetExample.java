package collections.set;

import java.util.concurrent.*;

public class ConcurrentSkipListSetExample {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> concurrentSet = new ConcurrentSkipListSet<>();

        // Adding elements
        concurrentSet.add("Spring Boot");
        concurrentSet.add("Java");
        concurrentSet.add("React");
        concurrentSet.add("SQL");

        System.out.println("ConcurrentSkipListSet: " + concurrentSet);

        // Checking if an element exists
        System.out.println("Contains Java? " + concurrentSet.contains("Java"));

        // Removing an element
        concurrentSet.remove("SQL");
        System.out.println("After removing SQL: " + concurrentSet);

        // Getting first and last elements
        System.out.println("First: " + concurrentSet.first());
        System.out.println("Last: " + concurrentSet.last());

        // Polling elements (removes them)
        System.out.println("Poll First: " + concurrentSet.pollFirst());
        System.out.println("Poll Last: " + concurrentSet.pollLast());

        System.out.println("Final Set: " + concurrentSet);
    }
}
