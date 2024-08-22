package com.baidu.wallet.base.widget.dialog.listener;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import com.baidu.wallet.core.utils.LogUtil;

public class DelegateOnCancleListener implements DialogInterface.OnCancelListener {
    public static final String a = "DelegateOnCancleListener";
    public Dialog b;
    public DialogInterface.OnCancelListener mOnCancleListener;

    public DelegateOnCancleListener(DialogInterface.OnCancelListener onCancelListener, Dialog dialog) {
        this.mOnCancleListener = onCancelListener;
        this.b = dialog;
        if (Build.VERSION.SDK_INT >= 12) {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    LogUtil.w(DelegateOnCancleListener.a, "onWindowAttached, dialog=" + this);
                }

                public void onViewDetachedFromWindow(View view) {
                    LogUtil.d(DelegateOnCancleListener.a, "Dialog.onWindowDetached");
                }
            });
        }
        this.b.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                LogUtil.d(DelegateOnCancleListener.a, "Dialog.onDismiss");
                Dialog unused = DelegateOnCancleListener.this.b = null;
                DelegateOnCancleListener.this.mOnCancleListener = null;
            }
        });
    }

    public void onCancel(DialogInterface dialogInterface) {
        LogUtil.d(a, "Dialog.onDismiss");
        DialogInterface.OnCancelListener onCancelListener = this.mOnCancleListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
