package p041if.rg.fe.uk;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p041if.rg.fe.i.uk;

/* renamed from: if.rg.fe.uk.th  reason: invalid package */
public final class th<T> implements Queue<T> {

    /* renamed from: switch  reason: not valid java name */
    public static final int f535switch = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object when = new Object();

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicLong f11250ad = new AtomicLong();

    /* renamed from: i  reason: collision with root package name */
    public AtomicReferenceArray<Object> f11251i;

    /* renamed from: if  reason: not valid java name */
    public final AtomicLong f536if = new AtomicLong();

    /* renamed from: o  reason: collision with root package name */
    public int f11252o;

    /* renamed from: pf  reason: collision with root package name */
    public AtomicReferenceArray<Object> f11253pf;

    /* renamed from: th  reason: collision with root package name */
    public int f11254th;

    /* renamed from: uk  reason: collision with root package name */
    public int f11255uk;

    /* renamed from: yj  reason: collision with root package name */
    public long f11256yj;

    public th(int i2) {
        int qw = uk.qw(Math.max(8, i2));
        int i3 = qw - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(qw + 1);
        this.f11251i = atomicReferenceArray;
        this.f11255uk = i3;
        qw(qw);
        this.f11253pf = atomicReferenceArray;
        this.f11252o = i3;
        this.f11256yj = (long) (i3 - 1);
        ggg(0);
    }

    public static int ad(int i2) {
        return i2;
    }

    public static int de(long j, int i2) {
        int i3 = ((int) j) & i2;
        ad(i3);
        return i3;
    }

    public static void when(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
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
        return this.f536if.get();
    }

    public final void ggg(long j) {
        this.f11250ad.lazySet(j);
    }

    public final long i() {
        return this.f11250ad.get();
    }

    /* renamed from: if  reason: not valid java name */
    public final void m2371if(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f11251i = atomicReferenceArray2;
        this.f11256yj = (j2 + j) - 1;
        ggg(j + 1);
        when(atomicReferenceArray2, i2, t);
        ppp(atomicReferenceArray, atomicReferenceArray2);
        when(atomicReferenceArray, i2, when);
    }

    public boolean isEmpty() {
        return i() == th();
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public final T o(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.f11253pf = atomicReferenceArray;
        return yj(atomicReferenceArray, de(j, i2));
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f11251i;
            long rg2 = rg();
            int i2 = this.f11255uk;
            int de2 = de(rg2, i2);
            if (rg2 < this.f11256yj) {
                return vvv(atomicReferenceArray, t, rg2, de2);
            }
            long j = ((long) this.f11254th) + rg2;
            if (yj(atomicReferenceArray, de(j, i2)) == null) {
                this.f11256yj = j - 1;
                return vvv(atomicReferenceArray, t, rg2, de2);
            } else if (yj(atomicReferenceArray, de(1 + rg2, i2)) != null) {
                return vvv(atomicReferenceArray, t, rg2, de2);
            } else {
                m2371if(atomicReferenceArray, rg2, de2, t, (long) i2);
                return true;
            }
        } else {
            throw null;
        }
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f11253pf;
        long fe2 = fe();
        int i2 = this.f11252o;
        T yj2 = yj(atomicReferenceArray, de(fe2, i2));
        return yj2 == when ? o(uk(atomicReferenceArray), fe2, i2) : yj2;
    }

    public final T pf(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.f11253pf = atomicReferenceArray;
        int de2 = de(j, i2);
        T yj2 = yj(atomicReferenceArray, de2);
        if (yj2 == null) {
            return null;
        }
        m2372switch(j + 1);
        when(atomicReferenceArray, de2, (Object) null);
        return yj2;
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f11253pf;
        long fe2 = fe();
        int i2 = this.f11252o;
        int de2 = de(fe2, i2);
        T yj2 = yj(atomicReferenceArray, de2);
        boolean z = yj2 == when;
        if (yj2 != null && !z) {
            m2372switch(fe2 + 1);
            when(atomicReferenceArray, de2, (Object) null);
            return yj2;
        } else if (z) {
            return pf(uk(atomicReferenceArray), fe2, i2);
        } else {
            return null;
        }
    }

    public final void ppp(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        ad(length);
        when(atomicReferenceArray, length, atomicReferenceArray2);
    }

    public final void qw(int i2) {
        this.f11254th = Math.min(i2 / 4, f535switch);
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
        return this.f11250ad.get();
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
    public final void m2372switch(long j) {
        this.f536if.lazySet(j);
    }

    public final long th() {
        return this.f536if.get();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public final AtomicReferenceArray<Object> uk(AtomicReferenceArray<Object> atomicReferenceArray) {
        int length = atomicReferenceArray.length() - 1;
        ad(length);
        return (AtomicReferenceArray) yj(atomicReferenceArray, length);
    }

    public final boolean vvv(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i2) {
        ggg(j + 1);
        when(atomicReferenceArray, i2, t);
        return true;
    }

    public T remove() {
        throw new UnsupportedOperationException();
    }

    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
