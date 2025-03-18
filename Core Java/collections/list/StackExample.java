package collections.list;

import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        // Creating a Stack to store your skills
        Stack<String> skills = new Stack<>();

        // Pushing elements onto the stack (Your skills)
        skills.push("Spring Boot");
        skills.push("Java");
        skills.push("React");
        skills.push("SQL");
        skills.push("HTML");
        skills.push("CSS");

        System.out.println("Initial Stack: " + skills);

        // Pushing more elements
        skills.push("Hibernate");
        skills.push("Microservices");
        skills.push("Kafka");
        System.out.println("After pushing more skills: " + skills);

        // Getting the element at the top of the stack
        System.out.println("Top element (peek): " + skills.peek());

        // Searching for an element (returns position from the top, 1-based index)
        int position = skills.search("Java");
        System.out.println("Position of Java from top: " + position);

        // Popping elements from the stack
        System.out.println("Popped element: " + skills.pop());
        System.out.println("Stack after pop: " + skills);

        // Checking if the stack contains a specific element
        System.out.println("Contains Spring Boot? " + skills.contains("Spring Boot"));

        // Checking if the stack is empty
        System.out.println("Is the stack empty? " + skills.isEmpty());

        // Iterating through the stack using a for-each loop
        System.out.print("Iterating through stack: ");
        for (String skill : skills) {
            System.out.print(skill + " ");
        }
        System.out.println();

        // Sorting the stack (converting to a List first)
        Collections.sort(skills);
        System.out.println("Sorted Stack: " + skills);

        // Sorting in reverse order
        skills.sort(Collections.reverseOrder());
        System.out.println("Sorted in reverse order: " + skills);

        // Using replaceAll() to update values
        skills.replaceAll(skill -> skill.equals("Java") ? "Advanced Java" : skill);
        System.out.println("After replacing Java with Advanced Java: " + skills);

        // Converting Stack to Array
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

        // Cloning the Stack
        Stack<String> clonedStack = (Stack<String>) skills.clone();
        System.out.println("Cloned Stack: " + clonedStack);

        // Clearing the stack
        skills.clear();
        System.out.println("After clearing all elements: " + skills);

        // Checking again if empty
        System.out.println("Is the stack empty now? " + skills.isEmpty());
    }
}
