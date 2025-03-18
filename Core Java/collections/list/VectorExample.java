package collections.list;

import java.util.*;

public class VectorExample {
    public static void main(String[] args) {
        // Creating a Vector to store your skills
        Vector<String> skills = new Vector<>();

        // Adding elements (Your skills)
        skills.add("Spring Boot");
        skills.add("Java");
        skills.add("React");
        skills.add("SQL");
        skills.add("HTML");
        skills.add("CSS");

        System.out.println("Initial Skills: " + skills);

        // Adding multiple elements using addAll()
        skills.addAll(Arrays.asList("Hibernate", "Microservices", "Kafka"));
        System.out.println("After adding more skills: " + skills);

        // Adding elements at a specific index
        skills.add(2, "AWS");
        System.out.println("After adding AWS at index 2: " + skills);

        // Getting the first and last element
        System.out.println("First skill: " + skills.firstElement());
        System.out.println("Last skill: " + skills.lastElement());

        // Finding the index of an element
        int index = skills.indexOf("SQL");
        System.out.println("Index of SQL: " + index);

        // Finding the last occurrence of an element
        skills.add("Java"); // Duplicate
        int lastIndex = skills.lastIndexOf("Java");
        System.out.println("Last occurrence of Java: " + lastIndex);

        // Checking if the list contains multiple elements
        System.out.println("Contains Java and Spring Boot? " + (skills.contains("Java") && skills.contains("Spring Boot")));

        // Removing an element by value
        skills.remove("CSS");
        System.out.println("After removing CSS: " + skills);

        // Removing an element by index
        skills.remove(3);
        System.out.println("After removing element at index 3: " + skills);

        // Sorting the list in natural order
        Collections.sort(skills);
        System.out.println("Sorted Skills: " + skills);

        // Sorting in reverse order
        skills.sort(Collections.reverseOrder());
        System.out.println("Sorted in reverse order: " + skills);

        // Using replaceAll() to update values
        skills.replaceAll(skill -> skill.equals("Java") ? "Advanced Java" : skill);
        System.out.println("After replacing Java with Advanced Java: " + skills);

        // Converting Vector to Array
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

        // Cloning the Vector
        Vector<String> clonedList = (Vector<String>) skills.clone();
        System.out.println("Cloned List: " + clonedList);

        // Checking if the vector is empty
        System.out.println("Is the skills vector empty? " + skills.isEmpty());

        // Getting the capacity of the vector
        System.out.println("Vector capacity: " + skills.capacity());

        // Trimming the capacity to the current size
        skills.trimToSize();
        System.out.println("Vector capacity after trimToSize(): " + skills.capacity());

        // Clearing the list
        skills.clear();
        System.out.println("After clearing all elements: " + skills);

        // Checking again if empty
        System.out.println("Is the skills vector empty now? " + skills.isEmpty());
    }
}

