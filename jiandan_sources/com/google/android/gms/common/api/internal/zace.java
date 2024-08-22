package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zab;
import com.google.android.gms.signin.zac;
import java.util.Set;

public final class zace extends zad implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static Api.AbstractClientBuilder<? extends zac, SignInOptions> zakm = zab.zapv;
    public final Context mContext;
    public final Handler mHandler;
    public Set<Scope> mScopes;
    public final Api.AbstractClientBuilder<? extends zac, SignInOptions> zaaw;
    public ClientSettings zafa;
    public zac zagf;
    public zacf zakn;

    @WorkerThread
    public zace(Context context, Handler handler, @NonNull ClientSettings clientSettings) {
        this(context, handler, clientSettings, zakm);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zac(zak zak) {
        ConnectionResult connectionResult = zak.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse zacv = zak.zacv();
            ConnectionResult connectionResult2 = zacv.getConnectionResult();
            if (!connectionResult2.isSuccess()) {
                String valueOf = String.valueOf(connectionResult2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.zakn.zag(connectionResult2);
                this.zagf.disconnect();
                return;
            }
            this.zakn.zaa(zacv.getAccountAccessor(), this.mScopes);
        } else {
            this.zakn.zag(connectionResult);
        }
        this.zagf.disconnect();
    }

    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.zagf.zaa(this);
    }

    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zakn.zag(connectionResult);
    }

    @WorkerThread
    public final void onConnectionSuspended(int i2) {
        this.zagf.disconnect();
    }

    @WorkerThread
    public final void zaa(zacf zacf) {
        zac zac = this.zagf;
        if (zac != null) {
            zac.disconnect();
        }
        this.zafa.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder = this.zaaw;
        Context context = this.mContext;
        Looper looper = this.mHandler.getLooper();
        ClientSettings clientSettings = this.zafa;
        this.zagf = (zac) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        this.zakn = zacf;
        Set<Scope> set = this.mScopes;
        if (set == null || set.isEmpty()) {
            this.mHandler.post(new zacd(this));
        } else {
            this.zagf.connect();
        }
    }

    @BinderThread
    public final void zab(zak zak) {
        this.mHandler.post(new zacg(this, zak));
    }

    public final zac zabo() {
        return this.zagf;
    }

    public final void zabq() {
        zac zac = this.zagf;
        if (zac != null) {
            zac.disconnect();
        }
    }

    @WorkerThread
    public zace(Context context, Handler handler, @NonNull ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder) {
        this.mContext = context;
        this.mHandler = handler;
        this.zafa = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.mScopes = clientSettings.getRequiredScopes();
        this.zaaw = abstractClientBuilder;
    }
}
