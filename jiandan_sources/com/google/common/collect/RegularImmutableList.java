package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

@GwtCompatible(emulated = true, serializable = true)
public class RegularImmutableList<E> extends ImmutableList<E> {
    public static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);
    @VisibleForTesting
    public final transient Object[] array;
    public final transient int size;

    public RegularImmutableList(Object[] objArr, int i2) {
        this.array = objArr;
        this.size = i2;
    }

    public int copyIntoArray(Object[] objArr, int i2) {
        System.arraycopy(this.array, 0, objArr, i2, this.size);
        return i2 + this.size;
    }

    public E get(int i2) {
        Preconditions.checkElementIndex(i2, this.size);
        return this.array[i2];
    }

    public Object[] internalArray() {
        return this.array;
    }

    public int internalArrayEnd() {
        return this.size;
    }

    public int internalArrayStart() {
        return 0;
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }
}
