package stream;

import java.util.Arrays;
import java.util.List;

public class CountExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        long count = names.stream().count(); // Counts elements
        System.out.println("Total names: " + count);
    }
}
