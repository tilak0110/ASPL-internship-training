package remaining_topics.varargs;

public class VarargsExample {
    static void printNumbers(int... nums) {
        System.out.println("Total numbers: " + nums.length);
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printNumbers();
        printNumbers(1);
        printNumbers(1, 2, 3, 4, 5);
    }
}
