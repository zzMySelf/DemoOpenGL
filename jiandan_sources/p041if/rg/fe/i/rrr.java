package p041if.rg.fe.i;

import java.util.Iterator;
import rx.internal.util.unsafe.QueueProgressIndicators;

/* renamed from: if.rg.fe.i.rrr  reason: invalid package */
public class rrr<E> extends a<E> implements QueueProgressIndicators {
    public static final Object ggg = new Object();

    /* renamed from: if  reason: not valid java name */
    public static final long f531if;

    /* renamed from: pf  reason: collision with root package name */
    public static final int f11218pf = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final int ppp;

    /* renamed from: switch  reason: not valid java name */
    public static final long f532switch;
    public static final long when;

    static {
        Class<Object[]> cls = Object[].class;
        int arrayIndexScale = e.qw.arrayIndexScale(cls);
        if (4 == arrayIndexScale) {
            ppp = 2;
        } else if (8 == arrayIndexScale) {
            ppp = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        when = (long) e.qw.arrayBaseOffset(cls);
        try {
            f531if = e.qw.objectFieldOffset(d.class.getDeclaredField("producerIndex"));
            try {
                f532switch = e.qw.objectFieldOffset(a.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e) {
                InternalError internalError = new InternalError();
                internalError.initCause(e);
                throw internalError;
            }
        } catch (NoSuchFieldException e2) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e2);
            throw internalError2;
        }
    }

    public rrr(int i2) {
        int qw = uk.qw(i2);
        long j = (long) (qw - 1);
        E[] eArr = new Object[(qw + 1)];
        this.f11211uk = eArr;
        this.f11212yj = j;
        qw(qw);
        this.f11225o = eArr;
        this.f11224i = j;
        this.f11210th = j - 1;
        when(0);
    }

    public static long ad(long j) {
        return when + (j << ppp);
    }

    public static long de(long j, long j2) {
        return ad(j & j2);
    }

    /* renamed from: if  reason: not valid java name */
    public static void m2367if(Object[] objArr, long j, Object obj) {
        e.qw.putOrderedObject(objArr, j, obj);
    }

    public static <E> Object rg(E[] eArr, long j) {
        return e.qw.getObjectVolatile(eArr, j);
    }

    public final long fe() {
        return e.qw.getLongVolatile(this, f532switch);
    }

    public final E i(E[] eArr, long j, long j2) {
        this.f11225o = eArr;
        long de2 = de(j, j2);
        E rg2 = rg(eArr, de2);
        if (rg2 == null) {
            return null;
        }
        m2367if(eArr, de2, (Object) null);
        pf(j + 1);
        return rg2;
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final void o(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = new Object[eArr.length];
        this.f11211uk = eArr2;
        this.f11210th = (j3 + j) - 1;
        m2367if(eArr2, j2, e);
        m2368switch(eArr, eArr2);
        m2367if(eArr, j2, ggg);
        when(j + 1);
    }

    public final boolean offer(E e) {
        if (e != null) {
            E[] eArr = this.f11211uk;
            long j = this.producerIndex;
            long j2 = this.f11212yj;
            long de2 = de(j, j2);
            if (j < this.f11210th) {
                return ppp(eArr, e, j, de2);
            }
            long j3 = ((long) this.f11209ad) + j;
            if (rg(eArr, de(j3, j2)) == null) {
                this.f11210th = j3 - 1;
                return ppp(eArr, e, j, de2);
            } else if (rg(eArr, de(1 + j, j2)) != null) {
                return ppp(eArr, e, j, de2);
            } else {
                o(eArr, j, de2, e, j2);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    public final E peek() {
        E[] eArr = this.f11225o;
        long j = this.consumerIndex;
        long j2 = this.f11224i;
        E rg2 = rg(eArr, de(j, j2));
        if (rg2 != ggg) {
            return rg2;
        }
        return uk(th(eArr), j, j2);
    }

    public final void pf(long j) {
        e.qw.putOrderedLong(this, f532switch, j);
    }

    public final E poll() {
        E[] eArr = this.f11225o;
        long j = this.consumerIndex;
        long j2 = this.f11224i;
        long de2 = de(j, j2);
        E rg2 = rg(eArr, de2);
        boolean z = rg2 == ggg;
        if (rg2 != null && !z) {
            m2367if(eArr, de2, (Object) null);
            pf(j + 1);
            return rg2;
        } else if (!z) {
            return null;
        } else {
            return i(th(eArr), j, j2);
        }
    }

    public final boolean ppp(E[] eArr, E e, long j, long j2) {
        m2367if(eArr, j2, e);
        when(j + 1);
        return true;
    }

    public final void qw(int i2) {
        this.f11209ad = Math.min(i2 / 4, f11218pf);
    }

    public final int size() {
        long fe2 = fe();
        while (true) {
            long yj2 = yj();
            long fe3 = fe();
            if (fe2 == fe3) {
                return (int) (yj2 - fe3);
            }
            fe2 = fe3;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m2368switch(E[] eArr, E[] eArr2) {
        m2367if(eArr, ad((long) (eArr.length - 1)), eArr2);
    }

    public final E[] th(E[] eArr) {
        return (Object[]) rg(eArr, ad((long) (eArr.length - 1)));
    }

    public final E uk(E[] eArr, long j, long j2) {
        this.f11225o = eArr;
        return rg(eArr, de(j, j2));
    }

    public final void when(long j) {
        e.qw.putOrderedLong(this, f531if, j);
    }

    public final long yj() {
        return e.qw.getLongVolatile(this, f531if);
    }
}
