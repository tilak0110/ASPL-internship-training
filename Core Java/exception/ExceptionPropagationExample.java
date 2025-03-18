package exception;

class ExceptionPropagationExample {
    static void method1() {
        int num = 10 / 0; // Exception occurs here
    }

    static void method2() {
        method1();
    }

    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Exception propagated: " + e);
        }
    }
}