package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p041if.rg.fe.i.uk;

public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    public static final long serialVersionUID = 6210984603741293445L;
    public final int capacitySkip;
    public final AtomicLong consumerIndex = new AtomicLong();
    public final int mask;
    public final AtomicLong producerIndex = new AtomicLong();

    public SpscExactAtomicArrayQueue(int i2) {
        super(uk.qw(i2));
        int length = length();
        this.mask = length - 1;
        this.capacitySkip = length - i2;
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public T element() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return this.producerIndex == this.consumerIndex;
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(T t) {
        if (t != null) {
            long j = this.producerIndex.get();
            int i2 = this.mask;
            if (get(((int) (((long) this.capacitySkip) + j)) & i2) != null) {
                return false;
            }
            this.producerIndex.lazySet(j + 1);
            lazySet(i2 & ((int) j), t);
            return true;
        }
        throw null;
    }

    public T peek() {
        return get(this.mask & ((int) this.consumerIndex.get()));
    }

    public T poll() {
        long j = this.consumerIndex.get();
        int i2 = ((int) j) & this.mask;
        T t = get(i2);
        if (t == null) {
            return null;
        }
        this.consumerIndex.lazySet(j + 1);
        lazySet(i2, (Object) null);
        return t;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        long j = this.consumerIndex.get();
        while (true) {
            long j2 = this.producerIndex.get();
            long j3 = this.consumerIndex.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public T remove() {
        throw new UnsupportedOperationException();
    }

    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
