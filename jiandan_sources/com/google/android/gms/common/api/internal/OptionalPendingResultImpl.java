package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {
    public final BasePendingResult<R> zajt;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult) {
        this.zajt = (BasePendingResult) pendingResult;
    }

    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        this.zajt.addStatusListener(statusListener);
    }

    public final R await() {
        return this.zajt.await();
    }

    public final void cancel() {
        this.zajt.cancel();
    }

    public final R get() {
        if (isDone()) {
            return await(0, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public final boolean isCanceled() {
        return this.zajt.isCanceled();
    }

    public final boolean isDone() {
        return this.zajt.isReady();
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        this.zajt.setResultCallback(resultCallback);
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        return this.zajt.then(resultTransform);
    }

    public final Integer zal() {
        return this.zajt.zal();
    }

    public final R await(long j, TimeUnit timeUnit) {
        return this.zajt.await(j, timeUnit);
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        this.zajt.setResultCallback(resultCallback, j, timeUnit);
    }
}
