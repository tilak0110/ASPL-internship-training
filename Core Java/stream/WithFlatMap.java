package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WithFlatMap {
    public static void main(String[] args) {
        List<String> list1 = List.of("A", "B", "C");
        List<String> list2 = List.of("D", "E", "F");

        Stream.of(list1, list2)
                .flatMap(List::stream)
                .forEach(System.out::println);

        String[][] data = {{"Java", "Python"}, {"C++", "Go"}, {"Rust", "Swift"}};

        Stream.of(data)
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

        List<String> sentences = List.of("Java is awesome", "I love programming", "Streams are powerful");

        sentences.stream()
                .flatMap(sentence -> Stream.of(sentence.split(" "))) // Split into words
                .forEach(System.out::println);
    }
}
