package remaining_topics.expressions;

public class ConstantExpressions {
    public static void main(String[] args) {
        final int A = 10;
        final int B = 20;
        final int RESULT = A + B;   // calculated at compile time
        System.out.println(RESULT);
    }
}
