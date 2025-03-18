package collections.set;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        // Adding elements
        hashSet.add("Spring Boot");
        hashSet.add("Java");
        hashSet.add("React");
        hashSet.add("SQL");
        hashSet.add("HTML");
        hashSet.add("CSS");

        System.out.println("HashSet: " + hashSet);

        // Checking if empty
        System.out.println("Is HashSet empty? " + hashSet.isEmpty());

        // Removing an element
        hashSet.remove("CSS");
        System.out.println("After removing CSS: " + hashSet);

        // Checking multiple elements at once
        System.out.println("HashSet contains Java and React? " + (hashSet.contains("Java") && hashSet.contains("React")));

        // Converting to an Array
        Object[] array = hashSet.toArray();
        System.out.println("Converted to Array: " + Arrays.toString(array));

        // Retaining common elements
        hashSet.retainAll(Arrays.asList("Spring Boot", "SQL"));
        System.out.println("After retainAll: " + hashSet);

        // Clearing the set
        hashSet.clear();
        System.out.println("Is HashSet empty? " + hashSet.isEmpty());
    }
}
