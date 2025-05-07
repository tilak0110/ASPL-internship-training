package java9features.collectionMethod;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionMethodExample {
    public static void main(String[] args) {
        /*
        Factory method is a special type of static method
        which are used to create unmodifiable instances of collections
        we  can use it with List , Set and Map
         */
        List<Integer> list = List.of(1,2,3,4,5) ;
        list.forEach(System.out::println);
        //list.add(6); // this will throw UnsupportedOperationException at runtime

        Set<Integer> set = Set.of(1,2,3,4,5) ;
        set.forEach(System.out::println);
        //set.add(6); // this will throw UnsupportedOperationException at runtime

        Map<Integer , String> map = Map.of(1,"Tilak" , 2 , "vivek" , 3 , "pranav");
        map.forEach((k,v) -> System.out.println(k+" = "+v));
        //map.put(4 , "sumit"); //this will throw UnsupportedOperationException at runtime
    }

}
