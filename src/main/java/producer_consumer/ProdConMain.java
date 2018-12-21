package producer_consumer;

/**
 * Producer and Consumer Problem
 * A consumer consumes the value
 * A producers produce the values and saves it in buffer
 * important : the buffer can be empty ore null
 * Producers and consumers are run in their own thread.
 */
public class ProdConMain {
    private static final int BUFFER_SIZE = 100;
    public static int[] buffer = new int[BUFFER_SIZE];
    public static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Producer prod = new Producer(lock, buffer);
        Consumer cons = new Consumer(lock, buffer);


        Runnable producer = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    prod.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    cons.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();


    }
}
