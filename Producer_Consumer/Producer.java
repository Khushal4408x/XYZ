public class Producer extends Thread {
    private Buffer buffer;
    private int numItems; // How many items to produce

    public Producer(Buffer buffer, int numItems) {
        this.buffer = buffer;
        this.numItems = numItems;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= numItems; i++) {
                buffer.produce(i); // Produce item i
                Thread.sleep(500); // Simulate time to produce (0.5 seconds)
            }
            System.out.println("Producer finished producing " + numItems + " items.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interruption
        }
    }
}