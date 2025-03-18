package collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();

        // Adding elements
        hashMap.put(1, "Java");
        hashMap.put(2, "Spring Boot");
        hashMap.put(3, "Microservices");
        hashMap.put(4, "AWS");

        // Fetching value
        System.out.println("Value for key 2: " + hashMap.get(2));

        // Checking existence
        System.out.println("Contains key 3? " + hashMap.containsKey(3));
        System.out.println("Contains value 'AWS'? " + hashMap.containsValue("AWS"));

        // Iterating
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Removing an entry
        hashMap.remove(1);
        System.out.println("After removing key 1: " + hashMap);

        // Other operations
        System.out.println("Size: " + hashMap.size());
        System.out.println("Is empty? " + hashMap.isEmpty());

        // Replace operation
        hashMap.replace(2, "Spring Framework");
        System.out.println("After replacing key 2: " + hashMap);
    }
}
