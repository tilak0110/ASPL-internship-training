package stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MinMaxExample {
    public static void main(String[] args) {
        OptionalInt minValue = IntStream.of(10, 20, 5, 40, 25).min();

        System.out.println(minValue.getAsInt());

        OptionalInt maxValue = IntStream.of(10, 20, 5, 40, 25).max();

        System.out.println(maxValue.getAsInt());
    }
}
