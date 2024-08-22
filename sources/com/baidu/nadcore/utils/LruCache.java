package com.baidu.nadcore.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private static final int DEFAULT_CACHE_SIZE = 32;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final int mMaxCacheSize;

    public LruCache() {
        super((int) (Math.ceil(42.66666793823242d) + 1.0d), 0.75f, true);
        this.mMaxCacheSize = 32;
    }

    public LruCache(int cacheSize) {
        super((int) (Math.ceil((double) (((float) cacheSize) / 0.75f)) + 1.0d), 0.75f, true);
        this.mMaxCacheSize = cacheSize;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.mMaxCacheSize;
    }
}
