package com.baidu.wallet.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import com.baidu.wallet.base.widget.LoadingDialog;
import com.baidu.wallet.core.BaseActivity;

@SuppressLint({"InlinedApi", "NewApi"})
public final class WalletGlobalUtils {
    public static Dialog a = null;
    public static String showStr = "";

    public static void DismissLoadingDialog() {
        Dialog dialog = a;
        if (dialog != null) {
            Context context = dialog.getContext();
            if (context instanceof ContextThemeWrapper) {
                context = ((ContextThemeWrapper) context).getBaseContext();
            }
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                try {
                    a.dismiss();
                } catch (Throwable th2) {
                    LogUtil.e("globalUtils", "dialog Exception", th2);
                }
                a = null;
            }
        }
    }

    public static void safeDismissDialog(BaseActivity baseActivity, int i2) {
        try {
            showStr = "";
            Activity activity = baseActivity.getActivity();
            if (activity != null && !activity.isFinishing()) {
                baseActivity.getActivity().removeDialog(i2);
            }
        } catch (Throwable th2) {
            LogUtil.e("globalUtils", "dialog Exception", th2);
        }
    }

    public static void safeShowDialog(BaseActivity baseActivity, int i2, String str) {
        try {
            showStr = str;
            baseActivity.getActivity().showDialog(i2);
        } catch (Exception unused) {
        }
    }

    public static void showLoadingDialog(Context context) {
        if (a == null) {
            a = new LoadingDialog(context);
        }
        a.show();
    }
}
