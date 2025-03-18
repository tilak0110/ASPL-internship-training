package collections.list;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList to store your skills
        ArrayList<String> skills = new ArrayList<>();

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

        // Getting the first and last element
        System.out.println("First skill: " + skills.get(0));
        System.out.println("Last skill: " + skills.get(skills.size() - 1));

        // Finding the index of an element
        int index = skills.indexOf("SQL");
        System.out.println("Index of SQL: " + index);

        // Finding the last occurrence of an element
        skills.add("Java"); // Duplicate
        int lastIndex = skills.lastIndexOf("Java");
        System.out.println("Last occurrence of Java: " + lastIndex);

        // Checking if the list contains multiple elements
        List<String> checkSkills = Arrays.asList("Java", "Spring Boot");
        System.out.println("Contains Java and Spring Boot? " + skills.containsAll(checkSkills));

        // Removing multiple elements using removeAll()
        skills.removeAll(Arrays.asList("CSS", "HTML"));
        System.out.println("After removing CSS and HTML: " + skills);

        // Keeping only specific elements using retainAll()
        skills.retainAll(Arrays.asList("Spring Boot", "Java", "Microservices"));
        System.out.println("After retaining Spring Boot, Java, and Microservices: " + skills);

        // Sorting the list in natural order
        Collections.sort(skills);
        System.out.println("Sorted Skills: " + skills);

        // Sorting in reverse order
        skills.sort(Collections.reverseOrder());
        System.out.println("Sorted in reverse order: " + skills);

        // Shuffling elements
        Collections.shuffle(skills);
        System.out.println("After shuffling: " + skills);

        // Using replaceAll() to update values
        skills.replaceAll(skill -> skill.equals("Java") ? "Advanced Java" : skill);
        System.out.println("After replacing Java with Advanced Java: " + skills);

        // Converting ArrayList to Array
        String[] skillsArray = skills.toArray(new String[0]);
        System.out.println("Array version of skills: " + Arrays.toString(skillsArray));

        // Using removeIf() to remove elements conditionally
        skills.removeIf(skill -> skill.startsWith("M")); // Removes "Microservices"
        System.out.println("After removeIf (removing skills starting with 'M'): " + skills);

        // Using ListIterator to iterate and modify elements
        ListIterator<String> listIterator = skills.listIterator();
        while (listIterator.hasNext()) {
            String skill = listIterator.next();
            listIterator.set(skill.toUpperCase()); // Modify elements to uppercase
        }
        System.out.println("After using ListIterator (Uppercased skills): " + skills);

        // Cloning the ArrayList
        ArrayList<String> clonedList = (ArrayList<String>) skills.clone();
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
