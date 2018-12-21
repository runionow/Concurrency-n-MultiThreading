package producer_consumer;

public class Producer {
    private static final int BUFFER_SIZE = 100;
    private final Object lock;
    private final int[] buffer;

    int count = 0;

    Producer(Object lock, int[] buffer) {
        this.lock = lock;
        this.buffer = buffer;
    }

    public void produce() throws InterruptedException {
        synchronized (lock) {
            if (isFull(buffer))
                lock.wait();
            buffer[count++] = 1;
            lock.notifyAll();
        }
    }

    private boolean isFull(int[] buffer) {
        return buffer.length == BUFFER_SIZE;
    }
}
