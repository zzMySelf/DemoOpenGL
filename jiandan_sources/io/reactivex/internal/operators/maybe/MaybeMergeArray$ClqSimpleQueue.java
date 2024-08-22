package io.reactivex.internal.operators.maybe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.p039if.fe.de.fe;

public final class MaybeMergeArray$ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements fe<T> {
    public static final long serialVersionUID = -4025173261791142821L;
    public int consumerIndex;
    public final AtomicInteger producerIndex = new AtomicInteger();

    public int consumerIndex() {
        return this.consumerIndex;
    }

    public void drop() {
        poll();
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException();
    }

    public T poll() {
        T poll = super.poll();
        if (poll != null) {
            this.consumerIndex++;
        }
        return poll;
    }

    public int producerIndex() {
        return this.producerIndex.get();
    }

    public boolean offer(T t) {
        this.producerIndex.getAndIncrement();
        return super.offer(t);
    }
}
