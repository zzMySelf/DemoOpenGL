package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

@GwtIncompatible
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
    public V apply(K k) {
        return delegate().apply(k);
    }

    public abstract LoadingCache<K, V> delegate();

    public V get(K k) throws ExecutionException {
        return delegate().get(k);
    }

    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        return delegate().getAll(iterable);
    }

    public V getUnchecked(K k) {
        return delegate().getUnchecked(k);
    }

    public void refresh(K k) {
        delegate().refresh(k);
    }

    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        public final LoadingCache<K, V> delegate;

        public SimpleForwardingLoadingCache(LoadingCache<K, V> loadingCache) {
            this.delegate = (LoadingCache) Preconditions.checkNotNull(loadingCache);
        }

        public final LoadingCache<K, V> delegate() {
            return this.delegate;
        }
    }
}
