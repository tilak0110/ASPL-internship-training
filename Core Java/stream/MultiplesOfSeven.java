package stream;

import java.util.stream.Stream;

public class MultiplesOfSeven {
    public static void main(String[] args) {
        Stream.iterate(7, n -> n + 7) // Start from 7, add 7 each time
                .limit(10) // Take first 10 multiples
                .forEach(System.out::println);
    }
}

