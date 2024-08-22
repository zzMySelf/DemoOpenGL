package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class AbstractProtobufList<E> extends AbstractList<E> implements Internal.ProtobufList<E> {
    public static final int DEFAULT_CAPACITY = 10;
    public boolean isMutable = true;

    public boolean add(E e) {
        ensureIsMutable();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        ensureIsMutable();
        return super.addAll(collection);
    }

    public void clear() {
        ensureIsMutable();
        super.clear();
    }

    public void ensureIsMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!get(i2).equals(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (i2 * 31) + get(i3).hashCode();
        }
        return i2;
    }

    public boolean isModifiable() {
        return this.isMutable;
    }

    public final void makeImmutable() {
        this.isMutable = false;
    }

    public E remove(int i2) {
        ensureIsMutable();
        return super.remove(i2);
    }

    public boolean removeAll(Collection<?> collection) {
        ensureIsMutable();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        ensureIsMutable();
        return super.retainAll(collection);
    }

    public E set(int i2, E e) {
        ensureIsMutable();
        return super.set(i2, e);
    }

    public void add(int i2, E e) {
        ensureIsMutable();
        super.add(i2, e);
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        ensureIsMutable();
        return super.addAll(i2, collection);
    }

    public boolean remove(Object obj) {
        ensureIsMutable();
        return super.remove(obj);
    }
}
