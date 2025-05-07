package designpattern.Structural_Design_Pattern.Facade_Pattern;

class OrderFacade {
    private InventoryManager inventory = new InventoryManager();
    private PaymentProcessor payment = new PaymentProcessor();
    private ShippingService shipping = new ShippingService();

    public void placeOrder(String item, double amount) {
        if(inventory.checkStock(item) && payment.chargePayment(amount)) {
            shipping.scheduleDelivery();
            System.out.println("Order placed successfully......");
        }
    }
}