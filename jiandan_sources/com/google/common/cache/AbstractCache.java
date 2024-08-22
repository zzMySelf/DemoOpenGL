package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@GwtCompatible
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    public static final class SimpleStatsCounter implements StatsCounter {
        public final LongAddable evictionCount = LongAddables.create();
        public final LongAddable hitCount = LongAddables.create();
        public final LongAddable loadExceptionCount = LongAddables.create();
        public final LongAddable loadSuccessCount = LongAddables.create();
        public final LongAddable missCount = LongAddables.create();
        public final LongAddable totalLoadTime = LongAddables.create();

        public static long negativeToMaxValue(long j) {
            if (j >= 0) {
                return j;
            }
            return Long.MAX_VALUE;
        }

        public void incrementBy(StatsCounter statsCounter) {
            CacheStats snapshot = statsCounter.snapshot();
            this.hitCount.add(snapshot.hitCount());
            this.missCount.add(snapshot.missCount());
            this.loadSuccessCount.add(snapshot.loadSuccessCount());
            this.loadExceptionCount.add(snapshot.loadExceptionCount());
            this.totalLoadTime.add(snapshot.totalLoadTime());
            this.evictionCount.add(snapshot.evictionCount());
        }

        public void recordEviction() {
            this.evictionCount.increment();
        }

        public void recordHits(int i2) {
            this.hitCount.add((long) i2);
        }

        public void recordLoadException(long j) {
            this.loadExceptionCount.increment();
            this.totalLoadTime.add(j);
        }

        public void recordLoadSuccess(long j) {
            this.loadSuccessCount.increment();
            this.totalLoadTime.add(j);
        }

        public void recordMisses(int i2) {
            this.missCount.add((long) i2);
        }

        public CacheStats snapshot() {
            return new CacheStats(negativeToMaxValue(this.hitCount.sum()), negativeToMaxValue(this.missCount.sum()), negativeToMaxValue(this.loadSuccessCount.sum()), negativeToMaxValue(this.loadExceptionCount.sum()), negativeToMaxValue(this.totalLoadTime.sum()), negativeToMaxValue(this.evictionCount.sum()));
        }
    }

    public interface StatsCounter {
        void recordEviction();

        void recordHits(int i2);

        void recordLoadException(long j);

        void recordLoadSuccess(long j);

        void recordMisses(int i2);

        CacheStats snapshot();
    }

    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    public void cleanUp() {
    }

    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        Object ifPresent;
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        for (Object next : iterable) {
            if (!newLinkedHashMap.containsKey(next) && (ifPresent = getIfPresent(next)) != null) {
                newLinkedHashMap.put(next, ifPresent);
            }
        }
        return ImmutableMap.copyOf(newLinkedHashMap);
    }

    public void invalidate(Object obj) {
        throw new UnsupportedOperationException();
    }

    public void invalidateAll(Iterable<?> iterable) {
        for (Object invalidate : iterable) {
            invalidate(invalidate);
        }
    }

    public void put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public long size() {
        throw new UnsupportedOperationException();
    }

    public CacheStats stats() {
        throw new UnsupportedOperationException();
    }

    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }
}
