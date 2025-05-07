package designpattern.Structural_Design_Pattern.Adapter_Pattern;

class PaymentAdapter implements PaymentProcessor {
    private LegacyPayment legacyPayment = new LegacyPayment();

    public void pay(int rupees) {
        double dollars = rupees / 75.0;
        legacyPayment.makePayment(dollars);
    }
}