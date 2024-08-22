package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;

public final class zaay implements GoogleApiClient.ConnectionCallbacks {
    public final /* synthetic */ zaaw zagv;
    public final /* synthetic */ StatusPendingResult zahl;
    public final /* synthetic */ AtomicReference zahm;

    public zaay(zaaw zaaw, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zagv = zaaw;
        this.zahm = atomicReference;
        this.zahl = statusPendingResult;
    }

    public final void onConnected(Bundle bundle) {
        this.zagv.zaa((GoogleApiClient) this.zahm.get(), this.zahl, true);
    }

    public final void onConnectionSuspended(int i2) {
    }
}
