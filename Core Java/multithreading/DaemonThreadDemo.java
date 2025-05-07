package multithreading;

class DaemonExample extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Daemon Thread Running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DaemonThreadDemo {
    public static void main(String[] args) {
        DaemonExample t1 = new DaemonExample();
        t1.setDaemon(true); // Convert to daemon thread

        t1.start();
        System.out.println("java9features.Try_With_Resource_Enhancement.Main thread ends...");
    }
}
