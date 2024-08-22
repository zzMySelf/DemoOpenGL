package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.IAccountAccessor;

public final class zabo implements Runnable {
    public final /* synthetic */ ConnectionResult zajc;
    public final /* synthetic */ GoogleApiManager.zab zajk;

    public zabo(GoogleApiManager.zab zab, ConnectionResult connectionResult) {
        this.zajk = zab;
        this.zajc = connectionResult;
    }

    public final void run() {
        GoogleApiManager.zaa zaa = (GoogleApiManager.zaa) GoogleApiManager.this.zaim.get(this.zajk.zaft);
        if (zaa != null) {
            if (this.zajc.isSuccess()) {
                boolean unused = this.zajk.zajg = true;
                if (this.zajk.zais.requiresSignIn()) {
                    this.zajk.zabp();
                    return;
                }
                try {
                    this.zajk.zais.getRemoteService((IAccountAccessor) null, this.zajk.zais.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException unused2) {
                    zaa.onConnectionFailed(new ConnectionResult(10));
                }
            } else {
                zaa.onConnectionFailed(this.zajc);
            }
        }
    }
}
