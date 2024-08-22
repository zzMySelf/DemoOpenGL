package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
    public int position;
    public final int size;

    public AbstractIndexedListIterator(int i2) {
        this(i2, 0);
    }

    public abstract E get(int i2);

    public final boolean hasNext() {
        return this.position < this.size;
    }

    public final boolean hasPrevious() {
        return this.position > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i2 = this.position;
            this.position = i2 + 1;
            return get(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.position;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.position - 1;
            this.position = i2;
            return get(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.position - 1;
    }

    public AbstractIndexedListIterator(int i2, int i3) {
        Preconditions.checkPositionIndex(i3, i2);
        this.size = i2;
        this.position = i3;
    }
}
