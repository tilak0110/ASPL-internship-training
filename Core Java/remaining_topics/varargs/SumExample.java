package remaining_topics.varargs;

public class SumExample {
    static int sum(int... values) {
        int total = 0;
        for (int val : values) {
            total += val;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sum(10, 20));        
        System.out.println(sum(1, 2, 3, 4, 5));
    }
}
