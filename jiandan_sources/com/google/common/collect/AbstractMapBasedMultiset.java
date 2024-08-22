package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
public abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    public static final long serialVersionUID = 0;
    public transient ObjectCountHashMap<E> backingMap;
    public transient long size;

    public abstract class Itr<T> implements Iterator<T> {
        public int entryIndex = AbstractMapBasedMultiset.this.backingMap.firstIndex();
        public int expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        public int toRemove = -1;

        public Itr() {
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.backingMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.entryIndex >= 0;
        }

        public T next() {
            if (hasNext()) {
                T result = result(this.entryIndex);
                int i2 = this.entryIndex;
                this.toRemove = i2;
                this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndex(i2);
                return result;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.toRemove != -1);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.size -= (long) abstractMapBasedMultiset.backingMap.removeEntry(this.toRemove);
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        public abstract T result(int i2);
    }

    public AbstractMapBasedMultiset(int i2) {
        init(i2);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(3);
        Serialization.populateMultiset(this, objectInputStream, readCount);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @CanIgnoreReturnValue
    public final int add(@NullableDecl E e, int i2) {
        if (i2 == 0) {
            return count(e);
        }
        boolean z = true;
        Preconditions.checkArgument(i2 > 0, "occurrences cannot be negative: %s", i2);
        int indexOf = this.backingMap.indexOf(e);
        if (indexOf == -1) {
            this.backingMap.put(e, i2);
            this.size += (long) i2;
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        long j = (long) i2;
        long j2 = ((long) value) + j;
        if (j2 > 2147483647L) {
            z = false;
        }
        Preconditions.checkArgument(z, "too many occurrences: %s", j2);
        this.backingMap.setValue(indexOf, (int) j2);
        this.size += j;
        return value;
    }

    public void addTo(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int firstIndex = this.backingMap.firstIndex();
        while (firstIndex >= 0) {
            multiset.add(this.backingMap.getKey(firstIndex), this.backingMap.getValue(firstIndex));
            firstIndex = this.backingMap.nextIndex(firstIndex);
        }
    }

    public final void clear() {
        this.backingMap.clear();
        this.size = 0;
    }

    public final int count(@NullableDecl Object obj) {
        return this.backingMap.get(obj);
    }

    public final int distinctElements() {
        return this.backingMap.size();
    }

    public final Iterator<E> elementIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() {
            public E result(int i2) {
                return AbstractMapBasedMultiset.this.backingMap.getKey(i2);
            }
        };
    }

    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() {
            public Multiset.Entry<E> result(int i2) {
                return AbstractMapBasedMultiset.this.backingMap.getEntry(i2);
            }
        };
    }

    public abstract void init(int i2);

    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i2) {
        if (i2 == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i2 > 0, "occurrences cannot be negative: %s", i2);
        int indexOf = this.backingMap.indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        if (value > i2) {
            this.backingMap.setValue(indexOf, value - i2);
        } else {
            this.backingMap.removeEntry(indexOf);
            i2 = value;
        }
        this.size -= (long) i2;
        return value;
    }

    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E e, int i2) {
        CollectPreconditions.checkNonnegative(i2, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int remove = i2 == 0 ? objectCountHashMap.remove(e) : objectCountHashMap.put(e, i2);
        this.size += (long) (i2 - remove);
        return remove;
    }

    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    public final boolean setCount(@NullableDecl E e, int i2, int i3) {
        CollectPreconditions.checkNonnegative(i2, "oldCount");
        CollectPreconditions.checkNonnegative(i3, "newCount");
        int indexOf = this.backingMap.indexOf(e);
        if (indexOf == -1) {
            if (i2 != 0) {
                return false;
            }
            if (i3 > 0) {
                this.backingMap.put(e, i3);
                this.size += (long) i3;
            }
            return true;
        } else if (this.backingMap.getValue(indexOf) != i2) {
            return false;
        } else {
            if (i3 == 0) {
                this.backingMap.removeEntry(indexOf);
                this.size -= (long) i2;
            } else {
                this.backingMap.setValue(indexOf, i3);
                this.size += (long) (i3 - i2);
            }
            return true;
        }
    }
}
