package stream;

import java.util.stream.LongStream;

public class LongStreamExample {
    public static void main(String[] args) {
        long sum = LongStream.rangeClosed(1, 5) // 1 to 5
                .map(n -> n * 2) // Convert to even numbers
                .sum();
        System.out.println("Sum: " + sum);
    }
}
