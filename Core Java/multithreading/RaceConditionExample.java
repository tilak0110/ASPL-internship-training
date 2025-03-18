package multithreading;

class SharedResource {
    int count = 0;

    void increment() { // No Synchronization
        count++;
    }
}

class Worker extends Thread {
    SharedResource resource;

    Worker(SharedResource res) {
        this.resource = res;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            resource.increment(); // Multiple threads modify count
        }
    }
}

public class RaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        Worker t1 = new Worker(resource);
        Worker t2 = new Worker(resource);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + resource.count);
    }
}
