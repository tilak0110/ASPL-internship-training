package collections.list;

import java.util.*;

public class ImmutableListExamples {
    public static void main(String[] args) {
        // Using List.of() (Java 9+)
        List<String> skills1 = List.of("Spring Boot", "Java", "React", "SQL", "HTML", "CSS");
        System.out.println("Immutable List using List.of(): " + skills1);
        // skills1.add("Hibernate");  // ERROR: UnsupportedOperationException

        // Using Collections.unmodifiableList() (Java 8 and earlier)
        List<String> mutableList = new ArrayList<>(Arrays.asList("Spring Boot", "Java", "React", "SQL"));
        List<String> skills2 = Collections.unmodifiableList(mutableList);
        System.out.println("Immutable List using Collections.unmodifiableList(): " + skills2);




        // Checking immutability
        System.out.println("\nAttempting to modify lists...");
        try {
            skills1.add("New Skill");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification failed for List.of()");
        }

        try {
            skills2.add("New Skill");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification failed for Collections.unmodifiableList()");
        }


    }
}
