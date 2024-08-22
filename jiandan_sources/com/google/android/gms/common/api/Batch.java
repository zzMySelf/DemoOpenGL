package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BasePendingResult<BatchResult> {
    public final Object mLock;
    public int zabc;
    public boolean zabd;
    public boolean zabe;
    public final PendingResult<?>[] zabf;

    public static final class Builder {
        public List<PendingResult<?>> zabg = new ArrayList();
        public GoogleApiClient zabh;

        public Builder(GoogleApiClient googleApiClient) {
            this.zabh = googleApiClient;
        }

        public final <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.zabg.size());
            this.zabg.add(pendingResult);
            return batchResultToken;
        }

        public final Batch build() {
            return new Batch(this.zabg, this.zabh, (zaa) null);
        }
    }

    public Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.mLock = new Object();
        int size = list.size();
        this.zabc = size;
        this.zabf = new PendingResult[size];
        if (list.isEmpty()) {
            setResult(new BatchResult(Status.RESULT_SUCCESS, this.zabf));
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            PendingResult<?> pendingResult = list.get(i2);
            this.zabf[i2] = pendingResult;
            pendingResult.addStatusListener(new zaa(this));
        }
    }

    public final void cancel() {
        super.cancel();
        for (PendingResult<?> cancel : this.zabf) {
            cancel.cancel();
        }
    }

    public final BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zabf);
    }

    public static /* synthetic */ int zab(Batch batch) {
        int i2 = batch.zabc;
        batch.zabc = i2 - 1;
        return i2;
    }

    public /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zaa zaa) {
        this(list, googleApiClient);
    }
}
