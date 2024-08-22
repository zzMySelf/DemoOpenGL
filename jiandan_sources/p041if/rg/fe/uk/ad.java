package p041if.rg.fe.uk;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: if.rg.fe.uk.ad  reason: invalid package */
public abstract class ad<E> extends AbstractQueue<E> {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<E>> f11234ad = new AtomicReference<>();

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<E>> f11235th = new AtomicReference<>();

    public final LinkedQueueNode<E> ad() {
        return this.f11234ad.get();
    }

    public final LinkedQueueNode<E> de() {
        return this.f11235th.get();
    }

    public final LinkedQueueNode<E> fe() {
        return this.f11234ad.get();
    }

    public final boolean isEmpty() {
        return de() == fe();
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final LinkedQueueNode<E> qw() {
        return this.f11235th.get();
    }

    public final void rg(LinkedQueueNode<E> linkedQueueNode) {
        this.f11235th.lazySet(linkedQueueNode);
    }

    public final int size() {
        LinkedQueueNode lvNext;
        LinkedQueueNode de2 = de();
        LinkedQueueNode fe2 = fe();
        int i2 = 0;
        while (de2 != fe2 && i2 < Integer.MAX_VALUE) {
            do {
                lvNext = de2.lvNext();
            } while (lvNext == null);
            i2++;
            de2 = lvNext;
        }
        return i2;
    }

    public final void th(LinkedQueueNode<E> linkedQueueNode) {
        this.f11234ad.lazySet(linkedQueueNode);
    }
}
