package collections.queue.deque;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentDequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ConcurrentLinkedDeque<>();

        // Adding elements in a multi-threaded environment
        Runnable addTask = () -> {
            for (int i = 1; i <= 3; i++) {
                deque.add("Task-" + i);
            }
        };

        Thread t1 = new Thread(addTask);
        Thread t2 = new Thread(addTask);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Concurrent Deque: " + deque);
    }
}
