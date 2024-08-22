package com.dxmpay.wallet.base.widget.dialog.listener;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;

public class DelegateOnCancleListener implements DialogInterface.OnCancelListener {

    /* renamed from: ad  reason: collision with root package name */
    public Dialog f4229ad;
    public DialogInterface.OnCancelListener mOnCancleListener;

    public class ad implements DialogInterface.OnDismissListener {
        public ad() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            Dialog unused = DelegateOnCancleListener.this.f4229ad = null;
            DelegateOnCancleListener.this.mOnCancleListener = null;
        }
    }

    public class qw implements View.OnAttachStateChangeListener {
        public qw(DelegateOnCancleListener delegateOnCancleListener) {
        }

        public void onViewAttachedToWindow(View view) {
            "onWindowAttached, dialog=" + this;
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public DelegateOnCancleListener(DialogInterface.OnCancelListener onCancelListener, Dialog dialog) {
        this.mOnCancleListener = onCancelListener;
        this.f4229ad = dialog;
        if (Build.VERSION.SDK_INT >= 12) {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new qw(this));
        }
        this.f4229ad.setOnDismissListener(new ad());
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.mOnCancleListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
