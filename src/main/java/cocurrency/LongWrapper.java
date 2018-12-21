package cocurrency;

public class LongWrapper {
    Object key = new Object();
    private long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        return this.l;
    }

    public synchronized void incrementValue() {
        this.l = this.l + 1;
    }
}
