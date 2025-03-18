package collections.queue;

import java.util.PriorityQueue;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }
}

public class PriorityQueueCustomObject {
    public static void main(String[] args) {
        PriorityQueue<Person> pq = new PriorityQueue<>((p1, p2) -> p1.age - p2.age);

        pq.add(new Person("Tilak", 24));
        pq.add(new Person("Raj", 22));
        pq.add(new Person("Sahu", 27));

        System.out.println("PriorityQueue: " + pq);

        while (!pq.isEmpty()) {
            System.out.println("Poll: " + pq.poll());
        }
    }
}
