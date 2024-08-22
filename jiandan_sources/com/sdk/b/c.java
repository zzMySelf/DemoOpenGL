package com.sdk.b;

import java.util.LinkedHashMap;
import java.util.Map;

public class c<K, V> {
    public final LinkedHashMap<K, V> a;
    public int b;
    public int c;
    public b<K, Long> d;

    public c(int i2) {
        if (i2 > 0) {
            this.c = i2;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
            this.d = new b<>(0, 0.75f);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final int a(K k, V v) {
        int b2 = b(k, v);
        if (b2 <= 0) {
            this.b = 0;
            for (Map.Entry next : this.a.entrySet()) {
                this.b = b(next.getKey(), next.getValue()) + this.b;
            }
        }
        return b2;
    }

    public final V a(K k) {
        if (k != null) {
            synchronized (this) {
                if (!this.d.containsKey(k)) {
                    b(k);
                    return null;
                }
                V v = this.a.get(k);
                if (v != null) {
                    return v;
                }
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V a(K k, V v, long j) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.b += a(k, v);
            put = this.a.put(k, v);
            this.d.put(k, Long.valueOf(j));
            if (put != null) {
                this.b -= a(k, put);
            }
        }
        a(this.c);
        return put;
    }

    public final void a(int i2) {
        while (true) {
            synchronized (this) {
                if (this.b <= i2) {
                    break;
                } else if (this.a.isEmpty()) {
                    break;
                } else {
                    Map.Entry next = this.a.entrySet().iterator().next();
                    Object key = next.getKey();
                    Object value = next.getValue();
                    this.a.remove(key);
                    this.d.remove(key);
                    this.b -= a(key, value);
                }
            }
        }
    }

    public int b(K k, V v) {
        throw null;
    }

    public final V b(K k) {
        V remove;
        if (k != null) {
            synchronized (this) {
                remove = this.a.remove(k);
                this.d.remove((Object) k);
                if (remove != null) {
                    this.b -= a(k, remove);
                }
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }
}
