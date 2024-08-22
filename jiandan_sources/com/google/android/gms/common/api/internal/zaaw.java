package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zac;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zaaw extends GoogleApiClient implements zabs {
    public final Context mContext;
    public final Looper zabl;
    public final int zacc;
    public final GoogleApiAvailability zace;
    public final Api.AbstractClientBuilder<? extends zac, SignInOptions> zacf;
    public boolean zaci;
    public final Lock zaer;
    public final Map<Api<?>, Boolean> zaew;
    public final ClientSettings zafa;
    @VisibleForTesting
    public final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafd = new LinkedList();
    public final GmsClientEventManager zagw;
    public zabr zagx = null;
    public volatile boolean zagy;
    public long zagz;
    public long zaha;
    public final zaaz zahb;
    @VisibleForTesting
    public zabq zahc;
    public final Map<Api.AnyClientKey<?>, Api.Client> zahd;
    public Set<Scope> zahe;
    public final ListenerHolders zahf;
    public final ArrayList<zap> zahg;
    public Integer zahh;
    public Set<zack> zahi;
    public final zacp zahj;
    public final GmsClientEventManager.GmsClientEventState zahk;

    public zaaw(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i2, int i3, ArrayList<zap> arrayList, boolean z) {
        Looper looper2 = looper;
        int i4 = i2;
        this.zagz = ClientLibraryUtils.isPackageSide() ? 10000 : 120000;
        this.zaha = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.zahe = new HashSet();
        this.zahf = new ListenerHolders();
        this.zahh = null;
        this.zahi = null;
        zaav zaav = new zaav(this);
        this.zahk = zaav;
        this.mContext = context;
        this.zaer = lock;
        this.zaci = false;
        this.zagw = new GmsClientEventManager(looper, zaav);
        this.zabl = looper2;
        this.zahb = new zaaz(this, looper);
        this.zace = googleApiAvailability;
        this.zacc = i4;
        if (i4 >= 0) {
            this.zahh = Integer.valueOf(i3);
        }
        this.zaew = map;
        this.zahd = map2;
        this.zahg = arrayList;
        this.zahj = new zacp(this.zahd);
        for (GoogleApiClient.ConnectionCallbacks registerConnectionCallbacks : list) {
            this.zagw.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.zagw.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zafa = clientSettings;
        this.zacf = abstractClientBuilder;
    }

    /* access modifiers changed from: private */
    public final void resume() {
        this.zaer.lock();
        try {
            if (this.zagy) {
                zaas();
            }
        } finally {
            this.zaer.unlock();
        }
    }

    /* access modifiers changed from: private */
    public final void zaa(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        Common.zapw.zaa(googleApiClient).setResultCallback(new zaba(this, statusPendingResult, z, googleApiClient));
    }

    private final void zaas() {
        this.zagw.enableCallbacks();
        this.zagx.connect();
    }

    /* access modifiers changed from: private */
    public final void zaat() {
        this.zaer.lock();
        try {
            if (zaau()) {
                zaas();
            }
        } finally {
            this.zaer.unlock();
        }
    }

    private final void zae(int i2) {
        Integer num = this.zahh;
        if (num == null) {
            this.zahh = Integer.valueOf(i2);
        } else if (num.intValue() != i2) {
            String zaf = zaf(i2);
            String zaf2 = zaf(this.zahh.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(zaf).length() + 51 + String.valueOf(zaf2).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(zaf);
            sb.append(". Mode was already set to ");
            sb.append(zaf2);
            throw new IllegalStateException(sb.toString());
        }
        if (this.zagx == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.Client next : this.zahd.values()) {
                if (next.requiresSignIn()) {
                    z = true;
                }
                if (next.providesSignIn()) {
                    z2 = true;
                }
            }
            int intValue = this.zahh.intValue();
            if (intValue != 1) {
                if (intValue == 2 && z) {
                    if (this.zaci) {
                        this.zagx = new zav(this.mContext, this.zaer, this.zabl, this.zace, this.zahd, this.zafa, this.zaew, this.zacf, this.zahg, this, true);
                        return;
                    }
                    this.zagx = zaq.zaa(this.mContext, this, this.zaer, this.zabl, this.zace, this.zahd, this.zafa, this.zaew, this.zacf, this.zahg);
                    return;
                }
            } else if (!z) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            } else if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            if (!this.zaci || z2) {
                this.zagx = new zabe(this.mContext, this, this.zaer, this.zabl, this.zace, this.zahd, this.zafa, this.zaew, this.zacf, this.zahg, this);
                return;
            }
            this.zagx = new zav(this.mContext, this.zaer, this.zabl, this.zace, this.zahd, this.zafa, this.zaew, this.zacf, this.zahg, this, false);
        }
    }

    public static String zaf(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? RomUtils.UNKNOWN : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    public final ConnectionResult blockingConnect() {
        boolean z = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zaer.lock();
        try {
            if (this.zacc >= 0) {
                if (this.zahh == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zahh == null) {
                this.zahh = Integer.valueOf(zaa(this.zahd.values(), false));
            } else if (this.zahh.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zae(this.zahh.intValue());
            this.zagw.enableCallbacks();
            return this.zagx.blockingConnect();
        } finally {
            this.zaer.unlock();
        }
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Preconditions.checkState(this.zahh.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult((GoogleApiClient) this);
        if (this.zahd.containsKey(Common.CLIENT_KEY)) {
            zaa(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(Common.API).addConnectionCallbacks(new zaay(this, atomicReference, statusPendingResult)).addOnConnectionFailedListener(new zaax(this, statusPendingResult)).setHandler(this.zahb).build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    public final void connect() {
        this.zaer.lock();
        try {
            boolean z = false;
            if (this.zacc >= 0) {
                if (this.zahh != null) {
                    z = true;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zahh == null) {
                this.zahh = Integer.valueOf(zaa(this.zahd.values(), false));
            } else if (this.zahh.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zahh.intValue());
        } finally {
            this.zaer.unlock();
        }
    }

    public final void disconnect() {
        this.zaer.lock();
        try {
            this.zahj.release();
            if (this.zagx != null) {
                this.zagx.disconnect();
            }
            this.zahf.release();
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : this.zafd) {
                apiMethodImpl.zaa((zacq) null);
                apiMethodImpl.cancel();
            }
            this.zafd.clear();
            if (this.zagx != null) {
                zaau();
                this.zagw.disableCallbacks();
                this.zaer.unlock();
            }
        } finally {
            this.zaer.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.mContext);
        printWriter.append(str).append("mResuming=").print(this.zagy);
        printWriter.append(" mWorkQueue.size()=").print(this.zafd.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zahj.zald.size());
        zabr zabr = this.zagx;
        if (zabr != null) {
            zabr.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.zahd.containsKey(t.getClientKey());
        String name = t.getApi() != null ? t.getApi().getName() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(name);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        this.zaer.lock();
        try {
            if (this.zagx == null) {
                this.zafd.add(t);
                return t;
            }
            T enqueue = this.zagx.enqueue(t);
            this.zaer.unlock();
            return enqueue;
        } finally {
            this.zaer.unlock();
        }
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.zahd.containsKey(t.getClientKey());
        String name = t.getApi() != null ? t.getApi().getName() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(name);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        this.zaer.lock();
        try {
            if (this.zagx == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            } else if (this.zagy) {
                this.zafd.add(t);
                while (!this.zafd.isEmpty()) {
                    BaseImplementation.ApiMethodImpl remove = this.zafd.remove();
                    this.zahj.zac(remove);
                    remove.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
                return t;
            } else {
                T execute = this.zagx.execute(t);
                this.zaer.unlock();
                return execute;
            }
        } finally {
            this.zaer.unlock();
        }
    }

    @NonNull
    public final <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> anyClientKey) {
        C c = (Api.Client) this.zahd.get(anyClientKey);
        Preconditions.checkNotNull(c, "Appropriate Api was not requested.");
        return c;
    }

    @NonNull
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.zaer.lock();
        try {
            if (!isConnected()) {
                if (!this.zagy) {
                    throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                }
            }
            if (this.zahd.containsKey(api.getClientKey())) {
                ConnectionResult connectionResult = this.zagx.getConnectionResult(api);
                if (connectionResult != null) {
                    this.zaer.unlock();
                    return connectionResult;
                } else if (this.zagy) {
                    return ConnectionResult.RESULT_SUCCESS;
                } else {
                    zaaw();
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    ConnectionResult connectionResult2 = new ConnectionResult(8, (PendingIntent) null);
                    this.zaer.unlock();
                    return connectionResult2;
                }
            } else {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
        } finally {
            this.zaer.unlock();
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zabl;
    }

    public final boolean hasApi(@NonNull Api<?> api) {
        return this.zahd.containsKey(api.getClientKey());
    }

    public final boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.Client client;
        if (isConnected() && (client = this.zahd.get(api.getClientKey())) != null && client.isConnected()) {
            return true;
        }
        return false;
    }

    public final boolean isConnected() {
        zabr zabr = this.zagx;
        return zabr != null && zabr.isConnected();
    }

    public final boolean isConnecting() {
        zabr zabr = this.zagx;
        return zabr != null && zabr.isConnecting();
    }

    public final boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zagw.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zagw.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zabr zabr = this.zagx;
        return zabr != null && zabr.maybeSignIn(signInConnectionListener);
    }

    public final void maybeSignOut() {
        zabr zabr = this.zagx;
        if (zabr != null) {
            zabr.maybeSignOut();
        }
    }

    public final void reconnect() {
        disconnect();
        connect();
    }

    public final void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zagw.registerConnectionCallbacks(connectionCallbacks);
    }

    public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zagw.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public final <L> ListenerHolder<L> registerListener(@NonNull L l) {
        this.zaer.lock();
        try {
            return this.zahf.zaa(l, this.zabl, "NO_TYPE");
        } finally {
            this.zaer.unlock();
        }
    }

    public final void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        if (this.zacc >= 0) {
            zai.zaa(lifecycleActivity).zaa(this.zacc);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public final void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zagw.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zagw.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public final boolean zaau() {
        if (!this.zagy) {
            return false;
        }
        this.zagy = false;
        this.zahb.removeMessages(2);
        this.zahb.removeMessages(1);
        zabq zabq = this.zahc;
        if (zabq != null) {
            zabq.unregister();
            this.zahc = null;
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    public final boolean zaav() {
        this.zaer.lock();
        try {
            if (this.zahi == null) {
                this.zaer.unlock();
                return false;
            }
            boolean z = !this.zahi.isEmpty();
            this.zaer.unlock();
            return z;
        } catch (Throwable th2) {
            this.zaer.unlock();
            throw th2;
        }
    }

    public final String zaaw() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    public final void zab(Bundle bundle) {
        while (!this.zafd.isEmpty()) {
            execute(this.zafd.remove());
        }
        this.zagw.onConnectionSuccess(bundle);
    }

    public final void zac(ConnectionResult connectionResult) {
        if (!this.zace.isPlayServicesPossiblyUpdating(this.mContext, connectionResult.getErrorCode())) {
            zaau();
        }
        if (!this.zagy) {
            this.zagw.onConnectionFailure(connectionResult);
            this.zagw.disableCallbacks();
        }
    }

    public final void zaa(zack zack) {
        this.zaer.lock();
        try {
            if (this.zahi == null) {
                this.zahi = new HashSet();
            }
            this.zahi.add(zack);
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zab(int i2, boolean z) {
        if (i2 == 1 && !z && !this.zagy) {
            this.zagy = true;
            if (this.zahc == null && !ClientLibraryUtils.isPackageSide()) {
                try {
                    this.zahc = this.zace.zaa(this.mContext.getApplicationContext(), (zabp) new zabc(this));
                } catch (SecurityException unused) {
                }
            }
            zaaz zaaz = this.zahb;
            zaaz.sendMessageDelayed(zaaz.obtainMessage(1), this.zagz);
            zaaz zaaz2 = this.zahb;
            zaaz2.sendMessageDelayed(zaaz2.obtainMessage(2), this.zaha);
        }
        this.zahj.zabv();
        this.zagw.onUnintentionalDisconnection(i2);
        this.zagw.disableCallbacks();
        if (i2 == 2) {
            zaas();
        }
    }

    public static int zaa(Iterable<Api.Client> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.Client next : iterable) {
            if (next.requiresSignIn()) {
                z2 = true;
            }
            if (next.providesSignIn()) {
                z3 = true;
            }
        }
        if (!z2) {
            return 3;
        }
        if (!z3 || !z) {
            return 1;
        }
        return 2;
    }

    public final void connect(int i2) {
        this.zaer.lock();
        boolean z = true;
        if (!(i2 == 3 || i2 == 1 || i2 == 2)) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i2);
            Preconditions.checkArgument(z, sb.toString());
            zae(i2);
            zaas();
        } finally {
            this.zaer.unlock();
        }
    }

    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zaer.lock();
        try {
            if (this.zahh == null) {
                this.zahh = Integer.valueOf(zaa(this.zahd.values(), false));
            } else if (this.zahh.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zae(this.zahh.intValue());
            this.zagw.enableCallbacks();
            return this.zagx.blockingConnect(j, timeUnit);
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zab(zack zack) {
        this.zaer.lock();
        try {
            if (this.zahi == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zahi.remove(zack)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zaav()) {
                this.zagx.zau();
            }
        } finally {
            this.zaer.unlock();
        }
    }
}
