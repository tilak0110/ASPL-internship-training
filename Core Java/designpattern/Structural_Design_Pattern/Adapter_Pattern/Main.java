package designpattern.Structural_Design_Pattern.Adapter_Pattern;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentAdapter();
        processor.pay(7500);
    }
}
