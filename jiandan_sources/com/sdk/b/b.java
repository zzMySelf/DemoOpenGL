package com.sdk.b;

import java.util.concurrent.ConcurrentHashMap;

public class b<K, V> extends ConcurrentHashMap<K, Long> {
    public static final long serialVersionUID = 5514969596535320724L;

    public b(int i2, float f) {
        super(i2, f, 16);
    }

    /* renamed from: a */
    public synchronized Long put(K k, Long l) {
        if (containsKey(k)) {
            remove((Object) k);
        }
        return (Long) super.put(k, l);
    }

    public synchronized void clear() {
        super.clear();
    }

    public synchronized boolean containsKey(Object obj) {
        boolean z;
        z = false;
        Long l = (Long) super.get(obj);
        if (l == null || System.currentTimeMillis() >= l.longValue()) {
            remove(obj);
        } else {
            z = true;
        }
        return z;
    }

    public synchronized Long get(Object obj) {
        if (!containsKey(obj)) {
            return null;
        }
        return (Long) super.get(obj);
    }

    public synchronized Long remove(Object obj) {
        return (Long) super.remove(obj);
    }
}
