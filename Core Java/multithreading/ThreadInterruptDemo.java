package multithreading;

class InterruptExample extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Running... " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted!");
        }
    }
}

public class ThreadInterruptDemo {
    public static void main(String[] args) {
        InterruptExample t1 = new InterruptExample();
        t1.start();

        try {
            Thread.sleep(3000);
            t1.interrupt(); // Interrupts t1 after 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
