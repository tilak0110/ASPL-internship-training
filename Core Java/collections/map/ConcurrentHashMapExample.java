package collections.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();

        concurrentMap.put(1, "Threading");
        concurrentMap.put(2, "Concurrency");
        concurrentMap.put(3, "Parallelism");

        System.out.println("ConcurrentHashMap: " + concurrentMap);

        // Using compute() to update value
        concurrentMap.compute(2, (key, value) -> value + " - Updated");
        System.out.println("After Compute: " + concurrentMap);
    }
}
