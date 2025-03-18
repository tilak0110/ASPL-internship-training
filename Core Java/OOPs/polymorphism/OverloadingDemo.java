package OOPs.polymorphism;

public class OverloadingDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Multiplication (int): " + calc.multiply(5, 10));
        System.out.println("Multiplication (double): " + calc.multiply(5.5, 10.5));
    }
}