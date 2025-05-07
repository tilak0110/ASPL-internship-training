package stream;

import java.util.stream.IntStream;

public class SumExample {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 10) // 1 to 10
                .sum(); // Computes sum
        System.out.println("Sum: " + sum);
    }
}
