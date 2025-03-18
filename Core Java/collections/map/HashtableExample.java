package collections.map;

import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        hashtable.put(100, "Security");
        hashtable.put(200, "Performance");
        hashtable.put(300, "Scalability");

        System.out.println("Hashtable: " + hashtable);

        // Checking key existence
        System.out.println("Contains Key 100? " + hashtable.containsKey(100));

        // Fetching elements
        System.out.println("Value for key 200: " + hashtable.get(200));

        // Removing
        hashtable.remove(300);
        System.out.println("After removing key 300: " + hashtable);
    }
}
