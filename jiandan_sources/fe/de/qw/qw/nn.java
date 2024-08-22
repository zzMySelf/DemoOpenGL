package fe.de.qw.qw;

import com.android.billingclient.api.PurchasesResponseListener;
import com.google.android.gms.internal.play_billing.zzu;

public final /* synthetic */ class nn implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PurchasesResponseListener f1268ad;

    public /* synthetic */ nn(PurchasesResponseListener purchasesResponseListener) {
        this.f1268ad = purchasesResponseListener;
    }

    public final void run() {
        this.f1268ad.qw(l.f1259i, zzu.zzl());
    }
}
