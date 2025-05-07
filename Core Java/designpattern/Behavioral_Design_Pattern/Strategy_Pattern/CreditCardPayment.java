package designpattern.Behavioral_Design_Pattern.Strategy_Pattern;

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNo) {
        this.cardNumber = cardNo;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}