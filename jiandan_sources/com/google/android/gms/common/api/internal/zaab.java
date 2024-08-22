package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaab implements OnCompleteListener<TResult> {
    public final /* synthetic */ TaskCompletionSource zafp;
    public final /* synthetic */ zaz zafq;

    public zaab(zaz zaz, TaskCompletionSource taskCompletionSource) {
        this.zafq = zaz;
        this.zafp = taskCompletionSource;
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        this.zafq.zafn.remove(this.zafp);
    }
}
