package collections.set;

import java.util.*;

public class SortedSetExample {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();

        // Adding elements
        sortedSet.add("Spring Boot");
        sortedSet.add("Java");
        sortedSet.add("React");
        sortedSet.add("SQL");
        sortedSet.add("HTML");
        sortedSet.add("CSS");

        System.out.println("SortedSet: " + sortedSet);

        // Getting first and last elements
        System.out.println("First Element: " + sortedSet.first());
        System.out.println("Last Element: " + sortedSet.last());

        // HeadSet - Get elements before "React"
        System.out.println("HeadSet before 'React': " + sortedSet.headSet("React"));

        // TailSet - Get elements from "React" onwards
        System.out.println("TailSet from 'React': " + sortedSet.tailSet("React"));

        // SubSet - Get elements between "CSS" and "Spring Boot"
        System.out.println("SubSet between 'CSS' and 'Spring Boot': " + sortedSet.subSet("CSS", "Spring Boot"));

        // Removing an element
        sortedSet.remove("HTML");
        System.out.println("After removing HTML: " + sortedSet);
    }
}
