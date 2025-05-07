package stream;

import java.util.stream.DoubleStream;

public class DoubleStreamExample {
    public static void main(String[] args) {
        DoubleStream.generate(Math::random) // Generates random doubles
                .limit(5) // Take 5 values
                .forEach(System.out::println);
    }
}
