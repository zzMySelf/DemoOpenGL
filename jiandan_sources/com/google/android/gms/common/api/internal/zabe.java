package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zac;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zabe implements zabr, zar {
    public final Context mContext;
    public final Api.AbstractClientBuilder<? extends zac, SignInOptions> zacf;
    public final zaaw zaeh;
    public final Lock zaer;
    public final Map<Api<?>, Boolean> zaew;
    public final GoogleApiAvailabilityLight zaey;
    public final ClientSettings zafa;
    public final Map<Api.AnyClientKey<?>, Api.Client> zahd;
    public final Condition zahr;
    public final zabg zahs;
    public final Map<Api.AnyClientKey<?>, ConnectionResult> zaht = new HashMap();
    public volatile zabb zahu;
    public ConnectionResult zahv = null;
    public int zahw;
    public final zabs zahx;

    public zabe(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, ArrayList<zap> arrayList, zabs zabs) {
        this.mContext = context;
        this.zaer = lock;
        this.zaey = googleApiAvailabilityLight;
        this.zahd = map;
        this.zafa = clientSettings;
        this.zaew = map2;
        this.zacf = abstractClientBuilder;
        this.zaeh = zaaw;
        this.zahx = zabs;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zap zap = arrayList.get(i2);
            i2++;
            zap.zaa(this);
        }
        this.zahs = new zabg(this, looper);
        this.zahr = lock.newCondition();
        this.zahu = new zaat(this);
    }

    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zahr.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zahv;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    public final void connect() {
        this.zahu.connect();
    }

    public final void disconnect() {
        if (this.zahu.disconnect()) {
            this.zaht.clear();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.zahu);
        for (Api next : this.zaew.keySet()) {
            printWriter.append(str).append(next.getName()).println(":");
            this.zahd.get(next.getClientKey()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        t.zar();
        return this.zahu.enqueue(t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        t.zar();
        return this.zahu.execute(t);
    }

    @Nullable
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        Api.AnyClientKey<?> clientKey = api.getClientKey();
        if (!this.zahd.containsKey(clientKey)) {
            return null;
        }
        if (this.zahd.get(clientKey).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zaht.containsKey(clientKey)) {
            return this.zaht.get(clientKey);
        }
        return null;
    }

    public final boolean isConnected() {
        return this.zahu instanceof zaaf;
    }

    public final boolean isConnecting() {
        return this.zahu instanceof zaak;
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    public final void maybeSignOut() {
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zaer.lock();
        try {
            this.zahu.onConnected(bundle);
        } finally {
            this.zaer.unlock();
        }
    }

    public final void onConnectionSuspended(int i2) {
        this.zaer.lock();
        try {
            this.zahu.onConnectionSuspended(i2);
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zaa(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, boolean z) {
        this.zaer.lock();
        try {
            this.zahu.zaa(connectionResult, api, z);
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zaax() {
        this.zaer.lock();
        try {
            this.zahu = new zaak(this, this.zafa, this.zaew, this.zaey, this.zacf, this.zaer, this.mContext);
            this.zahu.begin();
            this.zahr.signalAll();
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zaay() {
        this.zaer.lock();
        try {
            this.zaeh.zaau();
            this.zahu = new zaaf(this);
            this.zahu.begin();
            this.zahr.signalAll();
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zab(RuntimeException runtimeException) {
        this.zahs.sendMessage(this.zahs.obtainMessage(2, runtimeException));
    }

    public final void zaf(ConnectionResult connectionResult) {
        this.zaer.lock();
        try {
            this.zahv = connectionResult;
            this.zahu = new zaat(this);
            this.zahu.begin();
            this.zahr.signalAll();
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zau() {
        if (isConnected()) {
            ((zaaf) this.zahu).zaak();
        }
    }

    public final void zaa(zabd zabd) {
        this.zahs.sendMessage(this.zahs.obtainMessage(1, zabd));
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.zahr.awaitNanos(nanos);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zahv;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }
}
