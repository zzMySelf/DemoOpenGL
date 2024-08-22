package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@GwtCompatible(emulated = true, serializable = true)
public final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    @LazyInit
    public transient int cachedHashCode;
    public final transient E element;

    public SingletonImmutableSet(E e) {
        this.element = Preconditions.checkNotNull(e);
    }

    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    public int copyIntoArray(Object[] objArr, int i2) {
        objArr[i2] = this.element;
        return i2 + 1;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.of(this.element);
    }

    public final int hashCode() {
        int i2 = this.cachedHashCode;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.element.hashCode();
        this.cachedHashCode = hashCode;
        return hashCode;
    }

    public boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        return '[' + this.element.toString() + ']';
    }

    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public SingletonImmutableSet(E e, int i2) {
        this.element = e;
        this.cachedHashCode = i2;
    }
}
