package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observer;

public final class BufferUntilSubscriber$State<T> extends AtomicReference<Observer<? super T>> {
    public static final long serialVersionUID = 8026705089538090368L;
    public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();
    public boolean emitting;
    public final Object guard = new Object();

    public boolean casObserverRef(Observer<? super T> observer, Observer<? super T> observer2) {
        return compareAndSet(observer, observer2);
    }
}
