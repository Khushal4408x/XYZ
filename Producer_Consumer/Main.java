public class Main {
    public static void main(String[] args) {
        int capacity = 5; // Buffer size
        int numItems = 10; // Items to produce/consume
        
        Buffer buffer = new Buffer(capacity);
        
        Producer producer = new Producer(buffer, numItems);
        Consumer consumer = new Consumer(buffer, numItems);
        
        // Start the threads
        producer.start();
        consumer.start();
        
        // Wait for both to finish (optional, for clean exit)
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Program completed.");
    }
}