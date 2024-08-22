package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;

@GwtCompatible
@CanIgnoreReturnValue
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
    public void addListener(Runnable runnable, Executor executor) {
        delegate().addListener(runnable, executor);
    }

    public abstract ListenableFuture<? extends V> delegate();

    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
        public final ListenableFuture<V> delegate;

        public SimpleForwardingListenableFuture(ListenableFuture<V> listenableFuture) {
            this.delegate = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        }

        public final ListenableFuture<V> delegate() {
            return this.delegate;
        }
    }
}
