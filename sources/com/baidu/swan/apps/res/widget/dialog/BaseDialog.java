package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.swan.apps.res.widget.configurable.ConfigurableDialog;
import com.baidu.swan.apps.view.Immersion.SwanAppImmersionHelper;

public class BaseDialog extends ConfigurableDialog {
    private boolean mImmersionEnabled = SwanAppImmersionHelper.SUPPORT_IMMERSION;

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
        this.mImmersionEnabled = SwanAppImmersionHelper.SUPPORT_IMMERSION && enable;
    }

    public void show() {
        if (this.mImmersionEnabled) {
            SwanAppImmersionHelper.setDialogImmersion(this);
        }
        boolean hasHideNavigationFlag = SwanAppImmersionHelper.hasHideNavigationFlag(this);
        if (hasHideNavigationFlag) {
            getWindow().setFlags(8, 8);
        }
        super.show();
        if (hasHideNavigationFlag) {
            getWindow().clearFlags(8);
        }
    }
}
