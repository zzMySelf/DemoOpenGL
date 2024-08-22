package io.reactivex.internal.observers;

public interface InnerQueuedObserverSupport<T> {
    void drain();

    void innerComplete(InnerQueuedObserver<T> innerQueuedObserver);

    void innerError(InnerQueuedObserver<T> innerQueuedObserver, Throwable th2);

    void innerNext(InnerQueuedObserver<T> innerQueuedObserver, T t);
}
