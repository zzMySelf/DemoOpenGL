package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.RegularImmutableMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true, serializable = true)
public final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    public static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();
    @VisibleForTesting
    public final transient Object[] alternatingKeysAndValues;
    public final transient RegularImmutableBiMap<V, K> inverse;
    public final transient Object keyHashTable;
    public final transient int keyOffset;
    public final transient int size;

    public RegularImmutableBiMap() {
        this.keyHashTable = null;
        this.alternatingKeysAndValues = new Object[0];
        this.keyOffset = 0;
        this.size = 0;
        this.inverse = this;
    }

    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.keyOffset, this.size);
    }

    public ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.keyOffset, this.size));
    }

    public V get(@NullableDecl Object obj) {
        return RegularImmutableMap.get(this.keyHashTable, this.alternatingKeysAndValues, this.size, this.keyOffset, obj);
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }

    public ImmutableBiMap<V, K> inverse() {
        return this.inverse;
    }

    public RegularImmutableBiMap(Object[] objArr, int i2) {
        this.alternatingKeysAndValues = objArr;
        this.size = i2;
        this.keyOffset = 0;
        int chooseTableSize = i2 >= 2 ? ImmutableSet.chooseTableSize(i2) : 0;
        this.keyHashTable = RegularImmutableMap.createHashTable(objArr, i2, chooseTableSize, 0);
        this.inverse = new RegularImmutableBiMap<>(RegularImmutableMap.createHashTable(objArr, i2, chooseTableSize, 1), objArr, i2, this);
    }

    public RegularImmutableBiMap(Object obj, Object[] objArr, int i2, RegularImmutableBiMap<V, K> regularImmutableBiMap) {
        this.keyHashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.keyOffset = 1;
        this.size = i2;
        this.inverse = regularImmutableBiMap;
    }
}
