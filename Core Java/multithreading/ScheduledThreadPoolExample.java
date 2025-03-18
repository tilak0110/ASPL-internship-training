package multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable task = () -> System.out.println("Task executed at " + System.currentTimeMillis());

        scheduler.schedule(task, 2, TimeUnit.SECONDS); // Runs after 2 sec
        scheduler.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS); // Runs every 3 sec after 1 sec
    }
}
