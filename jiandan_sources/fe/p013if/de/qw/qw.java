package fe.p013if.de.qw;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: fe.if.de.qw.qw  reason: invalid package */
public abstract class qw {

    /* renamed from: ad  reason: collision with root package name */
    public long f4603ad;

    /* renamed from: de  reason: collision with root package name */
    public Runnable f4604de = new C0200qw();
    public AtomicBoolean qw = new AtomicBoolean(false);

    /* renamed from: fe.if.de.qw.qw$qw  reason: collision with other inner class name */
    public class C0200qw implements Runnable {
        public C0200qw() {
        }

        public void run() {
            qw.this.ad();
            if (qw.this.qw.get()) {
                fe.qw().postDelayed(qw.this.f4604de, qw.this.f4603ad);
            }
        }
    }

    public qw(long j) {
        this.f4603ad = 0 == j ? 300 : j;
    }

    public abstract void ad();

    public void de() {
        if (!this.qw.get()) {
            this.qw.set(true);
            fe.qw().removeCallbacks(this.f4604de);
            fe.qw().postDelayed(this.f4604de, de.rg().i());
        }
    }

    public void fe() {
        if (this.qw.get()) {
            this.qw.set(false);
            fe.qw().removeCallbacks(this.f4604de);
        }
    }
}
