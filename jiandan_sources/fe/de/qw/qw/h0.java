package fe.de.qw.qw;

import com.android.billingclient.api.ConsumeResponseListener;
import java.util.concurrent.Callable;

public final /* synthetic */ class h0 implements Callable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ fe f1249ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ uk f1250th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ ConsumeResponseListener f1251yj;

    public /* synthetic */ h0(fe feVar, uk ukVar, ConsumeResponseListener consumeResponseListener) {
        this.f1249ad = feVar;
        this.f1250th = ukVar;
        this.f1251yj = consumeResponseListener;
    }

    public final Object call() {
        this.f1249ad.b(this.f1250th, this.f1251yj);
        return null;
    }
}
