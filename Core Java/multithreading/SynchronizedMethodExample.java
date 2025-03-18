package multithreading;

class SharedResource1 {
    int count = 0;

    synchronized void increment() { // Synchronization added
        count++;
    }
}

//class SharedResource {
//    int count = 0;
//
//    void increment() {
//        synchronized (this) { // Only critical section is locked
//            count++;
//        }
//    }
//}


public class SynchronizedMethodExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource1 resource = new SharedResource1();

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
