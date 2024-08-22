package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class MapIteratorCache<K, V> {
    public final Map<K, V> backingMap;
    @NullableDecl
    public transient Map.Entry<K, V> entrySetCache;

    public MapIteratorCache(Map<K, V> map) {
        this.backingMap = (Map) Preconditions.checkNotNull(map);
    }

    public void clear() {
        clearCache();
        this.backingMap.clear();
    }

    public void clearCache() {
        this.entrySetCache = null;
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        return getIfCached(obj) != null || this.backingMap.containsKey(obj);
    }

    public V get(@NullableDecl Object obj) {
        V ifCached = getIfCached(obj);
        return ifCached != null ? ifCached : getWithoutCaching(obj);
    }

    public V getIfCached(@NullableDecl Object obj) {
        Map.Entry<K, V> entry = this.entrySetCache;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    public final V getWithoutCaching(@NullableDecl Object obj) {
        return this.backingMap.get(obj);
    }

    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        clearCache();
        return this.backingMap.put(k, v);
    }

    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        clearCache();
        return this.backingMap.remove(obj);
    }

    public final Set<K> unmodifiableKeySet() {
        return new AbstractSet<K>() {
            public boolean contains(@NullableDecl Object obj) {
                return MapIteratorCache.this.containsKey(obj);
            }

            public int size() {
                return MapIteratorCache.this.backingMap.size();
            }

            public UnmodifiableIterator<K> iterator() {
                final Iterator it = MapIteratorCache.this.backingMap.entrySet().iterator();
                return new UnmodifiableIterator<K>() {
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public K next() {
                        Map.Entry entry = (Map.Entry) it.next();
                        Map.Entry unused = MapIteratorCache.this.entrySetCache = entry;
                        return entry.getKey();
                    }
                };
            }
        };
    }
}
