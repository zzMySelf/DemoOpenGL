package th.de.p039if.fe.de;

import io.reactivex.internal.fuseable.SimpleQueue;

/* renamed from: th.de.if.fe.de.fe  reason: invalid package */
public interface fe<T> extends SimpleQueue<T> {
    int consumerIndex();

    void drop();

    T peek();

    T poll();

    int producerIndex();
}
