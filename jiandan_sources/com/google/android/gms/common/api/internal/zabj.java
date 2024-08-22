package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

public final class zabj implements Runnable {
    public final /* synthetic */ GoogleApiManager.zaa zaiq;
    public final /* synthetic */ ConnectionResult zajc;

    public zabj(GoogleApiManager.zaa zaa, ConnectionResult connectionResult) {
        this.zaiq = zaa;
        this.zajc = connectionResult;
    }

    public final void run() {
        this.zaiq.onConnectionFailed(this.zajc);
    }
}
