package com.dxmbumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: ad  reason: collision with root package name */
    public int f3947ad;

    public void clear() {
        this.f3947ad = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.f3947ad == 0) {
            this.f3947ad = super.hashCode();
        }
        return this.f3947ad;
    }

    public V put(K k, V v) {
        this.f3947ad = 0;
        return super.put(k, v);
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f3947ad = 0;
        super.putAll(simpleArrayMap);
    }

    public V removeAt(int i2) {
        this.f3947ad = 0;
        return super.removeAt(i2);
    }

    public V setValueAt(int i2, V v) {
        this.f3947ad = 0;
        return super.setValueAt(i2, v);
    }
}
