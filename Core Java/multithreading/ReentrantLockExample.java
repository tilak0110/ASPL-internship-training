package multithreading;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource3 {
    int count = 0;
    ReentrantLock lock = new ReentrantLock();

    void increment() {
        lock.lock(); // Acquire Lock
        try {
            count++;
        } finally {
            lock.unlock(); // Release Lock
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource3 resource = new SharedResource3();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                resource.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                resource.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count: " + resource.count);
    }
}
