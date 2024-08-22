package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

public final class zaax implements GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ StatusPendingResult zahl;

    public zaax(zaaw zaaw, StatusPendingResult statusPendingResult) {
        this.zahl = statusPendingResult;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zahl.setResult(new Status(8));
    }
}
