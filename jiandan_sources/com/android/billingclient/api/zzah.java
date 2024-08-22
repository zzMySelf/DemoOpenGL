package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;
import fe.de.qw.qw.fe;
import fe.de.qw.qw.yj;

public final class zzah extends ResultReceiver {
    public final /* synthetic */ PriceChangeConfirmationListener zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzah(fe feVar, Handler handler, PriceChangeConfirmationListener priceChangeConfirmationListener) {
        super(handler);
        this.zza = priceChangeConfirmationListener;
    }

    public final void onReceiveResult(int i2, Bundle bundle) {
        yj.qw de2 = yj.de();
        de2.de(i2);
        de2.ad(zzb.zzk(bundle, "BillingClient"));
        this.zza.rg(de2.qw());
    }
}
