package collections.queue.deque;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListDequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);

        System.out.println("Deque: " + deque); // [3, 1, 2]

        System.out.println("First: " + deque.getFirst()); // 3
        System.out.println("Last: " + deque.getLast());   // 2

        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removals: " + deque); // [1]
    }
}
