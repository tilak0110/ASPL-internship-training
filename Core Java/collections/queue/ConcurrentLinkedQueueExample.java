package collections.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        // Create a ConcurrentLinkedQueue
        Queue<String> queue = new ConcurrentLinkedQueue<>();

        // Adding elements
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");

        System.out.println("Initial Queue: " + queue);

        // Peek - Retrieves but does not remove the head
        System.out.println("Peek: " + queue.peek());

        // Poll - Retrieves and removes the head
        System.out.println("Polled Element: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // Checking if an element exists
        System.out.println("Contains 'C'? " + queue.contains("C"));

        // Removing an element
        queue.remove("B");
        System.out.println("Queue after removing 'B': " + queue);

        // Iterating through the queue
        System.out.print("Iterating: ");
        for (String item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Checking size
        System.out.println("Queue Size: " + queue.size());

        // Checking if queue is empty
        System.out.println("Is Queue Empty? " + queue.isEmpty());
    }
}
