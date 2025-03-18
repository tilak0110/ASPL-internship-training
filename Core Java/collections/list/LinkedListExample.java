package collections.list;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        // Creating a LinkedList to store your skills
        LinkedList<String> skills = new LinkedList<>();

        // Adding elements (Your skills)
        skills.add("Spring Boot");
        skills.add("Java");
        skills.add("React");
        skills.add("SQL");
        skills.add("HTML");
        skills.add("CSS");

        System.out.println("Initial Skills: " + skills);

        // Adding elements at the first and last position
        skills.addFirst("Hibernate");
        skills.addLast("Microservices");
        System.out.println("After adding at first and last: " + skills);

        // Getting the first and last element
        System.out.println("First skill: " + skills.getFirst());
        System.out.println("Last skill: " + skills.getLast());

        // Finding the index of an element
        int index = skills.indexOf("SQL");
        System.out.println("Index of SQL: " + index);

        // Finding the last occurrence of an element
        skills.add("Java"); // Duplicate
        int lastIndex = skills.lastIndexOf("Java");
        System.out.println("Last occurrence of Java: " + lastIndex);

        // Checking if the list contains an element
        System.out.println("Contains Spring Boot? " + skills.contains("Spring Boot"));

        // Removing first and last element
        skills.removeFirst();
        skills.removeLast();
        System.out.println("After removing first and last: " + skills);

        // Removing an element by value
        skills.remove("CSS");
        System.out.println("After removing CSS: " + skills);

        // Removing an element by index
        skills.remove(2);
        System.out.println("After removing element at index 2: " + skills);

        // Adding multiple elements using addAll()
        skills.addAll(Arrays.asList("Kafka", "AWS", "Docker"));
        System.out.println("After adding more skills: " + skills);

        // Sorting the list in natural order
        Collections.sort(skills);
        System.out.println("Sorted Skills: " + skills);

        // Sorting in reverse order
        skills.sort(Collections.reverseOrder());
        System.out.println("Sorted in reverse order: " + skills);

        // Using replaceAll() to update values
        skills.replaceAll(skill -> skill.equals("Java") ? "Advanced Java" : skill);
        System.out.println("After replacing Java with Advanced Java: " + skills);

        // Converting LinkedList to Array
        String[] skillsArray = skills.toArray(new String[0]);
        System.out.println("Array version of skills: " + Arrays.toString(skillsArray));

        // Using removeIf() to remove elements conditionally
        skills.removeIf(skill -> skill.startsWith("A")); // Removes "Advanced Java"
        System.out.println("After removeIf (removing skills starting with 'A'): " + skills);

        // Using ListIterator to iterate and modify elements
        ListIterator<String> listIterator = skills.listIterator();
        while (listIterator.hasNext()) {
            String skill = listIterator.next();
            listIterator.set(skill.toUpperCase()); // Modify elements to uppercase
        }
        System.out.println("After using ListIterator (Uppercased skills): " + skills);

        // Cloning the LinkedList
        LinkedList<String> clonedList = (LinkedList<String>) skills.clone();
        System.out.println("Cloned List: " + clonedList);

        // Creating an immutable list using unmodifiableList()
        List<String> immutableList = Collections.unmodifiableList(skills);
        System.out.println("Immutable List: " + immutableList);

        // Checking if the list is empty
        System.out.println("Is the skills list empty? " + skills.isEmpty());

        // Clearing the list
        skills.clear();
        System.out.println("After clearing all elements: " + skills);

        // Checking again if empty
        System.out.println("Is the skills list empty now? " + skills.isEmpty());
    }
}
