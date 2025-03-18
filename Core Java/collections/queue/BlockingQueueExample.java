package collections.queue;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        // ArrayBlockingQueue - Fixed Size Queue (FIFO)
        BlockingQueue<String> arrayQueue = new ArrayBlockingQueue<>(3);
        arrayQueue.put("A"); arrayQueue.put("B"); arrayQueue.put("C");
        System.out.println("ArrayBlockingQueue: " + arrayQueue);
        System.out.println("Removed: " + arrayQueue.take()); // Removes A

        // LinkedBlockingQueue - Optionally Bounded Queue
        BlockingQueue<String> linkedQueue = new LinkedBlockingQueue<>();
        linkedQueue.put("X"); linkedQueue.put("Y"); linkedQueue.put("Z");
        System.out.println("LinkedBlockingQueue: " + linkedQueue);
        System.out.println("Removed: " + linkedQueue.poll()); // Removes X

        // PriorityBlockingQueue - Priority-Based Order
        BlockingQueue<Integer> priorityQueue = new PriorityBlockingQueue<>();
        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(20);
        System.out.println("PriorityBlockingQueue: " + priorityQueue);
        System.out.println("Removed: " + priorityQueue.take()); // Removes 10

        // SynchronousQueue - No Capacity (Direct Handoff)
        BlockingQueue<String> syncQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                syncQueue.put("Direct Transfer");
                System.out.println("Added to SynchronousQueue");
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();
        Thread.sleep(1000);
        System.out.println("SynchronousQueue Received: " + syncQueue.take());

        // DelayQueue - Delayed Elements Processing
        BlockingQueue<DelayedElement> delayQueue = new DelayQueue<>();
        delayQueue.put(new DelayedElement("Task 1", 3000));
        delayQueue.put(new DelayedElement("Task 2", 5000));
        System.out.println("DelayQueue: Waiting for elements...");
        while (!delayQueue.isEmpty()) {
            System.out.println("Processed: " + delayQueue.take());
        }
    }

    // Custom class for DelayQueue (Implements Delayed Interface)
    static class DelayedElement implements Delayed {
        private String name;
        private long startTime;

        public DelayedElement(String name, long delayInMillis) {
            this.name = name;
            this.startTime = System.currentTimeMillis() + delayInMillis;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(startTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
