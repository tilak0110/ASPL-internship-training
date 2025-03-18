package multithreading;

import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) throws Exception {
        Callable<Integer> task = () -> {
            Thread.sleep(2000);
            return 42;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("Waiting for result...");
        System.out.println("Result: " + futureTask.get()); // Waits till result is ready
    }
}
