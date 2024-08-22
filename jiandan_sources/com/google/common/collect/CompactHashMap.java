package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final int DEFAULT_SIZE = 3;
    public static final long HASH_MASK = -4294967296L;
    public static final float LOAD_FACTOR = 1.0f;
    public static final long NEXT_MASK = 4294967295L;
    public static final int UNSET = -1;
    @MonotonicNonNullDecl
    @VisibleForTesting
    public transient long[] entries;
    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> entrySetView;
    @MonotonicNonNullDecl
    public transient Set<K> keySetView;
    @MonotonicNonNullDecl
    @VisibleForTesting
    public transient Object[] keys;
    public transient int modCount;
    public transient int size;
    @MonotonicNonNullDecl
    public transient int[] table;
    @MonotonicNonNullDecl
    @VisibleForTesting
    public transient Object[] values;
    @MonotonicNonNullDecl
    public transient Collection<V> valuesView;

    public class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        public EntrySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int access$200 = CompactHashMap.this.indexOf(entry.getKey());
            if (access$200 == -1 || !Objects.equal(CompactHashMap.this.values[access$200], entry.getValue())) {
                return false;
            }
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int access$200 = CompactHashMap.this.indexOf(entry.getKey());
            if (access$200 == -1 || !Objects.equal(CompactHashMap.this.values[access$200], entry.getValue())) {
                return false;
            }
            Object unused = CompactHashMap.this.removeEntry(access$200);
            return true;
        }

        public int size() {
            return CompactHashMap.this.size;
        }
    }

    public abstract class Itr<T> implements Iterator<T> {
        public int currentIndex;
        public int expectedModCount;
        public int indexToRemove;

        public Itr() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            this.expectedModCount = compactHashMap.modCount;
            this.currentIndex = compactHashMap.firstEntryIndex();
            this.indexToRemove = -1;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T getOutput(int i2);

        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        public T next() {
            checkForConcurrentModification();
            if (hasNext()) {
                int i2 = this.currentIndex;
                this.indexToRemove = i2;
                T output = getOutput(i2);
                this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
                return output;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            this.expectedModCount++;
            Object unused = CompactHashMap.this.removeEntry(this.indexToRemove);
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }
    }

    public class KeySetView extends AbstractSet<K> {
        public KeySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        public boolean remove(@NullableDecl Object obj) {
            int access$200 = CompactHashMap.this.indexOf(obj);
            if (access$200 == -1) {
                return false;
            }
            Object unused = CompactHashMap.this.removeEntry(access$200);
            return true;
        }

        public int size() {
            return CompactHashMap.this.size;
        }
    }

    public final class MapEntry extends AbstractMapEntry<K, V> {
        @NullableDecl
        public final K key;
        public int lastKnownIndex;

        public MapEntry(int i2) {
            this.key = CompactHashMap.this.keys[i2];
            this.lastKnownIndex = i2;
        }

        private void updateLastKnownIndex() {
            int i2 = this.lastKnownIndex;
            if (i2 == -1 || i2 >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            updateLastKnownIndex();
            int i2 = this.lastKnownIndex;
            if (i2 == -1) {
                return null;
            }
            return CompactHashMap.this.values[i2];
        }

        public V setValue(V v) {
            updateLastKnownIndex();
            int i2 = this.lastKnownIndex;
            if (i2 == -1) {
                CompactHashMap.this.put(this.key, v);
                return null;
            }
            V[] vArr = CompactHashMap.this.values;
            V v2 = vArr[i2];
            vArr[i2] = v;
            return v2;
        }
    }

    public class ValuesView extends AbstractCollection<V> {
        public ValuesView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        public int size() {
            return CompactHashMap.this.size;
        }
    }

    public CompactHashMap() {
        init(3);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i2) {
        return new CompactHashMap<>(i2);
    }

    public static int getHash(long j) {
        return (int) (j >>> 32);
    }

    public static int getNext(long j) {
        return (int) j;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    /* access modifiers changed from: private */
    public int indexOf(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int smearedHash = Hashing.smearedHash(obj);
        int i2 = this.table[hashTableMask() & smearedHash];
        while (i2 != -1) {
            long j = this.entries[i2];
            if (getHash(j) == smearedHash && Objects.equal(obj, this.keys[i2])) {
                return i2;
            }
            i2 = getNext(j);
        }
        return -1;
    }

    public static long[] newEntries(int i2) {
        long[] jArr = new long[i2];
        Arrays.fill(jArr, -1);
        return jArr;
    }

    public static int[] newTable(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V removeEntry(int i2) {
        return remove(this.keys[i2], getHash(this.entries[i2]));
    }

    private void resizeMeMaybe(int i2) {
        int length = this.entries.length;
        if (i2 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void resizeTable(int i2) {
        int[] newTable = newTable(i2);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            int hash = getHash(jArr[i3]);
            int i4 = hash & length;
            int i5 = newTable[i4];
            newTable[i4] = i3;
            jArr[i3] = (((long) hash) << 32) | (((long) i5) & 4294967295L);
        }
        this.table = newTable;
    }

    public static long swapNext(long j, int i2) {
        return (j & -4294967296L) | (((long) i2) & 4294967295L);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            objectOutputStream.writeObject(this.keys[firstEntryIndex]);
            objectOutputStream.writeObject(this.values[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    public void accessEntry(int i2) {
    }

    public int adjustAfterRemove(int i2, int i3) {
        return i2 - 1;
    }

    public void allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i2 = this.modCount;
        this.table = newTable(Hashing.closedTableSize(i2, 1.0d));
        this.entries = newEntries(i2);
        this.keys = new Object[i2];
        this.values = new Object[i2];
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.modCount++;
            Arrays.fill(this.keys, 0, this.size, (Object) null);
            Arrays.fill(this.values, 0, this.size, (Object) null);
            Arrays.fill(this.table, -1);
            Arrays.fill(this.entries, 0, this.size, -1);
            this.size = 0;
        }
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        for (int i2 = 0; i2 < this.size; i2++) {
            if (Objects.equal(obj, this.values[i2])) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    public Set<K> createKeySet() {
        return new KeySetView();
    }

    public Collection<V> createValues() {
        return new ValuesView();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() {
            public Map.Entry<K, V> getOutput(int i2) {
                return new MapEntry(i2);
            }
        };
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public V get(@NullableDecl Object obj) {
        int indexOf = indexOf(obj);
        accessEntry(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return this.values[indexOf];
    }

    public int getSuccessor(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.size) {
            return i3;
        }
        return -1;
    }

    public void init(int i2) {
        Preconditions.checkArgument(i2 >= 0, "Expected size must be non-negative");
        this.modCount = Math.max(1, i2);
    }

    public void insertEntry(int i2, @NullableDecl K k, @NullableDecl V v, int i3) {
        this.entries[i2] = (((long) i3) << 32) | 4294967295L;
        this.keys[i2] = k;
        this.values[i2] = v;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    public Iterator<K> keySetIterator() {
        return new CompactHashMap<K, V>.Itr<K>() {
            public K getOutput(int i2) {
                return CompactHashMap.this.keys[i2];
            }
        };
    }

    public void moveLastEntry(int i2) {
        int size2 = size() - 1;
        if (i2 < size2) {
            Object[] objArr = this.keys;
            objArr[i2] = objArr[size2];
            Object[] objArr2 = this.values;
            objArr2[i2] = objArr2[size2];
            objArr[size2] = null;
            objArr2[size2] = null;
            long[] jArr = this.entries;
            long j = jArr[size2];
            jArr[i2] = j;
            jArr[size2] = -1;
            int hash = getHash(j) & hashTableMask();
            int[] iArr = this.table;
            int i3 = iArr[hash];
            if (i3 == size2) {
                iArr[hash] = i2;
                return;
            }
            while (true) {
                long j2 = this.entries[i3];
                int next = getNext(j2);
                if (next == size2) {
                    this.entries[i3] = swapNext(j2, i2);
                    return;
                }
                i3 = next;
            }
        } else {
            this.keys[i2] = null;
            this.values[i2] = null;
            this.entries[i2] = -1;
        }
    }

    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @NullableDecl
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        V[] vArr = this.values;
        int smearedHash = Hashing.smearedHash(k);
        int hashTableMask = hashTableMask() & smearedHash;
        int i2 = this.size;
        int[] iArr = this.table;
        int i3 = iArr[hashTableMask];
        if (i3 == -1) {
            iArr[hashTableMask] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (getHash(j) != smearedHash || !Objects.equal(k, objArr[i3])) {
                    int next = getNext(j);
                    if (next == -1) {
                        jArr[i3] = swapNext(j, i2);
                        break;
                    }
                    i3 = next;
                } else {
                    V v2 = vArr[i3];
                    vArr[i3] = v;
                    accessEntry(i3);
                    return v2;
                }
            }
        }
        if (i2 != Integer.MAX_VALUE) {
            int i4 = i2 + 1;
            resizeMeMaybe(i4);
            insertEntry(i2, k, v, smearedHash);
            this.size = i4;
            int length = this.table.length;
            if (Hashing.needsResizing(i2, length, 1.0d)) {
                resizeTable(length * 2);
            }
            this.modCount++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @NullableDecl
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return null;
        }
        return remove(obj, Hashing.smearedHash(obj));
    }

    public void resizeEntries(int i2) {
        this.keys = Arrays.copyOf(this.keys, i2);
        this.values = Arrays.copyOf(this.values, i2);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        if (i2 > length) {
            Arrays.fill(copyOf, length, i2, -1);
        }
        this.entries = copyOf;
    }

    public int size() {
        return this.size;
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
            int i2 = this.size;
            if (i2 < this.entries.length) {
                resizeEntries(i2);
            }
            int closedTableSize = Hashing.closedTableSize(i2, 1.0d);
            if (closedTableSize < this.table.length) {
                resizeTable(closedTableSize);
            }
        }
    }

    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    public Iterator<V> valuesIterator() {
        return new CompactHashMap<K, V>.Itr<V>() {
            public V getOutput(int i2) {
                return CompactHashMap.this.values[i2];
            }
        };
    }

    public CompactHashMap(int i2) {
        init(i2);
    }

    @NullableDecl
    private V remove(@NullableDecl Object obj, int i2) {
        int hashTableMask = hashTableMask() & i2;
        int i3 = this.table[hashTableMask];
        if (i3 == -1) {
            return null;
        }
        int i4 = -1;
        while (true) {
            if (getHash(this.entries[i3]) != i2 || !Objects.equal(obj, this.keys[i3])) {
                int next = getNext(this.entries[i3]);
                if (next == -1) {
                    return null;
                }
                int i5 = next;
                i4 = i3;
                i3 = i5;
            } else {
                V v = this.values[i3];
                if (i4 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i3]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i4] = swapNext(jArr[i4], getNext(jArr[i3]));
                }
                moveLastEntry(i3);
                this.size--;
                this.modCount++;
                return v;
            }
        }
    }
}
