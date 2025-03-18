package multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
                    System.out.println("Fetching Data...");
                    return 42;
                }).thenApply(result -> result * 2)
                .thenAccept(finalResult -> System.out.println("Processed Result: " + finalResult));

        try { Thread.sleep(2000);
            } catch (InterruptedException e) {} // Wait for async execution
    }
}
