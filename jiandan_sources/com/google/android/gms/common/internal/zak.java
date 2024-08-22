package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

public final class zak implements PendingResult.StatusListener {
    public final /* synthetic */ PendingResult zaph;
    public final /* synthetic */ TaskCompletionSource zapi;
    public final /* synthetic */ PendingResultUtil.ResultConverter zapj;
    public final /* synthetic */ PendingResultUtil.zaa zapk;

    public zak(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.zaa zaa) {
        this.zaph = pendingResult;
        this.zapi = taskCompletionSource;
        this.zapj = resultConverter;
        this.zapk = zaa;
    }

    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            this.zapi.setResult(this.zapj.convert(this.zaph.await(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.zapi.setException(this.zapk.zaf(status));
    }
}
