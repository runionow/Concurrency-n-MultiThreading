package cocurrency;

public class ConcurrencyMain {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("I am running in" + Thread.currentThread());
        };
        Thread t = new Thread(runnable);
        t.setName("Test Thread");
        t.start();
    }
}
