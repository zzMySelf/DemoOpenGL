package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
public final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    public final transient ImmutableSortedMultiset<E> forward;

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.forward = immutableSortedMultiset;
    }

    public int count(@NullableDecl Object obj) {
        return this.forward.count(obj);
    }

    public Multiset.Entry<E> firstEntry() {
        return this.forward.lastEntry();
    }

    public Multiset.Entry<E> getEntry(int i2) {
        return this.forward.entrySet().asList().reverse().get(i2);
    }

    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    public Multiset.Entry<E> lastEntry() {
        return this.forward.firstEntry();
    }

    public int size() {
        return this.forward.size();
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.forward;
    }

    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return this.forward.tailMultiset(e, boundType).descendingMultiset();
    }

    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return this.forward.headMultiset(e, boundType).descendingMultiset();
    }

    public ImmutableSortedSet<E> elementSet() {
        return this.forward.elementSet().descendingSet();
    }
}
