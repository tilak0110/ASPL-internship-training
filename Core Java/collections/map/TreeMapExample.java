package collections.map;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(5, "Cloud");
        treeMap.put(1, "AWS");
        treeMap.put(10, "Docker");

        System.out.println("TreeMap (Sorted Order): " + treeMap);

        // Getting first and last keys
        System.out.println("First Key: " + treeMap.firstKey());
        System.out.println("Last Key: " + treeMap.lastKey());

        // Getting subsets
        System.out.println("HeadMap (<5): " + treeMap.headMap(5));
        System.out.println("TailMap (>=5): " + treeMap.tailMap(5));
    }
}
