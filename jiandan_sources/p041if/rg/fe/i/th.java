package p041if.rg.fe.i;

import java.util.Iterator;

/* renamed from: if.rg.fe.i.th  reason: invalid package */
public abstract class th<E> extends yj<E> {

    /* renamed from: i  reason: collision with root package name */
    public static final int f11219i;

    /* renamed from: uk  reason: collision with root package name */
    public static final long f11220uk;

    /* renamed from: yj  reason: collision with root package name */
    public static final int f11221yj = Integer.getInteger("sparse.shift", 0).intValue();

    /* renamed from: ad  reason: collision with root package name */
    public final long f11222ad;

    /* renamed from: th  reason: collision with root package name */
    public final E[] f11223th;

    static {
        Class<Object[]> cls = Object[].class;
        int arrayIndexScale = e.qw.arrayIndexScale(cls);
        if (4 == arrayIndexScale) {
            f11219i = f11221yj + 2;
        } else if (8 == arrayIndexScale) {
            f11219i = f11221yj + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f11220uk = (long) (e.qw.arrayBaseOffset(cls) + (32 << (f11219i - f11221yj)));
    }

    public th(int i2) {
        int qw = uk.qw(i2);
        this.f11222ad = (long) (qw - 1);
        this.f11223th = new Object[((qw << f11221yj) + 64)];
    }

    public final long ad(long j, long j2) {
        return f11220uk + ((j & j2) << f11219i);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E de(E[] eArr, long j) {
        return e.qw.getObject(eArr, j);
    }

    public final E fe(long j) {
        return rg(this.f11223th, j);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final long qw(long j) {
        return ad(j, this.f11222ad);
    }

    public final E rg(E[] eArr, long j) {
        return e.qw.getObjectVolatile(eArr, j);
    }

    public final void th(E[] eArr, long j, E e) {
        e.qw.putOrderedObject(eArr, j, e);
    }

    public final void yj(E[] eArr, long j, E e) {
        e.qw.putObject(eArr, j, e);
    }
}
