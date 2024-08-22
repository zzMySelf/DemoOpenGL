package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

public final class zaj implements PendingResultUtil.ResultConverter<R, T> {
    public final /* synthetic */ Response zapg;

    public zaj(Response response) {
        this.zapg = response;
    }

    public final /* synthetic */ Object convert(Result result) {
        this.zapg.setResult(result);
        return this.zapg;
    }
}
