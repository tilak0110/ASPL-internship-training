package stream;

import java.util.stream.Stream;

public class StreamFromArray {
    public static void main(String[] args) {
        String[] arr = {"Java", "Python", "C++"};

        // Creating a Stream from an Array
        Stream<String> stream = Stream.of(arr);
        stream.forEach(System.out::println);
    }
}

