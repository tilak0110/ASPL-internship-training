public class FoodOrder {
    enum OrderState {
        PLACED, PAID, PREPARING, OUT_FOR_DELIVERY, DELIVERED
    }

    private OrderState currentState;

    public FoodOrder() {
        currentState = OrderState.PLACED;
        System.out.println("Order state: " + currentState);
    }

    public void makePayment() {
        if (currentState == OrderState.PLACED) {
            currentState = OrderState.PAID;
            System.out.println("Payment done. Order state: " + currentState);
        }
    }

    public void startPreparing() {
        if (currentState == OrderState.PAID) {
            currentState = OrderState.PREPARING;
            System.out.println("Food is being prepared. Order state: " + currentState);
        }
    }

    public void dispatchOrder() {
        if (currentState == OrderState.PREPARING) {
            currentState = OrderState.OUT_FOR_DELIVERY;
            System.out.println("Order is out for delivery. Order state: " + currentState);
        }
    }

    public void completeDelivery() {
        if (currentState == OrderState.OUT_FOR_DELIVERY) {
            currentState = OrderState.DELIVERED;
            System.out.println("Order delivered. Final state: " + currentState);
        }
    }

    public static void main(String[] args) {
        FoodOrder order = new FoodOrder();
        order.makePayment();
        order.startPreparing();
        order.dispatchOrder();
        order.completeDelivery();
    }
}