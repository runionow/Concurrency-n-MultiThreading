package producer_consumer;

public class Consumer {
    private static final int BUFFER_SIZE = 100;
    private final Object lock;
    private final int[] buffer;

    int count = 0;

    Consumer(Object lock, int[] buffer) {
        this.lock = lock;
        this.buffer = buffer;
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            if (isEmpty(buffer))
                lock.wait();
            buffer[--count] = 0;
            lock.notifyAll();
        }
    }

    private boolean isEmpty(int[] buffer) {
        return buffer.length == 0;
    }
}
