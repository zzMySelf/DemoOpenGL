package com.baidu.searchbox.ng.browser.init;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.ng.browser.NgWebViewConfig;
import com.baidu.searchbox.ng.browser.listener.BlinkInitListener;
import com.baidu.searchbox.security.action.IWarmConfirmAction;

public class WarmConfirmNg implements IWarmConfirmAction {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = NgWebViewConfig.GLOBAL_DEBUG;
    private static final String TAG = "WarmConfirmNg";

    public void doAction(final Context context) {
        if (BlinkInitHelper.getInstance(context).isBWebkitInited()) {
            BlinkInitHelper.getInstance(context).setCuid();
            BlinkInitHelper.getInstance(context).setZid();
            BlinkInitHelper.getInstance(context).setCuidCookie();
            BlinkInitHelper.getInstance(context).updateUserPrivacyConfirm2T7Kernel();
            if (DEBUG) {
                Log.i(TAG, "user agree WarmConfirm isBWebkitInited");
            }
        } else {
            BlinkInitHelper.getInstance(context).addBlinkInitListener(new BlinkInitListener() {
                public void onInitFinished() {
                    BlinkInitHelper.getInstance(context).setCuid();
                    BlinkInitHelper.getInstance(context).setZid();
                    BlinkInitHelper.getInstance(context).setCuidCookie();
                    BlinkInitHelper.getInstance(context).updateUserPrivacyConfirm2T7Kernel();
                    if (WarmConfirmNg.DEBUG) {
                        Log.i(WarmConfirmNg.TAG, "user agree WarmConfirm onInitFinished");
                    }
                }
            });
        }
        if (DEBUG) {
            Log.i(TAG, "user agree WarmConfirm!");
        }
    }
}
