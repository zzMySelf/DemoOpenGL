package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    public void add(int i2, E e) {
        delegate().add(i2, e);
    }

    @CanIgnoreReturnValue
    public boolean addAll(int i2, Collection<? extends E> collection) {
        return delegate().addAll(i2, collection);
    }

    public abstract List<E> delegate();

    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public E get(int i2) {
        return delegate().get(i2);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    public int indexOf(Object obj) {
        return delegate().indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return delegate().lastIndexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @CanIgnoreReturnValue
    public E remove(int i2) {
        return delegate().remove(i2);
    }

    @CanIgnoreReturnValue
    public E set(int i2, E e) {
        return delegate().set(i2, e);
    }

    public boolean standardAdd(E e) {
        add(size(), e);
        return true;
    }

    public boolean standardAddAll(int i2, Iterable<? extends E> iterable) {
        return Lists.addAllImpl(this, i2, iterable);
    }

    @Beta
    public boolean standardEquals(@NullableDecl Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    @Beta
    public int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }

    public int standardIndexOf(@NullableDecl Object obj) {
        return Lists.indexOfImpl(this, obj);
    }

    public Iterator<E> standardIterator() {
        return listIterator();
    }

    public int standardLastIndexOf(@NullableDecl Object obj) {
        return Lists.lastIndexOfImpl(this, obj);
    }

    public ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @Beta
    public List<E> standardSubList(int i2, int i3) {
        return Lists.subListImpl(this, i2, i3);
    }

    public List<E> subList(int i2, int i3) {
        return delegate().subList(i2, i3);
    }

    public ListIterator<E> listIterator(int i2) {
        return delegate().listIterator(i2);
    }

    @Beta
    public ListIterator<E> standardListIterator(int i2) {
        return Lists.listIteratorImpl(this, i2);
    }
}
