package collections.map;

import java.util.IdentityHashMap;


public class IdentityHashMapExample {
    public static void main(String[] args) {
        IdentityHashMap<String, String> identityMap = new IdentityHashMap<>();

        String key1 = new String("Java");
        String key2 = new String("Java"); // Different object in memory

        identityMap.put(key1, "First Entry");
        identityMap.put(key2, "Second Entry");

        System.out.println("IdentityHashMap: " + identityMap);

        // Example with Integers using Integer.valueOf()
        IdentityHashMap<Integer, String> intIdentityMap = new IdentityHashMap<>();

        Integer intKey1 = Integer.valueOf(200);
        Integer intKey2 = Integer.valueOf(200); // Different object for values outside -128 to 127

        intIdentityMap.put(intKey1, "First Entry");
        intIdentityMap.put(intKey2, "Second Entry");

        System.out.println("IdentityHashMap with Integers: " + intIdentityMap);
    }
}
