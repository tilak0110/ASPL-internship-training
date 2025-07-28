package remaining_topics.expressions;

public class EvaluationOrder {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int z = 15;
        int result = x + y * z / 5 - 3; // y*z evaluated first  then /5, then +x, then -3
        System.out.println(result);
    }
}
