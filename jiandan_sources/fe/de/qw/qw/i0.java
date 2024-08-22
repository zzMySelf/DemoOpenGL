package fe.de.qw.qw;

import com.android.billingclient.api.ConsumeResponseListener;

public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ConsumeResponseListener f1252ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ uk f1253th;

    public /* synthetic */ i0(ConsumeResponseListener consumeResponseListener, uk ukVar) {
        this.f1252ad = consumeResponseListener;
        this.f1253th = ukVar;
    }

    public final void run() {
        this.f1252ad.th(l.f1259i, this.f1253th.qw());
    }
}
