package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public final class zaam implements BaseGmsClient.ConnectionProgressReportCallbacks {
    public final Api<?> mApi;
    public final boolean zaee;
    public final WeakReference<zaak> zago;

    public zaam(zaak zaak, Api<?> api, boolean z) {
        this.zago = new WeakReference<>(zaak);
        this.mApi = api;
        this.zaee = z;
    }

    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        zaak zaak = (zaak) this.zago.get();
        if (zaak != null) {
            Preconditions.checkState(Looper.myLooper() == zaak.zafv.zaeh.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zaak.zaer.lock();
            try {
                if (zaak.zac(0)) {
                    if (!connectionResult.isSuccess()) {
                        zaak.zab(connectionResult, this.mApi, this.zaee);
                    }
                    if (zaak.zaam()) {
                        zaak.zaan();
                    }
                    zaak.zaer.unlock();
                }
            } finally {
                zaak.zaer.unlock();
            }
        }
    }
}
