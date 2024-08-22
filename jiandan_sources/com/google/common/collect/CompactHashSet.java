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
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    @VisibleForTesting
    public static final int DEFAULT_SIZE = 3;
    public static final long HASH_MASK = -4294967296L;
    public static final float LOAD_FACTOR = 1.0f;
    public static final long NEXT_MASK = 4294967295L;
    public static final int UNSET = -1;
    @MonotonicNonNullDecl
    public transient Object[] elements;
    @MonotonicNonNullDecl
    public transient long[] entries;
    public transient int modCount;
    public transient int size;
    @MonotonicNonNullDecl
    public transient int[] table;

    public CompactHashSet() {
        init(3);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i2) {
        return new CompactHashSet<>(i2);
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
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
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
            objectOutputStream.writeObject(this.elements[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    @CanIgnoreReturnValue
    public boolean add(@NullableDecl E e) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        long[] jArr = this.entries;
        Object[] objArr = this.elements;
        int smearedHash = Hashing.smearedHash(e);
        int hashTableMask = hashTableMask() & smearedHash;
        int i2 = this.size;
        int[] iArr = this.table;
        int i3 = iArr[hashTableMask];
        if (i3 == -1) {
            iArr[hashTableMask] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (getHash(j) == smearedHash && Objects.equal(e, objArr[i3])) {
                    return false;
                }
                int next = getNext(j);
                if (next == -1) {
                    jArr[i3] = swapNext(j, i2);
                    break;
                }
                i3 = next;
            }
        }
        if (i2 != Integer.MAX_VALUE) {
            int i4 = i2 + 1;
            resizeMeMaybe(i4);
            insertEntry(i2, e, smearedHash);
            this.size = i4;
            int length = this.table.length;
            if (Hashing.needsResizing(i2, length, 1.0d)) {
                resizeTable(length * 2);
            }
            this.modCount++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int adjustAfterRemove(int i2, int i3) {
        return i2 - 1;
    }

    public void allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i2 = this.modCount;
        this.table = newTable(Hashing.closedTableSize(i2, 1.0d));
        this.entries = newEntries(i2);
        this.elements = new Object[i2];
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.modCount++;
            Arrays.fill(this.elements, 0, this.size, (Object) null);
            Arrays.fill(this.table, -1);
            Arrays.fill(this.entries, 0, this.size, -1);
            this.size = 0;
        }
    }

    public boolean contains(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        int smearedHash = Hashing.smearedHash(obj);
        int i2 = this.table[hashTableMask() & smearedHash];
        while (i2 != -1) {
            long j = this.entries[i2];
            if (getHash(j) == smearedHash && Objects.equal(obj, this.elements[i2])) {
                return true;
            }
            i2 = getNext(j);
        }
        return false;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public int getSuccessor(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.size) {
            return i3;
        }
        return -1;
    }

    public void init(int i2) {
        Preconditions.checkArgument(i2 >= 0, "Initial capacity must be non-negative");
        this.modCount = Math.max(1, i2);
    }

    public void insertEntry(int i2, E e, int i3) {
        this.entries[i2] = (((long) i3) << 32) | 4294967295L;
        this.elements[i2] = e;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public int currentIndex;
            public int expectedModCount;
            public int indexToRemove = -1;

            {
                CompactHashSet compactHashSet = CompactHashSet.this;
                this.expectedModCount = compactHashSet.modCount;
                this.currentIndex = compactHashSet.firstEntryIndex();
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                return this.currentIndex >= 0;
            }

            public E next() {
                checkForConcurrentModification();
                if (hasNext()) {
                    int i2 = this.currentIndex;
                    this.indexToRemove = i2;
                    CompactHashSet compactHashSet = CompactHashSet.this;
                    E e = compactHashSet.elements[i2];
                    this.currentIndex = compactHashSet.getSuccessor(i2);
                    return e;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                checkForConcurrentModification();
                CollectPreconditions.checkRemove(this.indexToRemove >= 0);
                this.expectedModCount++;
                CompactHashSet compactHashSet = CompactHashSet.this;
                boolean unused = compactHashSet.remove(compactHashSet.elements[this.indexToRemove], CompactHashSet.getHash(compactHashSet.entries[this.indexToRemove]));
                this.currentIndex = CompactHashSet.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
                this.indexToRemove = -1;
            }
        };
    }

    public void moveLastEntry(int i2) {
        int size2 = size() - 1;
        if (i2 < size2) {
            Object[] objArr = this.elements;
            objArr[i2] = objArr[size2];
            objArr[size2] = null;
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
            this.elements[i2] = null;
            this.entries[i2] = -1;
        }
    }

    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        return remove(obj, Hashing.smearedHash(obj));
    }

    public void resizeEntries(int i2) {
        this.elements = Arrays.copyOf(this.elements, i2);
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

    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        return Arrays.copyOf(this.elements, this.size);
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

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public CompactHashSet(int i2) {
        init(i2);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public boolean remove(Object obj, int i2) {
        int hashTableMask = hashTableMask() & i2;
        int i3 = this.table[hashTableMask];
        if (i3 == -1) {
            return false;
        }
        int i4 = -1;
        while (true) {
            if (getHash(this.entries[i3]) != i2 || !Objects.equal(obj, this.elements[i3])) {
                int next = getNext(this.entries[i3]);
                if (next == -1) {
                    return false;
                }
                int i5 = next;
                i4 = i3;
                i3 = i5;
            } else {
                if (i4 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i3]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i4] = swapNext(jArr[i4], getNext(jArr[i3]));
                }
                moveLastEntry(i3);
                this.size--;
                this.modCount++;
                return true;
            }
        }
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        if (!needsAllocArrays()) {
            return ObjectArrays.toArrayImpl(this.elements, 0, this.size, tArr);
        }
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
