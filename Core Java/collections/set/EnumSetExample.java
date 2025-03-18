package collections.set;

import java.util.*;

enum Skills {
    SPRING_BOOT, JAVA, REACT, SQL, HTML, CSS
}

public class EnumSetExample {
    public static void main(String[] args) {
        // Creating an EnumSet with some constants
        EnumSet<Skills> skills = EnumSet.of(Skills.JAVA, Skills.SPRING_BOOT, Skills.REACT);

        System.out.println("EnumSet: " + skills);

        // Adding elements
        skills.add(Skills.SQL);
        System.out.println("After adding SQL: " + skills);

        // Removing an element
        skills.remove(Skills.REACT);
        System.out.println("After removing React: " + skills);

        // Checking if an element exists
        System.out.println("Contains Java? " + skills.contains(Skills.JAVA));

        // Creating an EnumSet of all elements
        EnumSet<Skills> allSkills = EnumSet.allOf(Skills.class);
        System.out.println("All Skills: " + allSkills);

        // Creating an empty EnumSet
        EnumSet<Skills> emptySet = EnumSet.noneOf(Skills.class);
        System.out.println("Empty EnumSet: " + emptySet);

        // Creating an EnumSet from another EnumSet
        EnumSet<Skills> copiedSet = EnumSet.copyOf(skills);
        System.out.println("Copied EnumSet: " + copiedSet);
    }
}
