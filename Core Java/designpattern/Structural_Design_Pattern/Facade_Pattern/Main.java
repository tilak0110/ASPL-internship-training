package designpattern.Structural_Design_Pattern.Facade_Pattern;

public class Main {
    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();
        facade.placeOrder("Laptop", 999.99);
    }
}
