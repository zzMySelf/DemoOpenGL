package com.baidu.searchbox.hissug.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruHashMap<K, V> extends LinkedHashMap {
    private int cacheSize = 8;

    public void setCacheSize(int cacheSize2) {
        this.cacheSize = cacheSize2;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry eldest) {
        if (this.cacheSize + 1 == size()) {
            return true;
        }
        return false;
    }
}
