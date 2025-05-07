package stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FindFirstExample {
    public static void main(String[] args) {
        OptionalInt firstEven = IntStream.range(1, 11)
                .filter(n -> n % 2 == 0)
                .findFirst(); // Finds first even number

        System.out.println(firstEven.getAsInt()); // Prints the first even number
    }
}
