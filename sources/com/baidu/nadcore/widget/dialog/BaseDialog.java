package com.baidu.nadcore.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class BaseDialog extends Dialog {
    private boolean mImmersionEnabled = false;

    public BaseDialog(Context context) {
        super(context);
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BaseDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public void setEnableImmersion(boolean enable) {
        this.mImmersionEnabled = enable;
    }

    public void show() {
        super.show();
    }
}
