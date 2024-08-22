package io.reactivex.internal.operators.parallel;

import java.util.concurrent.atomic.AtomicInteger;

public final class ParallelReduceFull$SlotPair<T> extends AtomicInteger {
    public static final long serialVersionUID = 473971317683868662L;
    public T first;
    public final AtomicInteger releaseIndex = new AtomicInteger();
    public T second;

    public boolean releaseSlot() {
        return this.releaseIndex.incrementAndGet() == 2;
    }

    public int tryAcquireSlot() {
        int i2;
        do {
            i2 = get();
            if (i2 >= 2) {
                return -1;
            }
        } while (!compareAndSet(i2, i2 + 1));
        return i2;
    }
}
