package collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(10, "Java");
        linkedHashMap.put(20, "Spring");
        linkedHashMap.put(30, "Hibernate");

        System.out.println("LinkedHashMap (Insertion Order): " + linkedHashMap);

        // Removing a key
        linkedHashMap.remove(20);

        // Accessing keys and values
        System.out.println("Key Set: " + linkedHashMap.keySet());
        System.out.println("Values: " + linkedHashMap.values());
    }
}
