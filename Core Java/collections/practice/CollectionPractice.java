package collections.practice;

import java.util.*;

public class CollectionPractice {

    // 1. Reverse an ArrayList
    public static void reverseArrayList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.reverse(list);
        System.out.println("Reversed List: " + list);
    }

    // 2. Remove Duplicates from a List
    public static void removeDuplicates() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
        Set<Integer> set = new LinkedHashSet<>(list);
        list = new ArrayList<>(set);
        System.out.println("List without duplicates: " + list);
    }

    // 3. Find Second Largest Number in List
    public static void findSecondLargest() {
        List<Integer> list = Arrays.asList(10, 20, 5, 30, 25);
        TreeSet<Integer> sortedSet = new TreeSet<>(list);
        List<Integer> sortedList = new ArrayList<>(sortedSet);
        System.out.println("Second Largest: " + sortedList.get(sortedList.size() - 2));
    }

    // 4. Convert List to Array
    public static void listToArray() {
        List<String> list = Arrays.asList("A", "B", "C");
        String[] array = list.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(array));
    }

    // 5. Sort List in Descending Order
    public static void sortDescending() {
        List<Integer> list = Arrays.asList(5, 2, 8, 1, 3);
        list.sort(Collections.reverseOrder());
        System.out.println("Sorted Descending: " + list);
    }

    // 6. Find Common Elements in Two Sets
    public static void findCommonElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        set1.retainAll(set2);
        System.out.println("Common Elements: " + set1);
    }

    // 7. Remove Even Numbers from a Set
    public static void removeEvenNumbers() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        set.removeIf(n -> n % 2 == 0);
        System.out.println("Set after removing evens: " + set);
    }

    // 8. Count Word Frequency in a String
    public static void wordFrequency() {
        String text = "apple banana apple orange banana apple";
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : text.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequency: " + wordCount);
    }

    // 9. Sort HashMap by Values
    public static void sortMapByValue() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Banana");
        map.put(2, "Apple");
        map.put(3, "Cherry");

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }

    // 10. Merge Two Maps
    public static void mergeMaps() {
        Map<Integer, String> map1 = Map.of(1, "A", 2, "B");
        Map<Integer, String> map2 = Map.of(3, "C", 4, "D");

        Map<Integer, String> merged = new HashMap<>(map1);
        merged.putAll(map2);

        System.out.println("Merged Map: " + merged);
    }

    // 11. Implement a Priority Queue in Descending Order
    public static void priorityQueueExample() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(5);
        pq.add(1);
        pq.add(3);
        System.out.println("Max element in PriorityQueue: " + pq.poll());
    }

    // 12. Implement LRU Cache using LinkedHashMap
    public static void lruCacheExample() {
        class LRUCache<K, V> extends LinkedHashMap<K, V> {
            private final int capacity;

            public LRUCache(int capacity) {
                super(capacity, 0.75f, true);
                this.capacity = capacity;
            }

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        }

        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.put(4, "D"); // Oldest entry (1, "A") removed

        System.out.println("LRU Cache: " + cache);
    }

    // 13. Find First Non-Repeating Character in a String
    public static void firstNonRepeatingChar() {
        String str = "swiss";
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First Non-Repeating Character: " + entry.getKey());
                return;
            }
        }
    }

    // 14. Sort a List of Strings by Length
    public static void sortByStringLength() {
        List<String> list = Arrays.asList("apple", "banana", "kiwi", "cherry");
        list.sort(Comparator.comparingInt(String::length));
        System.out.println("Sorted by Length: " + list);
    }

    // 15. Find Most Frequent Element in a List
    public static void mostFrequentElement() {
        List<Integer> list = Arrays.asList(1, 3, 2, 3, 4, 3, 5);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : list) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxCount = Collections.max(freqMap.values());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.println("Most Frequent Element: " + entry.getKey());
                return;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("---- List Operations ----");
        reverseArrayList();
        removeDuplicates();
        findSecondLargest();
        listToArray();
        sortDescending();

        System.out.println("\n---- Set Operations ----");
        findCommonElements();
        removeEvenNumbers();

        System.out.println("\n---- Map Operations ----");
        wordFrequency();
        sortMapByValue();
        mergeMaps();

        System.out.println("\n---- Queue Operations ----");
        priorityQueueExample();
        lruCacheExample();

        System.out.println("\n---- Miscellaneous ----");
        firstNonRepeatingChar();
        sortByStringLength();
        mostFrequentElement();
    }
}
