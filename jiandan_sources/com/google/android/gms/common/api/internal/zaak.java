package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zaak implements zabb {
    public final Context mContext;
    public final Api.AbstractClientBuilder<? extends zac, SignInOptions> zacf;
    public final Lock zaer;
    public final Map<Api<?>, Boolean> zaew;
    public final GoogleApiAvailabilityLight zaey;
    public final ClientSettings zafa;
    public ConnectionResult zafi;
    public final zabe zafv;
    public int zaga;
    public int zagb = 0;
    public int zagc;
    public final Bundle zagd = new Bundle();
    public final Set<Api.AnyClientKey> zage = new HashSet();
    public zac zagf;
    public boolean zagg;
    public boolean zagh;
    public boolean zagi;
    public IAccountAccessor zagj;
    public boolean zagk;
    public boolean zagl;
    public ArrayList<Future<?>> zagm = new ArrayList<>();

    public zaak(zabe zabe, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.zafv = zabe;
        this.zafa = clientSettings;
        this.zaew = map;
        this.zaey = googleApiAvailabilityLight;
        this.zacf = abstractClientBuilder;
        this.zaer = lock;
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public final void zaa(zak zak) {
        if (zac(0)) {
            ConnectionResult connectionResult = zak.getConnectionResult();
            if (connectionResult.isSuccess()) {
                ResolveAccountResponse zacv = zak.zacv();
                ConnectionResult connectionResult2 = zacv.getConnectionResult();
                if (!connectionResult2.isSuccess()) {
                    String valueOf = String.valueOf(connectionResult2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GACConnecting", sb.toString(), new Exception());
                    zae(connectionResult2);
                    return;
                }
                this.zagi = true;
                this.zagj = zacv.getAccountAccessor();
                this.zagk = zacv.getSaveDefaultAccount();
                this.zagl = zacv.isFromCrossClientAuth();
                zaan();
            } else if (zad(connectionResult)) {
                zaap();
                zaan();
            } else {
                zae(connectionResult);
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zaam() {
        int i2 = this.zagc - 1;
        this.zagc = i2;
        if (i2 > 0) {
            return false;
        }
        if (i2 < 0) {
            this.zafv.zaeh.zaaw();
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zae(new ConnectionResult(8, (PendingIntent) null));
            return false;
        }
        ConnectionResult connectionResult = this.zafi;
        if (connectionResult == null) {
            return true;
        }
        this.zafv.zahw = this.zaga;
        zae(connectionResult);
        return false;
    }

    /* access modifiers changed from: private */
    public final void zaan() {
        if (this.zagc == 0) {
            if (!this.zagh || this.zagi) {
                ArrayList arrayList = new ArrayList();
                this.zagb = 1;
                this.zagc = this.zafv.zahd.size();
                for (Api.AnyClientKey next : this.zafv.zahd.keySet()) {
                    if (!this.zafv.zaht.containsKey(next)) {
                        arrayList.add(this.zafv.zahd.get(next));
                    } else if (zaam()) {
                        zaao();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zagm.add(zabf.zaaz().submit(new zaaq(this, arrayList)));
                }
            }
        }
    }

    private final void zaao() {
        this.zafv.zaay();
        zabf.zaaz().execute(new zaaj(this));
        zac zac = this.zagf;
        if (zac != null) {
            if (this.zagk) {
                zac.zaa(this.zagj, this.zagl);
            }
            zab(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.zafv.zaht.keySet()) {
            this.zafv.zahd.get(anyClientKey).disconnect();
        }
        this.zafv.zahx.zab(this.zagd.isEmpty() ? null : this.zagd);
    }

    /* access modifiers changed from: private */
    public final void zaap() {
        this.zagh = false;
        this.zafv.zaeh.zahe = Collections.emptySet();
        for (Api.AnyClientKey next : this.zage) {
            if (!this.zafv.zaht.containsKey(next)) {
                this.zafv.zaht.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    private final void zaaq() {
        ArrayList<Future<?>> arrayList = this.zagm;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Future<?> future = arrayList.get(i2);
            i2++;
            future.cancel(true);
        }
        this.zagm.clear();
    }

    /* access modifiers changed from: private */
    public final Set<Scope> zaar() {
        if (this.zafa == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.zafa.getRequiredScopes());
        Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.zafa.getOptionalApiSettings();
        for (Api next : optionalApiSettings.keySet()) {
            if (!this.zafv.zaht.containsKey(next.getClientKey())) {
                hashSet.addAll(optionalApiSettings.get(next).mScopes);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r7 != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zab(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.Api<?> r6, boolean r7) {
        /*
            r4 = this;
            com.google.android.gms.common.api.Api$BaseClientBuilder r0 = r6.zah()
            int r0 = r0.getPriority()
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L_0x0024
            boolean r7 = r5.hasResolution()
            if (r7 == 0) goto L_0x0014
        L_0x0012:
            r7 = 1
            goto L_0x0022
        L_0x0014:
            com.google.android.gms.common.GoogleApiAvailabilityLight r7 = r4.zaey
            int r3 = r5.getErrorCode()
            android.content.Intent r7 = r7.getErrorResolutionIntent(r3)
            if (r7 == 0) goto L_0x0021
            goto L_0x0012
        L_0x0021:
            r7 = 0
        L_0x0022:
            if (r7 == 0) goto L_0x002d
        L_0x0024:
            com.google.android.gms.common.ConnectionResult r7 = r4.zafi
            if (r7 == 0) goto L_0x002c
            int r7 = r4.zaga
            if (r0 >= r7) goto L_0x002d
        L_0x002c:
            r1 = 1
        L_0x002d:
            if (r1 == 0) goto L_0x0033
            r4.zafi = r5
            r4.zaga = r0
        L_0x0033:
            com.google.android.gms.common.api.internal.zabe r7 = r4.zafv
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r7 = r7.zaht
            com.google.android.gms.common.api.Api$AnyClientKey r6 = r6.getClientKey()
            r7.put(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaak.zab(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    /* access modifiers changed from: private */
    public final boolean zac(int i2) {
        if (this.zagb == i2) {
            return true;
        }
        this.zafv.zaeh.zaaw();
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(valueOf);
        sb.toString();
        int i3 = this.zagc;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i3);
        sb2.toString();
        String zad = zad(this.zagb);
        String zad2 = zad(i2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(zad).length() + 70 + String.valueOf(zad2).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(zad);
        sb3.append(" but received callback for step ");
        sb3.append(zad2);
        sb3.toString();
        new Exception();
        zae(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    public static String zad(int i2) {
        return i2 != 0 ? i2 != 1 ? RomUtils.UNKNOWN : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* access modifiers changed from: private */
    public final boolean zad(ConnectionResult connectionResult) {
        return this.zagg && !connectionResult.hasResolution();
    }

    /* access modifiers changed from: private */
    public final void zae(ConnectionResult connectionResult) {
        zaaq();
        zab(!connectionResult.hasResolution());
        this.zafv.zaf(connectionResult);
        this.zafv.zahx.zac(connectionResult);
    }

    public final void begin() {
        this.zafv.zaht.clear();
        this.zagh = false;
        this.zafi = null;
        this.zagb = 0;
        this.zagg = true;
        this.zagi = false;
        this.zagk = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.zaew.keySet()) {
            Api.Client client = this.zafv.zahd.get(next.getClientKey());
            z |= next.zah().getPriority() == 1;
            boolean booleanValue = this.zaew.get(next).booleanValue();
            if (client.requiresSignIn()) {
                this.zagh = true;
                if (booleanValue) {
                    this.zage.add(next.getClientKey());
                } else {
                    this.zagg = false;
                }
            }
            hashMap.put(client, new zaam(this, next, booleanValue));
        }
        if (z) {
            this.zagh = false;
        }
        if (this.zagh) {
            this.zafa.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zafv.zaeh)));
            zaar zaar = new zaar(this, (zaaj) null);
            Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder = this.zacf;
            Context context = this.mContext;
            Looper looper = this.zafv.zaeh.getLooper();
            ClientSettings clientSettings = this.zafa;
            this.zagf = (zac) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), (GoogleApiClient.ConnectionCallbacks) zaar, (GoogleApiClient.OnConnectionFailedListener) zaar);
        }
        this.zagc = this.zafv.zahd.size();
        this.zagm.add(zabf.zaaz().submit(new zaal(this, hashMap)));
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        zaaq();
        zab(true);
        this.zafv.zaf((ConnectionResult) null);
        return true;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        this.zafv.zaeh.zafd.add(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void onConnected(Bundle bundle) {
        if (zac(1)) {
            if (bundle != null) {
                this.zagd.putAll(bundle);
            }
            if (zaam()) {
                zaao();
            }
        }
    }

    public final void onConnectionSuspended(int i2) {
        zae(new ConnectionResult(8, (PendingIntent) null));
    }

    private final void zab(boolean z) {
        zac zac = this.zagf;
        if (zac != null) {
            if (zac.isConnected() && z) {
                this.zagf.zacu();
            }
            this.zagf.disconnect();
            if (this.zafa.isSignInClientDisconnectFixEnabled()) {
                this.zagf = null;
            }
            this.zagj = null;
        }
    }

    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zac(1)) {
            zab(connectionResult, api, z);
            if (zaam()) {
                zaao();
            }
        }
    }
}
