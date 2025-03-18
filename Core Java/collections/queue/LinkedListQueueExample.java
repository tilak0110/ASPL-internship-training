package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.add("Task1");
        queue.add("Task2");
        queue.add("Task3");

        System.out.println("Queue: " + queue);

        // Peek (get first element without removing)
        System.out.println("Peek: " + queue.peek());

        // Poll (removes first element)
        System.out.println("Poll: " + queue.poll());
        System.out.println("After Poll: " + queue);

        // Remove (throws exception if empty)
        System.out.println("Remove: " + queue.remove());
        System.out.println("After Remove: " + queue);
    }
}
