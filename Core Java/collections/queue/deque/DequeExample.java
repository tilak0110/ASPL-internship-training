package collections.queue.deque;

import java.util.Deque;
import java.util.ArrayDeque;

public class DequeExample {
    public static void main(String[] args) {
        // Creating a Deque using ArrayDeque
        Deque<String> deque = new ArrayDeque<>();

        // Adding elements at both ends
        deque.addFirst("A"); // Adds at the front
        deque.addLast("B");  // Adds at the end
        deque.offerFirst("C"); // Adds at front, returns false if full
        deque.offerLast("D");  // Adds at end, returns false if full

        System.out.println("Deque: " + deque); // [C, A, B, D]

        // Accessing elements
        System.out.println("First Element: " + deque.getFirst()); // C
        System.out.println("Last Element: " + deque.getLast());   // D

        // Removing elements from both ends
        System.out.println("Removed First: " + deque.removeFirst()); // C
        System.out.println("Removed Last: " + deque.removeLast());   // D

        System.out.println("Deque after removals: " + deque); // [A, B]

        // Poll methods (return null if empty instead of exception)
        System.out.println("Poll First: " + deque.pollFirst()); // A
        System.out.println("Poll Last: " + deque.pollLast());   // B

        System.out.println("Final Deque: " + deque); // []
    }
}
