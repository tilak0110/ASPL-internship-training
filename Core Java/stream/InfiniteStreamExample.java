package stream;

import java.util.stream.Stream;
//using iterate
public class InfiniteStreamExample {
    public static void main(String[] args) {
        Stream.iterate(1, n -> n + 2)
                .limit(5) // Limiting it to 5 elements
                .forEach(System.out::println);
    }
}
