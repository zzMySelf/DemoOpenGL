package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    public final AtomicReference<T> reference = new AtomicReference<>();

    public T get() throws ConcurrentException {
        T t = this.reference.get();
        if (t != null) {
            return t;
        }
        T initialize = initialize();
        return !this.reference.compareAndSet((Object) null, initialize) ? this.reference.get() : initialize;
    }

    public abstract T initialize() throws ConcurrentException;
}
