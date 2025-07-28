package remaining_topics.expressions;

public class OperatorPrecedenceExample {
    public static void main(String[] args) {
        int result = 10 + 2 * 5;      // * has higher precedence
        System.out.println(result);

        int result2 = (10 + 2) * 5;   // () change precedence
        System.out.println(result2);
    }
}
