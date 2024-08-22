package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

public final class zaan extends zabd {
    public final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks zagp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaan(zaal zaal, zabb zabb, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabb);
        this.zagp = connectionProgressReportCallbacks;
    }

    public final void zaal() {
        this.zagp.onReportServiceBinding(new ConnectionResult(16, (PendingIntent) null));
    }
}
