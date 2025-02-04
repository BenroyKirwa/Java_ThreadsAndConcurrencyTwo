public class Order {

    private int orderId;
    private String item;

    public Order(int orderId, String item) {
        this.orderId = orderId;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Order #" + orderId + ": " + item;
    }
}
