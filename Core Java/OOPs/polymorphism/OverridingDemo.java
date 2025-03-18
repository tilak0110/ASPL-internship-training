package OOPs.polymorphism;

public class OverridingDemo {
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        obj1.message();

        Parent obj2 = new Child(); // Dynamic Method Dispatch
        obj2.message();
    }
}