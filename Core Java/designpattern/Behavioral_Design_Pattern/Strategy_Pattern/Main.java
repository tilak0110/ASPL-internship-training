package designpattern.Behavioral_Design_Pattern.Strategy_Pattern;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Credit card se payment
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(1000);

        // UPI se payment
        cart.setPaymentStrategy(new UPIPayment("user@upi"));
        cart.checkout(500);
    }
}