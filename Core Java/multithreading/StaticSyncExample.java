package multithreading;

class SharedResource2 {
    static int count = 0;

    static synchronized void increment() { // Locks class
        count++;
    }
}

public class StaticSyncExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SharedResource2.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SharedResource2.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count: " + SharedResource2.count);
    }
}
