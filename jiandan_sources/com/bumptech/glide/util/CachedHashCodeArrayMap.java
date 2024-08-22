package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: ad  reason: collision with root package name */
    public int f3761ad;

    public void clear() {
        this.f3761ad = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.f3761ad == 0) {
            this.f3761ad = super.hashCode();
        }
        return this.f3761ad;
    }

    public V put(K k, V v) {
        this.f3761ad = 0;
        return super.put(k, v);
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f3761ad = 0;
        super.putAll(simpleArrayMap);
    }

    public V removeAt(int i2) {
        this.f3761ad = 0;
        return super.removeAt(i2);
    }

    public V setValueAt(int i2, V v) {
        this.f3761ad = 0;
        return super.setValueAt(i2, v);
    }
}
