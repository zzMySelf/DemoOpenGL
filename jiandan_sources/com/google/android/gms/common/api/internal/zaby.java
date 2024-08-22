package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zaby implements RemoteCall {
    public final BiConsumer zakj;

    public zaby(BiConsumer biConsumer) {
        this.zakj = biConsumer;
    }

    public final void accept(Object obj, Object obj2) {
        this.zakj.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
    }
}
