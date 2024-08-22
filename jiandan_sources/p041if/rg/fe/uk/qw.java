package p041if.rg.fe.uk;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p041if.rg.fe.i.uk;

/* renamed from: if.rg.fe.uk.qw  reason: invalid package */
public abstract class qw<E> extends AbstractQueue<E> {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReferenceArray<E> f11248ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f11249th;

    public qw(int i2) {
        int qw = uk.qw(i2);
        this.f11249th = qw - 1;
        this.f11248ad = new AtomicReferenceArray<>(qw);
    }

    public final int ad(long j, int i2) {
        return ((int) j) & i2;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E de(int i2) {
        return fe(this.f11248ad, i2);
    }

    public final E fe(AtomicReferenceArray<E> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final int qw(long j) {
        return this.f11249th & ((int) j);
    }

    public final void rg(AtomicReferenceArray<E> atomicReferenceArray, int i2, E e) {
        atomicReferenceArray.lazySet(i2, e);
    }
}
