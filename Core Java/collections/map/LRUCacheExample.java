package collections.map;

import java.util.*;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity; // Max size of cache

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // Enable access order
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // Remove eldest when size exceeds capacity
    }
}

public class LRUCacheExample {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3); // Cache of size 3

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println("Cache after adding 3 elements: " + cache);

        cache.get(1); // Accessing 1 makes it most recently used
        cache.put(4, "D"); // Since cache is full, it removes least recently used (2)

        System.out.println("Cache after adding 4 (evicts 2): " + cache);

        cache.put(5, "E"); // Evicts 3 (LRU item)
        System.out.println("Cache after adding 5 (evicts 3): " + cache);
    }
}
