package collections.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        // Creating a CopyOnWriteArrayList
        List<String> skills = new CopyOnWriteArrayList<>();

        // Adding elements (Tilak Raj Sahu's skills)
        skills.add("Spring Boot");
        skills.add("Java");
        skills.add("React");
        skills.add("SQL");
        skills.add("HTML");
        skills.add("CSS");

        System.out.println("Initial Skills: " + skills);

        // Adding more skills
        skills.addAll(List.of("Hibernate", "Microservices", "Kafka"));
        System.out.println("After adding more skills: " + skills);

        // Iterating using an Iterator (Thread-Safe)
        System.out.print("Iterating safely: ");
        Iterator<String> iterator = skills.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
            skills.add("New Skill");  // This will NOT cause ConcurrentModificationException
        }
        System.out.println("\nSkills after modification during iteration: " + skills);

        // Removing an element
        skills.remove("CSS");
        System.out.println("After removing CSS: " + skills);

        // Replacing values using replaceAll()
        skills.replaceAll(skill -> skill.equals("Java") ? "Advanced Java" : skill);
        System.out.println("After replacing Java with Advanced Java: " + skills);

        // Sorting the list
        skills.sort(String::compareTo);
        System.out.println("Sorted Skills: " + skills);

        // Checking if a skill exists
        System.out.println("Contains 'Spring Boot'? " + skills.contains("Spring Boot"));

        // Getting an element by index
        System.out.println("Skill at index 2: " + skills.get(2));

        // Checking if the list is empty
        System.out.println("Is the skills list empty? " + skills.isEmpty());

        // Converting to an array
        String[] skillsArray = skills.toArray(new String[0]);
        System.out.println("Array version of skills: " + java.util.Arrays.toString(skillsArray));

        // Clearing the list
        skills.clear();
        System.out.println("After clearing all elements: " + skills);
    }
}
