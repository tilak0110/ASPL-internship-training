package remaining_topics.varargs;

public class VarargsOverload {
    static void print(String... msgs) {
        System.out.println("String varargs");
    }

    static void print(int... nums) {
        System.out.println("Integer varargs");
    }

    public static void main(String[] args) {
        print("hello", "world");
        print(10, 20, 30);
    }
}
