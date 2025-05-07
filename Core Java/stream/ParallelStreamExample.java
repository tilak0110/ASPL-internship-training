package stream;

import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 1_000_000)
                .parallel() // Enable parallel processing
                .sum();

        long end = System.currentTimeMillis();

        System.out.println("Sum: " + sum);
        System.out.println("Time taken: " + (end - start) + " ms");
    }
}

