package fe.de.qw.qw;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.zzbe;
import com.android.billingclient.api.zzc;

public final class d0 {

    /* renamed from: ad  reason: collision with root package name */
    public final c0 f1227ad;
    public final Context qw;

    public d0(Context context, zzbe zzbe) {
        this.qw = context;
        this.f1227ad = new c0(this, (zzbe) null, (b0) null);
    }

    @Nullable
    public final zzbe ad() {
        zzbe unused = this.f1227ad.f1223ad;
        return null;
    }

    @Nullable
    public final PurchasesUpdatedListener de() {
        return this.f1227ad.qw;
    }

    public final void fe() {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        intentFilter.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f1227ad.de(this.qw, intentFilter);
    }

    public d0(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzc zzc) {
        this.qw = context;
        this.f1227ad = new c0(this, purchasesUpdatedListener, zzc, (b0) null);
    }
}
