package th.de.p039if.de;

import io.reactivex.internal.fuseable.QueueDisposable;

/* renamed from: th.de.if.de.ad  reason: invalid package */
public abstract class ad<T> implements QueueDisposable<T> {
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
