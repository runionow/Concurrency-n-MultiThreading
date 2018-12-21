package dead_clock;

public class DeadlockMain {
    public static void main(String[] args) throws InterruptedException {
        DeadLock dk = new DeadLock();


        Runnable r1 = () -> dk.a();
        Runnable r2 = () -> dk.b();


        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
