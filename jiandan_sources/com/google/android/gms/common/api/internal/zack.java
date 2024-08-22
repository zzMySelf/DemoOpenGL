package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public final class zack<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    public final Object zadp = new Object();
    public final WeakReference<GoogleApiClient> zadr;
    public ResultTransform<? super R, ? extends Result> zakr = null;
    public zack<? extends Result> zaks = null;
    public volatile ResultCallbacks<? super R> zakt = null;
    public PendingResult<R> zaku = null;
    public Status zakv = null;
    public final zacm zakw;
    public boolean zakx = false;

    public zack(WeakReference<GoogleApiClient> weakReference) {
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zadr = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        this.zakw = new zacm(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    public static void zab(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException unused) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                sb.toString();
            }
        }
    }

    private final void zabs() {
        if (this.zakr != null || this.zakt != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zadr.get();
            if (!(this.zakx || this.zakr == null || googleApiClient == null)) {
                googleApiClient.zaa(this);
                this.zakx = true;
            }
            Status status = this.zakv;
            if (status != null) {
                zae(status);
                return;
            }
            PendingResult<R> pendingResult = this.zaku;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    private final boolean zabu() {
        return (this.zakt == null || ((GoogleApiClient) this.zadr.get()) == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void zad(Status status) {
        synchronized (this.zadp) {
            this.zakv = status;
            zae(status);
        }
    }

    private final void zae(Status status) {
        synchronized (this.zadp) {
            if (this.zakr != null) {
                Status onFailure = this.zakr.onFailure(status);
                Preconditions.checkNotNull(onFailure, "onFailure must not return null");
                this.zaks.zad(onFailure);
            } else if (zabu()) {
                this.zakt.onFailure(status);
            }
        }
    }

    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.zadp) {
            boolean z = true;
            Preconditions.checkState(this.zakt == null, "Cannot call andFinally() twice.");
            if (this.zakr != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zakt = resultCallbacks;
            zabs();
        }
    }

    public final void onResult(R r) {
        synchronized (this.zadp) {
            if (!r.getStatus().isSuccess()) {
                zad(r.getStatus());
                zab(r);
            } else if (this.zakr != null) {
                zacb.zaaz().submit(new zacn(this, r));
            } else if (zabu()) {
                this.zakt.onSuccess(r);
            }
        }
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zack<? extends Result> zack;
        synchronized (this.zadp) {
            boolean z = true;
            Preconditions.checkState(this.zakr == null, "Cannot call then() twice.");
            if (this.zakt != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zakr = resultTransform;
            zack = new zack<>(this.zadr);
            this.zaks = zack;
            zabs();
        }
        return zack;
    }

    public final void zaa(PendingResult<?> pendingResult) {
        synchronized (this.zadp) {
            this.zaku = pendingResult;
            zabs();
        }
    }

    public final void zabt() {
        this.zakt = null;
    }
}
