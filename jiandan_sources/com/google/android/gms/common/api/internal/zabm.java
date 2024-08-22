package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;

public final class zabm implements BaseGmsClient.SignOutCallbacks {
    public final /* synthetic */ GoogleApiManager.zaa zaiq;

    public zabm(GoogleApiManager.zaa zaa) {
        this.zaiq = zaa;
    }

    public final void onSignOutComplete() {
        GoogleApiManager.this.handler.post(new zabl(this));
    }
}
