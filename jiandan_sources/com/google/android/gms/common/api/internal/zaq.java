package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zar;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zac;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public final class zaq implements zabr {
    public final Context mContext;
    public final Looper zabl;
    public final zaaw zaeh;
    public final zabe zaei;
    public final zabe zaej;
    public final Map<Api.AnyClientKey<?>, zabe> zaek;
    public final Set<SignInConnectionListener> zael = Collections.newSetFromMap(new WeakHashMap());
    public final Api.Client zaem;
    public Bundle zaen;
    public ConnectionResult zaeo = null;
    public ConnectionResult zaep = null;
    public boolean zaeq = false;
    public final Lock zaer;
    public int zaes = 0;

    public zaq(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zap> arrayList, ArrayList<zap> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.mContext = context;
        zaaw zaaw2 = zaaw;
        this.zaeh = zaaw2;
        this.zaer = lock;
        this.zabl = looper;
        this.zaem = client;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zabe zabe = r3;
        zabe zabe2 = new zabe(context2, zaaw2, lock2, looper2, googleApiAvailabilityLight2, map2, (ClientSettings) null, map4, (Api.AbstractClientBuilder<? extends zac, SignInOptions>) null, arrayList2, new zas(this, (zat) null));
        this.zaei = zabe;
        this.zaej = new zabe(context2, this.zaeh, lock2, looper2, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new zau(this, (zat) null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey<?> put : map2.keySet()) {
            arrayMap.put(put, this.zaei);
        }
        for (Api.AnyClientKey<?> put2 : map.keySet()) {
            arrayMap.put(put2, this.zaej);
        }
        this.zaek = Collections.unmodifiableMap(arrayMap);
    }

    public static zaq zaa(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, ArrayList<zap> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry next : map.entrySet()) {
            Api.Client client2 = (Api.Client) next.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) next.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) next.getKey(), client2);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api next2 : map2.keySet()) {
            Api.AnyClientKey<?> clientKey = next2.getClientKey();
            if (arrayMap.containsKey(clientKey)) {
                arrayMap3.put(next2, map3.get(next2));
            } else if (arrayMap2.containsKey(clientKey)) {
                arrayMap4.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zap zap = arrayList.get(i2);
            i2++;
            zap zap2 = zap;
            if (arrayMap3.containsKey(zap2.mApi)) {
                arrayList2.add(zap2);
            } else if (arrayMap4.containsKey(zap2.mApi)) {
                arrayList3.add(zap2);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zaq(context, zaaw, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    public static boolean zab(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    /* access modifiers changed from: private */
    public final void zav() {
        ConnectionResult connectionResult;
        if (zab(this.zaeo)) {
            if (zab(this.zaep) || zax()) {
                int i2 = this.zaes;
                if (i2 != 1) {
                    if (i2 != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        this.zaes = 0;
                        return;
                    }
                    this.zaeh.zab(this.zaen);
                }
                zaw();
                this.zaes = 0;
                return;
            }
            ConnectionResult connectionResult2 = this.zaep;
            if (connectionResult2 == null) {
                return;
            }
            if (this.zaes == 1) {
                zaw();
                return;
            }
            zaa(connectionResult2);
            this.zaei.disconnect();
        } else if (this.zaeo == null || !zab(this.zaep)) {
            ConnectionResult connectionResult3 = this.zaeo;
            if (connectionResult3 != null && (connectionResult = this.zaep) != null) {
                if (this.zaej.zahw < this.zaei.zahw) {
                    connectionResult3 = connectionResult;
                }
                zaa(connectionResult3);
            }
        } else {
            this.zaej.disconnect();
            zaa(this.zaeo);
        }
    }

    private final void zaw() {
        for (SignInConnectionListener onComplete : this.zael) {
            onComplete.onComplete();
        }
        this.zael.clear();
    }

    private final boolean zax() {
        ConnectionResult connectionResult = this.zaep;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    @Nullable
    private final PendingIntent zay() {
        if (this.zaem == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zaeh), this.zaem.getSignInIntent(), 134217728);
    }

    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public final void connect() {
        this.zaes = 2;
        this.zaeq = false;
        this.zaep = null;
        this.zaeo = null;
        this.zaei.connect();
        this.zaej.connect();
    }

    public final void disconnect() {
        this.zaep = null;
        this.zaeo = null;
        this.zaes = 0;
        this.zaei.disconnect();
        this.zaej.disconnect();
        zaw();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.zaej.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.zaei.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        if (!zaa((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return this.zaei.enqueue(t);
        }
        if (!zax()) {
            return this.zaej.enqueue(t);
        }
        t.setFailedResult(new Status(4, (String) null, zay()));
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        if (!zaa((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return this.zaei.execute(t);
        }
        if (!zax()) {
            return this.zaej.execute(t);
        }
        t.setFailedResult(new Status(4, (String) null, zay()));
        return t;
    }

    @Nullable
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        if (!this.zaek.get(api.getClientKey()).equals(this.zaej)) {
            return this.zaei.getConnectionResult(api);
        }
        if (zax()) {
            return new ConnectionResult(4, zay());
        }
        return this.zaej.getConnectionResult(api);
    }

    public final boolean isConnected() {
        this.zaer.lock();
        try {
            boolean z = true;
            if (!this.zaei.isConnected() || (!this.zaej.isConnected() && !zax() && this.zaes != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zaer.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zaer.lock();
        try {
            return this.zaes == 2;
        } finally {
            this.zaer.unlock();
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.zaer.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.zaej.isConnected()) {
                this.zael.add(signInConnectionListener);
                if (this.zaes == 0) {
                    this.zaes = 1;
                }
                this.zaep = null;
                this.zaej.connect();
                return true;
            }
            this.zaer.unlock();
            return false;
        } finally {
            this.zaer.unlock();
        }
    }

    public final void maybeSignOut() {
        this.zaer.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zaej.disconnect();
            this.zaep = new ConnectionResult(4);
            if (isConnecting) {
                new zar(this.zabl).post(new zat(this));
            } else {
                zaw();
            }
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zau() {
        this.zaei.zau();
        this.zaej.zau();
    }

    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    private final void zaa(ConnectionResult connectionResult) {
        int i2 = this.zaes;
        if (i2 != 1) {
            if (i2 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zaes = 0;
            }
            this.zaeh.zac(connectionResult);
        }
        zaw();
        this.zaes = 0;
    }

    /* access modifiers changed from: private */
    public final void zaa(int i2, boolean z) {
        this.zaeh.zab(i2, z);
        this.zaep = null;
        this.zaeo = null;
    }

    private final boolean zaa(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Api.AnyClientKey<? extends Api.AnyClient> clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.zaek.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        return this.zaek.get(clientKey).equals(this.zaej);
    }

    /* access modifiers changed from: private */
    public final void zaa(Bundle bundle) {
        Bundle bundle2 = this.zaen;
        if (bundle2 == null) {
            this.zaen = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }
}
