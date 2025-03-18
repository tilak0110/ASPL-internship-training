package multithreading;

class MyThreadLifecycle extends Thread {
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is RUNNING");
            Thread.sleep(2000); // Goes into TIMED_WAITING state
            System.out.println(Thread.currentThread().getName() + " is COMPLETED");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadLifecycleExample {
    public static void main(String[] args) throws InterruptedException {
        MyThreadLifecycle t1 = new MyThreadLifecycle();
        System.out.println("State before start(): " + t1.getState());

        t1.start();
        System.out.println("State after start(): " + t1.getState());

        Thread.sleep(500); // Give some time for thread execution
        System.out.println("State during execution: " + t1.getState());

        t1.join(); // Wait for thread to complete
        System.out.println("State after completion: " + t1.getState());
    }
}
