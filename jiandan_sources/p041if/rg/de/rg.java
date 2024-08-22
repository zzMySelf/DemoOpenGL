package p041if.rg.de;

import p041if.qw;
import rx.functions.Action0;

/* renamed from: if.rg.de.rg  reason: invalid package */
public class rg implements Action0 {

    /* renamed from: ad  reason: collision with root package name */
    public final Action0 f11189ad;

    /* renamed from: th  reason: collision with root package name */
    public final qw.C0349qw f11190th;

    /* renamed from: yj  reason: collision with root package name */
    public final long f11191yj;

    public rg(Action0 action0, qw.C0349qw qwVar, long j) {
        this.f11189ad = action0;
        this.f11190th = qwVar;
        this.f11191yj = j;
    }

    public void call() {
        if (!this.f11190th.isUnsubscribed()) {
            long ad2 = this.f11191yj - this.f11190th.ad();
            if (ad2 > 0) {
                try {
                    Thread.sleep(ad2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    p041if.fe.qw.de(e);
                    throw null;
                }
            }
            if (!this.f11190th.isUnsubscribed()) {
                this.f11189ad.call();
            }
        }
    }
}
