package Reflection.src.O9_Dynamic_Method_Invocation;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            Class<?> calcClass = calc.getClass();

            // Invoke add method
            Method addMethod = calcClass.getMethod("add", int.class, int.class);
            int sum = (int) addMethod.invoke(calc, 5, 7);
            System.out.println("5 + 7 = " + sum);

            // Invoke multiply method
            Method multiplyMethod = calcClass.getMethod("multiply", double.class, double.class);
            double product = (double) multiplyMethod.invoke(calc, 3.5, 2.5);
            System.out.println("3.5 * 2.5 = " + product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
