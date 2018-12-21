package cocurrency;

public class ConcurrencyMain {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Race Condition.
         * To demonstrate deadlock and synchronization.
         */

        LongWrapper l1 = new LongWrapper(0L);

        Runnable r = () -> {
            for (int i = 0; i < 1_000; i++) {
                l1.incrementValue();
            }
        };

        Thread[] t2 = new Thread[1_000];

        for (int i = 0; i < 1_000; i++) {
            t2[i] = new Thread(r);
            t2[i].start();
        }

        for (int i = 0; i < 1_000; i++) {
            t2[i].join();
        }

        System.out.println(l1.getValue());
    }
}
