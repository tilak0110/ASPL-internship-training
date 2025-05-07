package stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FindAnyExample {
    public static void main(String[] args) {
        OptionalInt anyEven = IntStream.range(1, 11)
                .parallel() // Runs in parallel
                .filter(n -> n % 2 == 0)
                .findAny(); // Returns any even number

        System.out.println(anyEven.getAsInt());
    }
}

