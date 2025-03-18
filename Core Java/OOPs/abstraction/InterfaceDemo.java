package OOPs.abstraction;

interface Animal {
    void sound();
}

interface Walkable {
    void walk();
}

class Cat implements Animal, Walkable {
    public void sound() {
        System.out.println("Cat meows...");
    }

    public void walk() {
        System.out.println("Cat is walking.");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sound();
        cat.walk();
    }
}
