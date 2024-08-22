package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    public static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());
    public static final long[] ZERO_CUMULATIVE_COUNTS = {0};
    public final transient long[] cumulativeCounts;
    @VisibleForTesting
    public final transient RegularImmutableSortedSet<E> elementSet;
    public final transient int length;
    public final transient int offset;

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int i2) {
        long[] jArr = this.cumulativeCounts;
        int i3 = this.offset;
        return (int) (jArr[(i3 + i2) + 1] - jArr[i3 + i2]);
    }

    public int count(@NullableDecl Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return getCount(indexOf);
        }
        return 0;
    }

    public Multiset.Entry<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    public Multiset.Entry<E> getEntry(int i2) {
        return Multisets.immutableEntry(this.elementSet.asList().get(i2), getCount(i2));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i2, int i3) {
        Preconditions.checkPositionIndexes(i2, i3, this.length);
        if (i2 == i3) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        if (i2 == 0 && i3 == this.length) {
            return this;
        }
        return new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i2, i3), this.cumulativeCounts, this.offset + i2, i3 - i2);
    }

    public boolean isPartialView() {
        return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
    }

    public Multiset.Entry<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.length - 1);
    }

    public int size() {
        long[] jArr = this.cumulativeCounts;
        int i2 = this.offset;
        return Ints.saturatedCast(jArr[this.length + i2] - jArr[i2]);
    }

    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.length);
    }

    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i2, int i3) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = jArr;
        this.offset = i2;
        this.length = i3;
    }
}
