package collections.map;

import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) {
        WeakHashMap<Object, String> weakMap = new WeakHashMap<>();
        Object key1 = new Object();
        Object key2 = new Object();

        weakMap.put(key1, "Temporary Key");
        weakMap.put(key2, "Persistent Key");

        key1 = null; // Eligible for GC

        System.gc(); // Hint JVM to run GC

        System.out.println("WeakHashMap after GC: " + weakMap);
    }
}
