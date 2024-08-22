package fe.de.qw.qw;

import com.android.billingclient.api.PurchasesResponseListener;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.concurrent.Callable;

public final class qqq implements Callable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ String f1279ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ PurchasesResponseListener f1280th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ fe f1281yj;

    public qqq(fe feVar, String str, PurchasesResponseListener purchasesResponseListener) {
        this.f1281yj = feVar;
        this.f1279ad = str;
        this.f1280th = purchasesResponseListener;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        q tt = fe.tt(this.f1281yj, this.f1279ad);
        if (tt.ad() != null) {
            this.f1280th.qw(tt.qw(), tt.ad());
            return null;
        }
        this.f1280th.qw(tt.qw(), zzu.zzl());
        return null;
    }
}
