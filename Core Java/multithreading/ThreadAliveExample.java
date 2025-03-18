package multithreading;

class AliveThread extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadAliveExample {
    public static void main(String[] args) throws InterruptedException {
        AliveThread t1 = new AliveThread();
        System.out.println("Before start(): " + t1.isAlive());

        t1.start();
        System.out.println("After start(): " + t1.isAlive());

        t1.join(); // Wait for thread to finish
        System.out.println("After completion: " + t1.isAlive());
    }
}
