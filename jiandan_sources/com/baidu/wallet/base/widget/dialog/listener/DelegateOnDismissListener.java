package com.baidu.wallet.base.widget.dialog.listener;

import android.content.DialogInterface;

public class DelegateOnDismissListener implements DialogInterface.OnDismissListener {
    public DialogInterface.OnDismissListener a;

    public DelegateOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.a = onDismissListener;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener = this.a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
            this.a = null;
        }
    }
}
