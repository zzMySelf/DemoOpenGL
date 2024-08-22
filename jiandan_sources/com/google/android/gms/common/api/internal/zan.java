package com.google.android.gms.common.api.internal;

import android.app.Dialog;

public final class zan extends zabp {
    public final /* synthetic */ Dialog zaec;
    public final /* synthetic */ zal zaed;

    public zan(zal zal, Dialog dialog) {
        this.zaed = zal;
        this.zaec = dialog;
    }

    public final void zas() {
        this.zaed.zadl.zao();
        if (this.zaec.isShowing()) {
            this.zaec.dismiss();
        }
    }
}
