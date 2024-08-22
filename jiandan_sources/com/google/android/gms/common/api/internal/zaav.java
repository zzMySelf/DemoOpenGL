package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager;

public final class zaav implements GmsClientEventManager.GmsClientEventState {
    public final /* synthetic */ zaaw zagv;

    public zaav(zaaw zaaw) {
        this.zagv = zaaw;
    }

    public final Bundle getConnectionHint() {
        return null;
    }

    public final boolean isConnected() {
        return this.zagv.isConnected();
    }
}
