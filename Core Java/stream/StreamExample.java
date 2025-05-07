package stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jack", "Jill", "James", "Jane");


        names.stream()
                .filter(name -> name.startsWith("J"))
                .sorted()
                .forEach(System.out::println);
    }
}
