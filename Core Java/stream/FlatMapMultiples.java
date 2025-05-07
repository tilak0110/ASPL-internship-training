package stream;

import java.util.List;
import java.util.stream.IntStream;

public class FlatMapMultiples {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        list.stream()
                .flatMapToInt(n -> IntStream.rangeClosed(1, 3).map(m -> n * m))
                .forEach(System.out::println);
    }
}
