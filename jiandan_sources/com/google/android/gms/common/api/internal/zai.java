package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zai extends zak {
    public final SparseArray<zaa> zacw = new SparseArray<>();

    public class zaa implements GoogleApiClient.OnConnectionFailedListener {
        public final int zadd;
        public final GoogleApiClient zade;
        public final GoogleApiClient.OnConnectionFailedListener zadf;

        public zaa(int i2, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zadd = i2;
            this.zade = googleApiClient;
            this.zadf = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            sb.toString();
            zai.this.zab(connectionResult, this.zadd);
        }
    }

    public zai(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zai zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zai zai = (zai) fragment.getCallbackOrNull("AutoManageHelper", zai.class);
        if (zai != null) {
            return zai;
        }
        return new zai(fragment);
    }

    @Nullable
    private final zaa zab(int i2) {
        if (this.zacw.size() <= i2) {
            return null;
        }
        SparseArray<zaa> sparseArray = this.zacw;
        return sparseArray.get(sparseArray.keyAt(i2));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i2 = 0; i2 < this.zacw.size(); i2++) {
            zaa zab = zab(i2);
            if (zab != null) {
                printWriter.append(str).append("GoogleApiClient #").print(zab.zadd);
                printWriter.println(":");
                zab.zade.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void onStart() {
        super.onStart();
        boolean z = this.zadh;
        String valueOf = String.valueOf(this.zacw);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        sb.toString();
        if (this.zadi.get() == null) {
            for (int i2 = 0; i2 < this.zacw.size(); i2++) {
                zaa zab = zab(i2);
                if (zab != null) {
                    zab.zade.connect();
                }
            }
        }
    }

    public void onStop() {
        super.onStop();
        for (int i2 = 0; i2 < this.zacw.size(); i2++) {
            zaa zab = zab(i2);
            if (zab != null) {
                zab.zade.disconnect();
            }
        }
    }

    public final void zam() {
        for (int i2 = 0; i2 < this.zacw.size(); i2++) {
            zaa zab = zab(i2);
            if (zab != null) {
                zab.zade.connect();
            }
        }
    }

    public final void zaa(int i2, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.zacw.indexOfKey(i2) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i2);
        Preconditions.checkState(z, sb.toString());
        zam zam = this.zadi.get();
        boolean z2 = this.zadh;
        String valueOf = String.valueOf(zam);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i2);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(valueOf);
        sb2.toString();
        this.zacw.put(i2, new zaa(i2, googleApiClient, onConnectionFailedListener));
        if (this.zadh && zam == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf2);
            sb3.toString();
            googleApiClient.connect();
        }
    }

    public final void zaa(int i2) {
        zaa zaa2 = this.zacw.get(i2);
        this.zacw.remove(i2);
        if (zaa2 != null) {
            zaa2.zade.unregisterConnectionFailedListener(zaa2);
            zaa2.zade.disconnect();
        }
    }

    public final void zaa(ConnectionResult connectionResult, int i2) {
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaa zaa2 = this.zacw.get(i2);
        if (zaa2 != null) {
            zaa(i2);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zaa2.zadf;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }
}
