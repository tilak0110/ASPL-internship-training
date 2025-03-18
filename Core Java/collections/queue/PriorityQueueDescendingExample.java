package collections.queue;

import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueDescendingExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Adding elements
        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);

        System.out.println("PriorityQueue (Descending Order): " + pq);

        // Polling elements
        while (!pq.isEmpty()) {
            System.out.println("Poll: " + pq.poll());
        }
    }
}
