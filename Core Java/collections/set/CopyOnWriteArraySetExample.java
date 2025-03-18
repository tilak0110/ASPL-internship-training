package collections.set;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample {
    public static void main(String[] args) {
        Set<String> copyOnWriteSet = new CopyOnWriteArraySet<>();

        copyOnWriteSet.add("Spring Boot");
        copyOnWriteSet.add("Java");
        copyOnWriteSet.add("React");
        copyOnWriteSet.add("SQL");

        System.out.println("CopyOnWriteArraySet: " + copyOnWriteSet);

        // Removing an element
        copyOnWriteSet.remove("SQL");
        System.out.println("After removing SQL: " + copyOnWriteSet);

        // Checking size
        System.out.println("Size of CopyOnWriteArraySet: " + copyOnWriteSet.size());

        // Iterating while modifying
        Iterator<String> iterator = copyOnWriteSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            copyOnWriteSet.add("New Skill"); // Does not reflect in iteration
        }

        System.out.println("CopyOnWriteArraySet after modification: " + copyOnWriteSet);

        // Clearing the set
        copyOnWriteSet.clear();
        System.out.println("Is CopyOnWriteArraySet empty? " + copyOnWriteSet.isEmpty());
    }
}
