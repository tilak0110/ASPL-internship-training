package collections.queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements
        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);

        System.out.println("PriorityQueue: " + pq); // Elements may not be in sorted order

        // Peek (Check highest priority element)
        System.out.println("Peek (Highest Priority): " + pq.peek());

        // Poll (Remove highest priority element)
        System.out.println("Poll (Removing): " + pq.poll());
        System.out.println("After Poll: " + pq);

        // Remove a specific element
        pq.remove(30);
        System.out.println("After Removing 30: " + pq);
    }
}

