package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzb;
import fe.de.qw.qw.fe;

public final class zzak extends ResultReceiver {
    public final /* synthetic */ InAppMessageResponseListener zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzak(fe feVar, Handler handler, InAppMessageResponseListener inAppMessageResponseListener) {
        super(handler);
        this.zza = inAppMessageResponseListener;
    }

    public final void onReceiveResult(int i2, @Nullable Bundle bundle) {
        this.zza.qw(zzb.zzj(bundle, "BillingClient"));
    }
}
