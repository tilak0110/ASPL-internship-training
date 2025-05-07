package stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        boolean noneOdd = numbers.stream().noneMatch(n -> n % 2 != 0);

        System.out.println("Any even? " + anyEven);
        System.out.println("All even? " + allEven);
        System.out.println("None odd? " + noneOdd);
    }
}

