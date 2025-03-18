package collections.set;

import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Spring Boot");
        linkedHashSet.add("Java");
        linkedHashSet.add("React");
        linkedHashSet.add("SQL");
        linkedHashSet.add("HTML");
        linkedHashSet.add("CSS");

        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Checking if a value exists
        System.out.println("Contains React? " + linkedHashSet.contains("React"));

        // Removing an element
        linkedHashSet.remove("HTML");
        System.out.println("After removing HTML: " + linkedHashSet);

        // Cloning the LinkedHashSet
        Set<String> clonedSet = new LinkedHashSet<>(linkedHashSet);
        System.out.println("Cloned LinkedHashSet: " + clonedSet);

        // Converting to a List
        List<String> list = new ArrayList<>(linkedHashSet);
        System.out.println("Converted to List: " + list);

        // Clearing the set
        linkedHashSet.clear();
        System.out.println("Is LinkedHashSet empty? " + linkedHashSet.isEmpty());
    }
}
