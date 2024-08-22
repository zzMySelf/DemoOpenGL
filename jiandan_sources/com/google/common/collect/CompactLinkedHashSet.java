package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

@GwtIncompatible
public class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    public static final int ENDPOINT = -2;
    public transient int firstEntry;
    public transient int lastEntry;
    @MonotonicNonNullDecl
    public transient int[] predecessor;
    @MonotonicNonNullDecl
    public transient int[] successor;

    public CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i2) {
        return new CompactLinkedHashSet<>(i2);
    }

    private int getPredecessor(int i2) {
        return this.predecessor[i2];
    }

    private void setPredecessor(int i2, int i3) {
        this.predecessor[i2] = i3;
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
        this.successor[i2] = i3;
    }

    public int adjustAfterRemove(int i2, int i3) {
        return i2 >= size() ? i3 : i2;
    }

    public void allocArrays() {
        super.allocArrays();
        int length = this.elements.length;
        int[] iArr = new int[length];
        this.predecessor = iArr;
        this.successor = new int[length];
        Arrays.fill(iArr, -1);
        Arrays.fill(this.successor, -1);
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.firstEntry = -2;
            this.lastEntry = -2;
            Arrays.fill(this.predecessor, 0, size(), -1);
            Arrays.fill(this.successor, 0, size(), -1);
            super.clear();
        }
    }

    public int firstEntryIndex() {
        return this.firstEntry;
    }

    public int getSuccessor(int i2) {
        return this.successor[i2];
    }

    public void init(int i2) {
        super.init(i2);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    public void insertEntry(int i2, E e, int i3) {
        super.insertEntry(i2, e, i3);
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
        this.predecessor[size] = -1;
        this.successor[size] = -1;
    }

    public void resizeEntries(int i2) {
        super.resizeEntries(i2);
        int[] iArr = this.predecessor;
        int length = iArr.length;
        this.predecessor = Arrays.copyOf(iArr, i2);
        this.successor = Arrays.copyOf(this.successor, i2);
        if (length < i2) {
            Arrays.fill(this.predecessor, length, i2, -1);
            Arrays.fill(this.successor, length, i2, -1);
        }
    }

    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    public CompactLinkedHashSet(int i2) {
        super(i2);
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public <T> T[] toArray(T[] tArr) {
        return ObjectArrays.toArrayImpl(this, tArr);
    }

    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
