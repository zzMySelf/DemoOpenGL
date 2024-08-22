package com.dxmpay.wallet.base.widget.dialog.listener;

import android.content.DialogInterface;

public class DelegateOnDismissListener implements DialogInterface.OnDismissListener {

    /* renamed from: ad  reason: collision with root package name */
    public DialogInterface.OnDismissListener f4231ad;

    public DelegateOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f4231ad = onDismissListener;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener = this.f4231ad;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
            this.f4231ad = null;
        }
    }
}
