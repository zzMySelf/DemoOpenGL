package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zar;

public final class zaaz extends zar {
    public final /* synthetic */ zaaw zagv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaaz(zaaw zaaw, Looper looper) {
        super(looper);
        this.zagv = zaaw;
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.zagv.zaat();
        } else if (i2 != 2) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            sb.toString();
        } else {
            this.zagv.resume();
        }
    }
}
