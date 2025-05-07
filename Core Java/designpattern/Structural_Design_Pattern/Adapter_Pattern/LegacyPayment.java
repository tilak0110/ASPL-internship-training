package designpattern.Structural_Design_Pattern.Adapter_Pattern;

class LegacyPayment {
    public void makePayment(double dollars) {
        System.out.println("Paid $" + dollars);
    }
}