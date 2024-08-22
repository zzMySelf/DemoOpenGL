package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    public static final int ABSENT = -1;
    public static final int ENDPOINT = -2;
    public transient Set<Map.Entry<K, V>> entrySet;
    @NullableDecl
    public transient int firstInInsertionOrder;
    public transient int[] hashTableKToV;
    public transient int[] hashTableVToK;
    @RetainedWith
    @MonotonicNonNullDecl
    public transient BiMap<V, K> inverse;
    public transient Set<K> keySet;
    public transient K[] keys;
    @NullableDecl
    public transient int lastInInsertionOrder;
    public transient int modCount;
    public transient int[] nextInBucketKToV;
    public transient int[] nextInBucketVToK;
    public transient int[] nextInInsertionOrder;
    public transient int[] prevInInsertionOrder;
    public transient int size;
    public transient Set<V> valueSet;
    public transient V[] values;

    public final class EntryForKey extends AbstractMapEntry<K, V> {
        public int index;
        @NullableDecl
        public final K key;

        public EntryForKey(int i2) {
            this.key = HashBiMap.this.keys[i2];
            this.index = i2;
        }

        public K getKey() {
            return this.key;
        }

        @NullableDecl
        public V getValue() {
            updateIndex();
            int i2 = this.index;
            if (i2 == -1) {
                return null;
            }
            return HashBiMap.this.values[i2];
        }

        public V setValue(V v) {
            updateIndex();
            int i2 = this.index;
            if (i2 == -1) {
                return HashBiMap.this.put(this.key, v);
            }
            V v2 = HashBiMap.this.values[i2];
            if (Objects.equal(v2, v)) {
                return v;
            }
            HashBiMap.this.replaceValueInEntry(this.index, v, false);
            return v2;
        }

        public void updateIndex() {
            int i2 = this.index;
            if (i2 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i2 <= hashBiMap.size && Objects.equal(hashBiMap.keys[i2], this.key)) {
                    return;
                }
            }
            this.index = HashBiMap.this.findEntryByKey(this.key);
        }
    }

    public static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        public final HashBiMap<K, V> biMap;
        public int index;
        public final V value;

        public EntryForValue(HashBiMap<K, V> hashBiMap, int i2) {
            this.biMap = hashBiMap;
            this.value = hashBiMap.values[i2];
            this.index = i2;
        }

        private void updateIndex() {
            int i2 = this.index;
            if (i2 != -1) {
                HashBiMap<K, V> hashBiMap = this.biMap;
                if (i2 <= hashBiMap.size && Objects.equal(this.value, hashBiMap.values[i2])) {
                    return;
                }
            }
            this.index = this.biMap.findEntryByValue(this.value);
        }

        public V getKey() {
            return this.value;
        }

        public K getValue() {
            updateIndex();
            int i2 = this.index;
            if (i2 == -1) {
                return null;
            }
            return this.biMap.keys[i2];
        }

        public K setValue(K k) {
            updateIndex();
            int i2 = this.index;
            if (i2 == -1) {
                return this.biMap.putInverse(this.value, k, false);
            }
            K k2 = this.biMap.keys[i2];
            if (Objects.equal(k2, k)) {
                return k;
            }
            this.biMap.replaceKeyInEntry(this.index, k, false);
            return k2;
        }
    }

    public final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        public EntrySet() {
            super(HashBiMap.this);
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByKey = HashBiMap.this.findEntryByKey(key);
            if (findEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            return true;
        }

        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, smearedHash);
            if (findEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }

        public Map.Entry<K, V> forEntry(int i2) {
            return new EntryForKey(i2);
        }
    }

    public static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        public final HashBiMap<K, V> forward;
        public transient Set<Map.Entry<V, K>> inverseEntrySet;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            BiMap unused = this.forward.inverse = this;
        }

        public void clear() {
            this.forward.clear();
        }

        public boolean containsKey(@NullableDecl Object obj) {
            return this.forward.containsValue(obj);
        }

        public boolean containsValue(@NullableDecl Object obj) {
            return this.forward.containsKey(obj);
        }

        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet2 = new InverseEntrySet(this.forward);
            this.inverseEntrySet = inverseEntrySet2;
            return inverseEntrySet2;
        }

        @NullableDecl
        @CanIgnoreReturnValue
        public K forcePut(@NullableDecl V v, @NullableDecl K k) {
            return this.forward.putInverse(v, k, true);
        }

        @NullableDecl
        public K get(@NullableDecl Object obj) {
            return this.forward.getInverse(obj);
        }

        public BiMap<K, V> inverse() {
            return this.forward;
        }

        public Set<V> keySet() {
            return this.forward.values();
        }

        @NullableDecl
        @CanIgnoreReturnValue
        public K put(@NullableDecl V v, @NullableDecl K k) {
            return this.forward.putInverse(v, k, false);
        }

        @NullableDecl
        @CanIgnoreReturnValue
        public K remove(@NullableDecl Object obj) {
            return this.forward.removeInverse(obj);
        }

        public int size() {
            return this.forward.size;
        }

        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    public static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        public InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByValue = this.biMap.findEntryByValue(key);
            if (findEntryByValue == -1 || !Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByValue = this.biMap.findEntryByValue(key, smearedHash);
            if (findEntryByValue == -1 || !Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                return false;
            }
            this.biMap.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }

        public Map.Entry<V, K> forEntry(int i2) {
            return new EntryForValue(this.biMap, i2);
        }
    }

    public final class KeySet extends View<K, V, K> {
        public KeySet() {
            super(HashBiMap.this);
        }

        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        public K forEntry(int i2) {
            return HashBiMap.this.keys[i2];
        }

        public boolean remove(@NullableDecl Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, smearedHash);
            if (findEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }
    }

    public final class ValueSet extends View<K, V, V> {
        public ValueSet() {
            super(HashBiMap.this);
        }

        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        public V forEntry(int i2) {
            return HashBiMap.this.values[i2];
        }

        public boolean remove(@NullableDecl Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, smearedHash);
            if (findEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }
    }

    public static abstract class View<K, V, T> extends AbstractSet<T> {
        public final HashBiMap<K, V> biMap;

        public View(HashBiMap<K, V> hashBiMap) {
            this.biMap = hashBiMap;
        }

        public void clear() {
            this.biMap.clear();
        }

        public abstract T forEntry(int i2);

        public Iterator<T> iterator() {
            return new Iterator<T>() {
                public int expectedModCount;
                public int index = View.this.biMap.firstInInsertionOrder;
                public int indexToRemove = -1;
                public int remaining;

                {
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    this.expectedModCount = hashBiMap.modCount;
                    this.remaining = hashBiMap.size;
                }

                private void checkForComodification() {
                    if (View.this.biMap.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                public boolean hasNext() {
                    checkForComodification();
                    return this.index != -2 && this.remaining > 0;
                }

                public T next() {
                    if (hasNext()) {
                        T forEntry = View.this.forEntry(this.index);
                        this.indexToRemove = this.index;
                        this.index = View.this.biMap.nextInInsertionOrder[this.index];
                        this.remaining--;
                        return forEntry;
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    checkForComodification();
                    CollectPreconditions.checkRemove(this.indexToRemove != -1);
                    View.this.biMap.removeEntry(this.indexToRemove);
                    if (this.index == View.this.biMap.size) {
                        this.index = this.indexToRemove;
                    }
                    this.indexToRemove = -1;
                    this.expectedModCount = View.this.biMap.modCount;
                }
            };
        }

        public int size() {
            return this.biMap.size;
        }
    }

    public HashBiMap(int i2) {
        init(i2);
    }

    private int bucket(int i2) {
        return i2 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static int[] createFilledWithAbsent(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i2, int i3) {
        Preconditions.checkArgument(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i2) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i4 = iArr[bucket];
        int i5 = this.nextInBucketKToV[i4];
        while (true) {
            int i6 = i5;
            int i7 = i4;
            i4 = i6;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i2]);
            } else if (i4 == i2) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i7] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i5 = this.nextInBucketKToV[i4];
            }
        }
    }

    private void deleteFromTableVToK(int i2, int i3) {
        Preconditions.checkArgument(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.hashTableVToK;
        if (iArr[bucket] == i2) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i4 = iArr[bucket];
        int i5 = this.nextInBucketVToK[i4];
        while (true) {
            int i6 = i5;
            int i7 = i4;
            i4 = i6;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i2]);
            } else if (i4 == i2) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i7] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i5 = this.nextInBucketVToK[i4];
            }
        }
    }

    private void ensureCapacity(int i2) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i2) {
            int expandedCapacity = ImmutableCollection.Builder.expandedCapacity(iArr.length, i2);
            this.keys = Arrays.copyOf(this.keys, expandedCapacity);
            this.values = Arrays.copyOf(this.values, expandedCapacity);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, expandedCapacity);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, expandedCapacity);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, expandedCapacity);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, expandedCapacity);
        }
        if (this.hashTableKToV.length < i2) {
            int closedTableSize = Hashing.closedTableSize(i2, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(closedTableSize);
            this.hashTableVToK = createFilledWithAbsent(closedTableSize);
            for (int i3 = 0; i3 < this.size; i3++) {
                int bucket = bucket(Hashing.smearedHash(this.keys[i3]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i3] = iArr3[bucket];
                iArr3[bucket] = i3;
                int bucket2 = bucket(Hashing.smearedHash(this.values[i3]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i3] = iArr5[bucket2];
                iArr5[bucket2] = i3;
            }
        }
    }

    public static int[] expandAndFillWithAbsent(int[] iArr, int i2) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i2);
        Arrays.fill(copyOf, length, i2, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i2, int i3) {
        Preconditions.checkArgument(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i2] = iArr2[bucket];
        iArr2[bucket] = i2;
    }

    private void insertIntoTableVToK(int i2, int i3) {
        Preconditions.checkArgument(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i2] = iArr2[bucket];
        iArr2[bucket] = i2;
    }

    private void moveEntryToIndex(int i2, int i3) {
        int i4;
        int i5;
        if (i2 != i3) {
            int i6 = this.prevInInsertionOrder[i2];
            int i7 = this.nextInInsertionOrder[i2];
            setSucceeds(i6, i3);
            setSucceeds(i3, i7);
            K[] kArr = this.keys;
            K k = kArr[i2];
            V[] vArr = this.values;
            V v = vArr[i2];
            kArr[i3] = k;
            vArr[i3] = v;
            int bucket = bucket(Hashing.smearedHash(k));
            int[] iArr = this.hashTableKToV;
            if (iArr[bucket] == i2) {
                iArr[bucket] = i3;
            } else {
                int i8 = iArr[bucket];
                int i9 = this.nextInBucketKToV[i8];
                while (true) {
                    int i10 = i9;
                    i5 = i8;
                    i8 = i10;
                    if (i8 == i2) {
                        break;
                    }
                    i9 = this.nextInBucketKToV[i8];
                }
                this.nextInBucketKToV[i5] = i3;
            }
            int[] iArr2 = this.nextInBucketKToV;
            iArr2[i3] = iArr2[i2];
            iArr2[i2] = -1;
            int bucket2 = bucket(Hashing.smearedHash(v));
            int[] iArr3 = this.hashTableVToK;
            if (iArr3[bucket2] == i2) {
                iArr3[bucket2] = i3;
            } else {
                int i11 = iArr3[bucket2];
                int i12 = this.nextInBucketVToK[i11];
                while (true) {
                    int i13 = i12;
                    i4 = i11;
                    i11 = i13;
                    if (i11 == i2) {
                        break;
                    }
                    i12 = this.nextInBucketVToK[i11];
                }
                this.nextInBucketVToK[i4] = i3;
            }
            int[] iArr4 = this.nextInBucketVToK;
            iArr4[i3] = iArr4[i2];
            iArr4[i2] = -1;
        }
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(16);
        Serialization.populateMap(this, objectInputStream, readCount);
    }

    /* access modifiers changed from: private */
    public void replaceKeyInEntry(int i2, @NullableDecl K k, boolean z) {
        Preconditions.checkArgument(i2 != -1);
        int smearedHash = Hashing.smearedHash(k);
        int findEntryByKey = findEntryByKey(k, smearedHash);
        int i3 = this.lastInInsertionOrder;
        int i4 = -2;
        if (findEntryByKey != -1) {
            if (z) {
                i3 = this.prevInInsertionOrder[findEntryByKey];
                i4 = this.nextInInsertionOrder[findEntryByKey];
                removeEntryKeyHashKnown(findEntryByKey, smearedHash);
                if (i2 == this.size) {
                    i2 = findEntryByKey;
                }
            } else {
                throw new IllegalArgumentException("Key already present in map: " + k);
            }
        }
        if (i3 == i2) {
            i3 = this.prevInInsertionOrder[i2];
        } else if (i3 == this.size) {
            i3 = findEntryByKey;
        }
        if (i4 == i2) {
            findEntryByKey = this.nextInInsertionOrder[i2];
        } else if (i4 != this.size) {
            findEntryByKey = i4;
        }
        setSucceeds(this.prevInInsertionOrder[i2], this.nextInInsertionOrder[i2]);
        deleteFromTableKToV(i2, Hashing.smearedHash(this.keys[i2]));
        this.keys[i2] = k;
        insertIntoTableKToV(i2, Hashing.smearedHash(k));
        setSucceeds(i3, i2);
        setSucceeds(i2, findEntryByKey);
    }

    /* access modifiers changed from: private */
    public void replaceValueInEntry(int i2, @NullableDecl V v, boolean z) {
        Preconditions.checkArgument(i2 != -1);
        int smearedHash = Hashing.smearedHash(v);
        int findEntryByValue = findEntryByValue(v, smearedHash);
        if (findEntryByValue != -1) {
            if (z) {
                removeEntryValueHashKnown(findEntryByValue, smearedHash);
                if (i2 == this.size) {
                    i2 = findEntryByValue;
                }
            } else {
                throw new IllegalArgumentException("Value already present in map: " + v);
            }
        }
        deleteFromTableVToK(i2, Hashing.smearedHash(this.values[i2]));
        this.values[i2] = v;
        insertIntoTableVToK(i2, smearedHash);
    }

    private void setSucceeds(int i2, int i3) {
        if (i2 == -2) {
            this.firstInInsertionOrder = i3;
        } else {
            this.nextInInsertionOrder[i2] = i3;
        }
        if (i3 == -2) {
            this.lastInInsertionOrder = i2;
        } else {
            this.prevInInsertionOrder[i3] = i2;
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return findEntryByKey(obj) != -1;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return findEntryByValue(obj) != -1;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public int findEntry(@NullableDecl Object obj, int i2, int[] iArr, int[] iArr2, Object[] objArr) {
        int i3 = iArr[bucket(i2)];
        while (i3 != -1) {
            if (Objects.equal(objArr[i3], obj)) {
                return i3;
            }
            i3 = iArr2[i3];
        }
        return -1;
    }

    public int findEntryByKey(@NullableDecl Object obj) {
        return findEntryByKey(obj, Hashing.smearedHash(obj));
    }

    public int findEntryByValue(@NullableDecl Object obj) {
        return findEntryByValue(obj, Hashing.smearedHash(obj));
    }

    @NullableDecl
    @CanIgnoreReturnValue
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, true);
    }

    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @NullableDecl
    public K getInverse(@NullableDecl Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    public void init(int i2) {
        CollectPreconditions.checkNonnegative(i2, "expectedSize");
        int closedTableSize = Hashing.closedTableSize(i2, 1.0d);
        this.size = 0;
        this.keys = new Object[i2];
        this.values = new Object[i2];
        this.hashTableKToV = createFilledWithAbsent(closedTableSize);
        this.hashTableVToK = createFilledWithAbsent(closedTableSize);
        this.nextInBucketKToV = createFilledWithAbsent(i2);
        this.nextInBucketVToK = createFilledWithAbsent(i2);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i2);
        this.nextInInsertionOrder = createFilledWithAbsent(i2);
    }

    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse2 = new Inverse(this);
        this.inverse = inverse2;
        return inverse2;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, false);
    }

    @NullableDecl
    public K putInverse(@NullableDecl V v, @NullableDecl K k, boolean z) {
        int smearedHash = Hashing.smearedHash(v);
        int findEntryByValue = findEntryByValue(v, smearedHash);
        if (findEntryByValue != -1) {
            K k2 = this.keys[findEntryByValue];
            if (Objects.equal(k2, k)) {
                return k;
            }
            replaceKeyInEntry(findEntryByValue, k, z);
            return k2;
        }
        int i2 = this.lastInInsertionOrder;
        int smearedHash2 = Hashing.smearedHash(k);
        int findEntryByKey = findEntryByKey(k, smearedHash2);
        if (!z) {
            Preconditions.checkArgument(findEntryByKey == -1, "Key already present: %s", (Object) k);
        } else if (findEntryByKey != -1) {
            i2 = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i3 = this.size;
        kArr[i3] = k;
        this.values[i3] = v;
        insertIntoTableKToV(i3, smearedHash2);
        insertIntoTableVToK(this.size, smearedHash);
        int i4 = i2 == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i2];
        setSucceeds(i2, this.size);
        setSucceeds(this.size, i4);
        this.size++;
        this.modCount++;
        return null;
    }

    @NullableDecl
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByKey = findEntryByKey(obj, smearedHash);
        if (findEntryByKey == -1) {
            return null;
        }
        V v = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, smearedHash);
        return v;
    }

    public void removeEntry(int i2) {
        removeEntryKeyHashKnown(i2, Hashing.smearedHash(this.keys[i2]));
    }

    public void removeEntryKeyHashKnown(int i2, int i3) {
        removeEntry(i2, i3, Hashing.smearedHash(this.values[i2]));
    }

    public void removeEntryValueHashKnown(int i2, int i3) {
        removeEntry(i2, Hashing.smearedHash(this.keys[i2]), i3);
    }

    @NullableDecl
    public K removeInverse(@NullableDecl Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByValue = findEntryByValue(obj, smearedHash);
        if (findEntryByValue == -1) {
            return null;
        }
        K k = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, smearedHash);
        return k;
    }

    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i2) {
        return new HashBiMap<>(i2);
    }

    private void removeEntry(int i2, int i3, int i4) {
        Preconditions.checkArgument(i2 != -1);
        deleteFromTableKToV(i2, i3);
        deleteFromTableVToK(i2, i4);
        setSucceeds(this.prevInInsertionOrder[i2], this.nextInInsertionOrder[i2]);
        moveEntryToIndex(this.size - 1, i2);
        K[] kArr = this.keys;
        int i5 = this.size;
        kArr[i5 - 1] = null;
        this.values[i5 - 1] = null;
        this.size = i5 - 1;
        this.modCount++;
    }

    public int findEntryByKey(@NullableDecl Object obj, int i2) {
        return findEntry(obj, i2, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(@NullableDecl Object obj, int i2) {
        return findEntry(obj, i2, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @NullableDecl
    public V put(@NullableDecl K k, @NullableDecl V v, boolean z) {
        int smearedHash = Hashing.smearedHash(k);
        int findEntryByKey = findEntryByKey(k, smearedHash);
        if (findEntryByKey != -1) {
            V v2 = this.values[findEntryByKey];
            if (Objects.equal(v2, v)) {
                return v;
            }
            replaceValueInEntry(findEntryByKey, v, z);
            return v2;
        }
        int smearedHash2 = Hashing.smearedHash(v);
        int findEntryByValue = findEntryByValue(v, smearedHash2);
        if (!z) {
            Preconditions.checkArgument(findEntryByValue == -1, "Value already present: %s", (Object) v);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i2 = this.size;
        kArr[i2] = k;
        this.values[i2] = v;
        insertIntoTableKToV(i2, smearedHash);
        insertIntoTableVToK(this.size, smearedHash2);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet2 = new ValueSet();
        this.valueSet = valueSet2;
        return valueSet2;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
