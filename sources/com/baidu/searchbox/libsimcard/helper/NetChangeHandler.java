package com.baidu.searchbox.libsimcard.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.libsimcard.model.SimCardData;
import com.baidu.searchbox.libsimcard.util.SimCardConstants;

public class NetChangeHandler extends Handler {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int MSG_NETCHANGE = 100;
    public static final long MSG_NETCHANGE_DELAY = 1000;
    private static final String TAG = NetChangeHandler.class.getSimpleName();

    public NetChangeHandler(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg.what == 100) {
            ExecutorUtilsExt.getElasticExecutor(SimCardHelper.THREAD_NAME, 2).execute(new Runnable() {
                public void run() {
                    if (SimCardHelper.isFirstStartValidate) {
                        SimCardHelper.isFirstStartValidate = false;
                        NetChangeHandler.this.saveValidateResult(SimCardHelper.getInstance().validateByColdBoot());
                    } else {
                        NetChangeHandler.this.saveValidateResult(SimCardHelper.getInstance().validateByNetChange());
                    }
                    SimCardHelper.getInstance().notifySimCardObservers();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void saveValidateResult(SimCardData simCardData) {
        String simCardJson = SimCardData.toJsonObject(simCardData);
        if (DEBUG) {
            Log.d(TAG, "保存鉴权结果,simCardData=" + simCardJson);
        }
        new SharedPrefsWrapper("").putString(SimCardConstants.KEY_VALIDATE_RESULTKEY, simCardJson);
    }
}
