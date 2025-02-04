import java.util.concurrent.BlockingQueue;

// Chef class (Consumer)
class Chef implements Runnable {
    private BlockingQueue<Order> orderQueue;

    public Chef(BlockingQueue<Order> orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Order order = orderQueue.take();
                System.out.println("Chef preparing: " + order);
                Thread.sleep(2000); // Simulate cooking time
                System.out.println("Chef finished: " + order);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

