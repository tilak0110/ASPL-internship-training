package multithreading;

class SleepExample extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadSleepDemo {
    public static void main(String[] args) {
        SleepExample t1 = new SleepExample();
        t1.start();
    }
}
