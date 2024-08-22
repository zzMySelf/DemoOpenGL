package th.de.p039if.fe.ad;

/* renamed from: th.de.if.fe.ad.ggg  reason: invalid package */
public final class ggg implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final ppp f10496ad;

    /* renamed from: th  reason: collision with root package name */
    public final long f10497th;

    public ggg(long j, ppp ppp) {
        this.f10497th = j;
        this.f10496ad = ppp;
    }

    public void run() {
        this.f10496ad.onTimeout(this.f10497th);
    }
}
