package p041if.rg.fe.i;

/* renamed from: if.rg.fe.i.o  reason: invalid package */
public abstract class o<E> extends Cif<E> {

    /* renamed from: pf  reason: collision with root package name */
    public static final long f11214pf = e.qw(o.class, "consumerIndex");
    public volatile long consumerIndex;

    public o(int i2) {
        super(i2);
    }

    public final boolean o(long j, long j2) {
        return e.qw.compareAndSwapLong(this, f11214pf, j, j2);
    }

    public final long pf() {
        return this.consumerIndex;
    }
}
