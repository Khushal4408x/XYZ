public class Consumer extends Thread {
    private Buffer buffer;
    private int numItems; // How many items to consume (same as produced)

    public Consumer(Buffer buffer, int numItems) {
        this.buffer = buffer;
        this.numItems = numItems;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numItems; i++) {
                buffer.consume(); // Consume an item
                Thread.sleep(1000); // Simulate time to consume (1 second, slower than producer)
            }
            System.out.println("Consumer finished consuming " + numItems + " items.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interruption
        }
    }
}
