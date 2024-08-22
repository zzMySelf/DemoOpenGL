package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class CallableBackgroundInitializer<T> extends BackgroundInitializer<T> {
    public final Callable<T> callable;

    public CallableBackgroundInitializer(Callable<T> callable2) {
        checkCallable(callable2);
        this.callable = callable2;
    }

    private void checkCallable(Callable<T> callable2) {
        if (callable2 == null) {
            throw new IllegalArgumentException("Callable must not be null!");
        }
    }

    public T initialize() throws Exception {
        return this.callable.call();
    }

    public CallableBackgroundInitializer(Callable<T> callable2, ExecutorService executorService) {
        super(executorService);
        checkCallable(callable2);
        this.callable = callable2;
    }
}
