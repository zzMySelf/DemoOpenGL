package p041if.rg.fe.uk;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: if.rg.fe.uk.de  reason: invalid package */
public final class de<E> extends qw<E> {

    /* renamed from: pf  reason: collision with root package name */
    public static final Integer f11236pf = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f11237i = new AtomicLong();

    /* renamed from: o  reason: collision with root package name */
    public final int f11238o;

    /* renamed from: uk  reason: collision with root package name */
    public long f11239uk;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicLong f11240yj = new AtomicLong();

    public de(int i2) {
        super(i2);
        this.f11238o = Math.min(i2 / 4, f11236pf.intValue());
    }

    public final void i(long j) {
        this.f11240yj.lazySet(j);
    }

    public boolean isEmpty() {
        return yj() == th();
    }

    public boolean offer(E e) {
        if (e != null) {
            AtomicReferenceArray<E> atomicReferenceArray = this.f11248ad;
            int i2 = this.f11249th;
            long j = this.f11240yj.get();
            int ad2 = ad(j, i2);
            if (j >= this.f11239uk) {
                long j2 = ((long) this.f11238o) + j;
                if (fe(atomicReferenceArray, ad(j2, i2)) == null) {
                    this.f11239uk = j2;
                } else if (fe(atomicReferenceArray, ad2) != null) {
                    return false;
                }
            }
            rg(atomicReferenceArray, ad2, e);
            i(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E peek() {
        return de(qw(this.f11237i.get()));
    }

    public E poll() {
        long j = this.f11237i.get();
        int qw = qw(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.f11248ad;
        E fe2 = fe(atomicReferenceArray, qw);
        if (fe2 == null) {
            return null;
        }
        rg(atomicReferenceArray, qw, null);
        uk(j + 1);
        return fe2;
    }

    public int size() {
        long th2 = th();
        while (true) {
            long yj2 = yj();
            long th3 = th();
            if (th2 == th3) {
                return (int) (yj2 - th3);
            }
            th2 = th3;
        }
    }

    public final long th() {
        return this.f11237i.get();
    }

    public final void uk(long j) {
        this.f11237i.lazySet(j);
    }

    public final long yj() {
        return this.f11240yj.get();
    }
}
