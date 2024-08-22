package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zaac implements PendingResult.StatusListener {
    public final /* synthetic */ zaz zafq;
    public final /* synthetic */ BasePendingResult zafr;

    public zaac(zaz zaz, BasePendingResult basePendingResult) {
        this.zafq = zaz;
        this.zafr = basePendingResult;
    }

    public final void onComplete(Status status) {
        this.zafq.zafm.remove(this.zafr);
    }
}
