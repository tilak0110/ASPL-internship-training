package collections.set;

import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("Spring Boot");
        treeSet.add("Java");
        treeSet.add("React");
        treeSet.add("SQL");
        treeSet.add("HTML");
        treeSet.add("CSS");

        System.out.println("TreeSet (Sorted Order): " + treeSet);

        // Getting first and last elements
        System.out.println("First Element: " + treeSet.first());
        System.out.println("Last Element: " + treeSet.last());

        // Removing an element
        treeSet.remove("React");
        System.out.println("After removing React: " + treeSet);

        // Subset from SQL onwards
        System.out.println("Subset from SQL: " + treeSet.tailSet("SQL"));

        // Headset (elements before React)
        System.out.println("HeadSet before 'SQL': " + treeSet.headSet("SQL"));

        // Checking if a value exists
        System.out.println("Contains CSS? " + treeSet.contains("CSS"));

        // Clearing the set
        treeSet.clear();
        System.out.println("Is TreeSet empty? " + treeSet.isEmpty());
    }
}
