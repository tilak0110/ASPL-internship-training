package multithreading;

import java.util.concurrent.*;

class SumTask implements Callable<Integer> {
    private final int num;

    public SumTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() { // Returns result
        int sum = 0;
        for (int i = 1; i <= num; i++) sum += i;
        return sum;
    }
}

public class CallableFutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executor.submit(new SumTask(10)); // Task 1
        Future<Integer> future2 = executor.submit(new SumTask(5));  // Task 2

        System.out.println("Sum of 1-10: " + future1.get()); // Blocks till result
        System.out.println("Sum of 1-5: " + future2.get());

        executor.shutdown();
    }
}
