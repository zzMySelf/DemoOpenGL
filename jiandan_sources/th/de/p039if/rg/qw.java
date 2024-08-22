package th.de.p039if.rg;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import th.de.p039if.yj.yj;

/* renamed from: th.de.if.rg.qw  reason: invalid package */
public final class qw<T> implements SimplePlainQueue<T> {

    /* renamed from: switch  reason: not valid java name */
    public static final int f516switch = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object when = new Object();

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicLong f10917ad = new AtomicLong();

    /* renamed from: i  reason: collision with root package name */
    public AtomicReferenceArray<Object> f10918i;

    /* renamed from: if  reason: not valid java name */
    public final AtomicLong f517if = new AtomicLong();

    /* renamed from: o  reason: collision with root package name */
    public final int f10919o;

    /* renamed from: pf  reason: collision with root package name */
    public AtomicReferenceArray<Object> f10920pf;

    /* renamed from: th  reason: collision with root package name */
    public int f10921th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10922uk;

    /* renamed from: yj  reason: collision with root package name */
    public long f10923yj;

    public qw(int i2) {
        int qw = yj.qw(Math.max(8, i2));
        int i3 = qw - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(qw + 1);
        this.f10918i = atomicReferenceArray;
        this.f10922uk = i3;
        qw(qw);
        this.f10920pf = atomicReferenceArray;
        this.f10919o = i3;
        this.f10923yj = (long) (i3 - 1);
        xxx(0);
    }

    public static int ad(int i2) {
        return i2;
    }

    public static int de(long j, int i2) {
        int i3 = ((int) j) & i2;
        ad(i3);
        return i3;
    }

    public static void ggg(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    public static <E> Object yj(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final boolean ddd(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i2) {
        ggg(atomicReferenceArray, i2, t);
        xxx(j + 1);
        return true;
    }

    public final long fe() {
        return this.f517if.get();
    }

    public final long i() {
        return this.f10917ad.get();
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m2355if(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f10918i;
        long i2 = i();
        int i3 = this.f10922uk;
        long j = 2 + i2;
        if (yj(atomicReferenceArray, de(j, i3)) == null) {
            int de2 = de(i2, i3);
            ggg(atomicReferenceArray, de2 + 1, t2);
            ggg(atomicReferenceArray, de2, t);
            xxx(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f10918i = atomicReferenceArray2;
        int de3 = de(i2, i3);
        ggg(atomicReferenceArray2, de3 + 1, t2);
        ggg(atomicReferenceArray2, de3, t);
        vvv(atomicReferenceArray, atomicReferenceArray2);
        ggg(atomicReferenceArray, de3, when);
        xxx(j);
        return true;
    }

    public boolean isEmpty() {
        return i() == th();
    }

    public final T o(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.f10920pf = atomicReferenceArray;
        return yj(atomicReferenceArray, de(j, i2));
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f10918i;
            long rg2 = rg();
            int i2 = this.f10922uk;
            int de2 = de(rg2, i2);
            if (rg2 < this.f10923yj) {
                return ddd(atomicReferenceArray, t, rg2, de2);
            }
            long j = ((long) this.f10921th) + rg2;
            if (yj(atomicReferenceArray, de(j, i2)) == null) {
                this.f10923yj = j - 1;
                return ddd(atomicReferenceArray, t, rg2, de2);
            } else if (yj(atomicReferenceArray, de(1 + rg2, i2)) == null) {
                return ddd(atomicReferenceArray, t, rg2, de2);
            } else {
                m2356switch(atomicReferenceArray, rg2, de2, t, (long) i2);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f10920pf;
        long fe2 = fe();
        int i2 = this.f10919o;
        T yj2 = yj(atomicReferenceArray, de(fe2, i2));
        return yj2 == when ? o(uk(atomicReferenceArray, i2 + 1), fe2, i2) : yj2;
    }

    public final T pf(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.f10920pf = atomicReferenceArray;
        int de2 = de(j, i2);
        T yj2 = yj(atomicReferenceArray, de2);
        if (yj2 != null) {
            ggg(atomicReferenceArray, de2, (Object) null);
            ppp(j + 1);
        }
        return yj2;
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f10920pf;
        long fe2 = fe();
        int i2 = this.f10919o;
        int de2 = de(fe2, i2);
        T yj2 = yj(atomicReferenceArray, de2);
        boolean z = yj2 == when;
        if (yj2 != null && !z) {
            ggg(atomicReferenceArray, de2, (Object) null);
            ppp(fe2 + 1);
            return yj2;
        } else if (z) {
            return pf(uk(atomicReferenceArray, i2 + 1), fe2, i2);
        } else {
            return null;
        }
    }

    public final void ppp(long j) {
        this.f517if.lazySet(j);
    }

    public final void qw(int i2) {
        this.f10921th = Math.min(i2 / 4, f516switch);
    }

    public final long rg() {
        return this.f10917ad.get();
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m2356switch(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f10918i = atomicReferenceArray2;
        this.f10923yj = (j2 + j) - 1;
        ggg(atomicReferenceArray2, i2, t);
        vvv(atomicReferenceArray, atomicReferenceArray2);
        ggg(atomicReferenceArray, i2, when);
        xxx(j + 1);
    }

    public final long th() {
        return this.f517if.get();
    }

    public final AtomicReferenceArray<Object> uk(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        ad(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) yj(atomicReferenceArray, i2);
        ggg(atomicReferenceArray, i2, (Object) null);
        return atomicReferenceArray2;
    }

    public final void vvv(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        ad(length);
        ggg(atomicReferenceArray, length, atomicReferenceArray2);
    }

    public int when() {
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

    public final void xxx(long j) {
        this.f10917ad.lazySet(j);
    }
}
