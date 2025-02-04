import java.util.Random;
import java.util.concurrent.BlockingQueue;

// Customer class (Producer)
class Customer implements Runnable {
    private BlockingQueue<Order> orderQueue;
    private int customerId;
    private static int orderCounter = 1;
    private String[] menu = {"Pizza", "Burger", "Pasta", "Salad"};

    public Customer(BlockingQueue<Order> orderQueue, int customerId) {
        this.orderQueue = orderQueue;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        try {
            // Randomly select a menu item
            String item = menu[new Random().nextInt(menu.length)];
            Order order = new Order(orderCounter++, item);

            System.out.println("Customer " + customerId + " placing " + order);
            orderQueue.put(order);

            Thread.sleep(1000); // Wait before placing another order
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
