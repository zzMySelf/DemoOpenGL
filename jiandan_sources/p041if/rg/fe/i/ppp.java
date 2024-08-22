package p041if.rg.fe.i;

/* renamed from: if.rg.fe.i.ppp  reason: invalid package */
public abstract class ppp<E> extends pf<E> {

    /* renamed from: o  reason: collision with root package name */
    public static final long f11215o = e.qw(ppp.class, "producerIndex");
    public volatile long producerIndex;

    public ppp(int i2) {
        super(i2);
    }

    public final void i(long j) {
        e.qw.putOrderedLong(this, f11215o, j);
    }

    public final long uk() {
        return this.producerIndex;
    }
}
