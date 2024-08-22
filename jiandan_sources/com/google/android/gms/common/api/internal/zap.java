package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

public final class zap implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> mApi;
    public final boolean zaee;
    public zar zaef;

    public zap(Api<?> api, boolean z) {
        this.mApi = api;
        this.zaee = z;
    }

    private final void zat() {
        Preconditions.checkNotNull(this.zaef, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public final void onConnected(@Nullable Bundle bundle) {
        zat();
        this.zaef.onConnected(bundle);
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zat();
        this.zaef.zaa(connectionResult, this.mApi, this.zaee);
    }

    public final void onConnectionSuspended(int i2) {
        zat();
        this.zaef.onConnectionSuspended(i2);
    }

    public final void zaa(zar zar) {
        this.zaef = zar;
    }
}
