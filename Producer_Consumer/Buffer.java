import java.util.LinkedList;

public class Buffer {
    private LinkedList<Integer> buffer = new LinkedList<>(); // The shared queue
    private int capacity; // Maximum size of the buffer

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    // Method for producer to add an item
    public synchronized void produce(int item) throws InterruptedException {
        // If buffer is full, wait until space is available
        while (buffer.size() == capacity) {
            System.out.println("Buffer is full. Producer is waiting...");
            wait(); // Release the lock and wait for notify
        }
        
        // Add the item to the buffer
        buffer.add(item);
        System.out.println("Produced: " + item + " | Buffer size: " + buffer.size());
        
        // Notify waiting threads (e.g., consumer) that something changed
        notifyAll();
    }

    // Method for consumer to remove an item
    public synchronized int consume() throws InterruptedException {
        // If buffer is empty, wait until an item is available
        while (buffer.isEmpty()) {
            System.out.println("Buffer is empty. Consumer is waiting...");
            wait(); // Release the lock and wait for notify
        }
        
        // Remove the first item from the buffer
        int item = buffer.removeFirst();
        System.out.println("Consumed: " + item + " | Buffer size: " + buffer.size());
        
        // Notify waiting threads (e.g., producer) that something changed
        notifyAll();
        
        return item;
    }
}