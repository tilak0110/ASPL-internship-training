package java9features.StreamAPI_new_methods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,4,6,1,5,7,8,9,10);

        List<Integer> result = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(result);

        List<Integer> result1 = numbers.stream().takeWhile(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(result1);


    }
}
