package designpattern.Behavioral_Design_Pattern.Interpreter_Pattern;

public class Main {
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Tilak");
        Expression john = new TerminalExpression("Sumit");
        return new OrExpression(robert, john);
    }

    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("KhushBoo");
        Expression married = new TerminalExpression("Nikita");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("tilak is male ? " + isMale.interpret("tilak"));
        System.out.println("Nikita is a married women? " + isMarriedWoman.interpret("Married Nikita"));
        System.out.println("Sumit is male? " + isMale.interpret("Sumit"));
    }
}