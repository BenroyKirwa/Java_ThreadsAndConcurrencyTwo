import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    // Main class
    public static void main(String[] args) throws Exception{
        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(10);

        // Create and start chef
        Thread chefThread = new Thread(new Chef(orderQueue));
        chefThread.start();

        // Create and start multiple customers
        for (int i = 1; i <= 5; i++) {
            Thread customerThread = new Thread(new Customer(orderQueue, i));
            customerThread.start();
        }

        // Wait for chef to finish preparing dishes
        chefThread.join();
        
        // Stop chef and close restaurant
        chefThread.interrupt();
        if (chefThread.isInterrupted()){
            System.out.println("Restaurant closed !! See you Tomorrow");
        }

    }
}