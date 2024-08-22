package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

@GwtIncompatible
public class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    public static final int ENDPOINT = -2;
    public final boolean accessOrder;
    public transient int firstEntry;
    public transient int lastEntry;
    @MonotonicNonNullDecl
    @VisibleForTesting
    public transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i2) {
        return new CompactLinkedHashMap<>(i2);
    }

    private int getPredecessor(int i2) {
        return (int) (this.links[i2] >>> 32);
    }

    private void setPredecessor(int i2, int i3) {
        long[] jArr = this.links;
        jArr[i2] = (jArr[i2] & 4294967295L) | (((long) i3) << 32);
    }

    private void setSucceeds(int i2, int i3) {
        if (i2 == -2) {
            this.firstEntry = i3;
        } else {
            setSuccessor(i2, i3);
        }
        if (i3 == -2) {
            this.lastEntry = i2;
        } else {
            setPredecessor(i3, i2);
        }
    }

    private void setSuccessor(int i2, int i3) {
        long[] jArr = this.links;
        jArr[i2] = (jArr[i2] & -4294967296L) | (((long) i3) & 4294967295L);
    }

    public void accessEntry(int i2) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i2), getSuccessor(i2));
            setSucceeds(this.lastEntry, i2);
            setSucceeds(i2, -2);
            this.modCount++;
        }
    }

    public int adjustAfterRemove(int i2, int i3) {
        return i2 >= size() ? i3 : i2;
    }

    public void allocArrays() {
        super.allocArrays();
        long[] jArr = new long[this.keys.length];
        this.links = jArr;
        Arrays.fill(jArr, -1);
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.firstEntry = -2;
            this.lastEntry = -2;
            Arrays.fill(this.links, 0, size(), -1);
            super.clear();
        }
    }

    public int firstEntryIndex() {
        return this.firstEntry;
    }

    public int getSuccessor(int i2) {
        return (int) this.links[i2];
    }

    public void init(int i2) {
        super.init(i2);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    public void insertEntry(int i2, K k, V v, int i3) {
        super.insertEntry(i2, k, v, i3);
        setSucceeds(this.lastEntry, i2);
        setSucceeds(i2, -2);
    }

    public void moveLastEntry(int i2) {
        int size = size() - 1;
        super.moveLastEntry(i2);
        setSucceeds(getPredecessor(i2), getSuccessor(i2));
        if (i2 < size) {
            setSucceeds(getPredecessor(size), i2);
            setSucceeds(i2, getSuccessor(size));
        }
        this.links[size] = -1;
    }

    public void resizeEntries(int i2) {
        super.resizeEntries(i2);
        long[] jArr = this.links;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        this.links = copyOf;
        if (length < i2) {
            Arrays.fill(copyOf, length, i2, -1);
        }
    }

    public CompactLinkedHashMap(int i2) {
        this(i2, false);
    }

    public CompactLinkedHashMap(int i2, boolean z) {
        super(i2);
        this.accessOrder = z;
    }
}
