package collections.set;

import java.util.*;

public class ImmutableSetExample {
    public static void main(String[] args) {
        // ImmutableSet using Java Collections
        Set<String> immutableSet1 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("Spring Boot", "Java", "React")));

        System.out.println("ImmutableSet using Collections.unmodifiableSet(): " + immutableSet1);


        System.out.println("\nAttempting to modify immutable sets...");
        try {
            immutableSet1.add("New Skill");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification failed for Collections.unmodifiableSet()");
        }


    }
}
