package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

public final class zabh implements BackgroundDetector.BackgroundStateChangeListener {
    public final /* synthetic */ GoogleApiManager zaia;

    public zabh(GoogleApiManager googleApiManager) {
        this.zaia = googleApiManager;
    }

    public final void onBackgroundStateChanged(boolean z) {
        this.zaia.handler.sendMessage(this.zaia.handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
