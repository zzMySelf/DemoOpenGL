package p041if.rg.fe.uk;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p041if.rg.fe.i.uk;

/* renamed from: if.rg.fe.uk.fe  reason: invalid package */
public final class fe<T> implements Queue<T> {

    /* renamed from: switch  reason: not valid java name */
    public static final int f533switch = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object when = new Object();

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicLong f11241ad = new AtomicLong();

    /* renamed from: i  reason: collision with root package name */
    public AtomicReferenceArray<Object> f11242i;

    /* renamed from: if  reason: not valid java name */
    public final AtomicLong f534if = new AtomicLong();

    /* renamed from: o  reason: collision with root package name */
    public int f11243o;

    /* renamed from: pf  reason: collision with root package name */
    public AtomicReferenceArray<Object> f11244pf;

    /* renamed from: th  reason: collision with root package name */
    public int f11245th;

    /* renamed from: uk  reason: collision with root package name */
    public int f11246uk;

    /* renamed from: yj  reason: collision with root package name */
    public long f11247yj;

    public fe(int i2) {
        int qw = uk.qw(i2);
        int i3 = qw - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(qw + 1);
        this.f11242i = atomicReferenceArray;
        this.f11246uk = i3;
        qw(qw);
        this.f11244pf = atomicReferenceArray;
        this.f11243o = i3;
        this.f11247yj = (long) (i3 - 1);
    }

    public static int ad(int i2) {
        return i2;
    }

    public static int de(long j, int i2) {
        int i3 = ((int) j) & i2;
        ad(i3);
        return i3;
    }

    public static void ppp(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    public static <E> Object yj(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
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

    public final long fe() {
        return this.f534if.get();
    }

    public final void ggg(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        ad(length);
        ppp(atomicReferenceArray, length, atomicReferenceArray2);
    }

    public final long i() {
        return this.f11241ad.get();
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m2369if(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f11242i;
        long i2 = i();
        int i3 = this.f11246uk;
        long j = 2 + i2;
        if (yj(atomicReferenceArray, de(j, i3)) == null) {
            int de2 = de(i2, i3);
            ppp(atomicReferenceArray, de2 + 1, t2);
            ppp(atomicReferenceArray, de2, t);
            vvv(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f11242i = atomicReferenceArray2;
        int de3 = de(i2, i3);
        ppp(atomicReferenceArray2, de3 + 1, t2);
        ppp(atomicReferenceArray2, de3, t);
        ggg(atomicReferenceArray, atomicReferenceArray2);
        ppp(atomicReferenceArray, de3, when);
        vvv(j);
        return true;
    }

    public boolean isEmpty() {
        return i() == th();
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public final T o(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.f11244pf = atomicReferenceArray;
        return yj(atomicReferenceArray, de(j, i2));
    }

    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f11242i;
        long rg2 = rg();
        int i2 = this.f11246uk;
        int de2 = de(rg2, i2);
        if (rg2 < this.f11247yj) {
            return xxx(atomicReferenceArray, t, rg2, de2);
        }
        long j = ((long) this.f11245th) + rg2;
        if (yj(atomicReferenceArray, de(j, i2)) == null) {
            this.f11247yj = j - 1;
            return xxx(atomicReferenceArray, t, rg2, de2);
        } else if (yj(atomicReferenceArray, de(1 + rg2, i2)) == null) {
            return xxx(atomicReferenceArray, t, rg2, de2);
        } else {
            m2370switch(atomicReferenceArray, rg2, de2, t, (long) i2);
            return true;
        }
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f11244pf;
        long fe2 = fe();
        int i2 = this.f11243o;
        T yj2 = yj(atomicReferenceArray, de(fe2, i2));
        return yj2 == when ? o(uk(atomicReferenceArray), fe2, i2) : yj2;
    }

    public final T pf(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.f11244pf = atomicReferenceArray;
        int de2 = de(j, i2);
        T yj2 = yj(atomicReferenceArray, de2);
        if (yj2 == null) {
            return null;
        }
        ppp(atomicReferenceArray, de2, (Object) null);
        when(j + 1);
        return yj2;
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f11244pf;
        long fe2 = fe();
        int i2 = this.f11243o;
        int de2 = de(fe2, i2);
        T yj2 = yj(atomicReferenceArray, de2);
        boolean z = yj2 == when;
        if (yj2 != null && !z) {
            ppp(atomicReferenceArray, de2, (Object) null);
            when(fe2 + 1);
            return yj2;
        } else if (z) {
            return pf(uk(atomicReferenceArray), fe2, i2);
        } else {
            return null;
        }
    }

    public final void qw(int i2) {
        this.f11245th = Math.min(i2 / 4, f533switch);
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

    public final long rg() {
        return this.f11241ad.get();
    }

    public int size() {
        long th2 = th();
        while (true) {
            long i2 = i();
            long th3 = th();
            if (th2 == th3) {
                return (int) (i2 - th3);
            }
            th2 = th3;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m2370switch(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f11242i = atomicReferenceArray2;
        this.f11247yj = (j2 + j) - 1;
        ppp(atomicReferenceArray2, i2, t);
        ggg(atomicReferenceArray, atomicReferenceArray2);
        ppp(atomicReferenceArray, i2, when);
        vvv(j + 1);
    }

    public final long th() {
        return this.f534if.get();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public final AtomicReferenceArray<Object> uk(AtomicReferenceArray<Object> atomicReferenceArray) {
        int length = atomicReferenceArray.length() - 1;
        ad(length);
        return (AtomicReferenceArray) yj(atomicReferenceArray, length);
    }

    public final void vvv(long j) {
        this.f11241ad.lazySet(j);
    }

    public final void when(long j) {
        this.f534if.lazySet(j);
    }

    public final boolean xxx(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i2) {
        ppp(atomicReferenceArray, i2, t);
        vvv(j + 1);
        return true;
    }

    public T remove() {
        throw new UnsupportedOperationException();
    }

    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
