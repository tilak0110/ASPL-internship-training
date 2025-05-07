package java9features.StreamAPI_new_methods;

import java.util.stream.Stream;

public class IterateExample {
    public static void main(String[] args) {
        //Stream.iterate(1 , x->x+1).forEach(System.out::println);//infinitly generate
        Stream.iterate(100 , x->x+1).limit(20).forEach(System.out::println);//generate till limit

    }
}
