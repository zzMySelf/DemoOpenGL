package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

public final class zaf implements BaseGmsClient.BaseConnectionCallbacks {
    public final /* synthetic */ ConnectionCallbacks zaou;

    public zaf(ConnectionCallbacks connectionCallbacks) {
        this.zaou = connectionCallbacks;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zaou.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i2) {
        this.zaou.onConnectionSuspended(i2);
    }
}
