package remaining_topics.iteratoriterable;

import java.util.*;

public class IteratorIterableDemo {

    static class Alphabet implements Iterable<Character> {
        public Iterator<Character> iterator() {
            return new Iterator<Character>() {
                char current = 'a';
                public boolean hasNext() {
                    return current <= 'z';
                }
                public Character next() {
                    return current++;
                }
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("A", "", "B", "", "C"));
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            if (it.next().isEmpty()) {
                it.remove();
            }
        }
        System.out.println(names);

        for (char c : new Alphabet()) {
            System.out.print(c + " ");
        }
        System.out.println();

        List<Integer> nums = Arrays.asList(1, 2, 3);
        for (int num : nums) {
            System.out.println(num);
        }

        Iterator<Integer> it2 = nums.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        List<String> items = Arrays.asList("Red", "Green", "Blue");
        Iterator<String> it3 = items.iterator();
        while (it3.hasNext()) {
            System.out.print(it3.next());
            if (it3.hasNext()) {
                System.out.print(", ");
            }
        }
    }
}
