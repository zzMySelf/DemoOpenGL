package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

public final class zzaw implements ProxyApi.ProxyResult {
    public Status mStatus;
    public ProxyResponse zzch;

    public zzaw(ProxyResponse proxyResponse) {
        this.zzch = proxyResponse;
        this.mStatus = Status.RESULT_SUCCESS;
    }

    public final ProxyResponse getResponse() {
        return this.zzch;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public zzaw(Status status) {
        this.mStatus = status;
    }
}
