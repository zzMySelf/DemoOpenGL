package com.baidu.sapi2.utils;

import android.content.Context;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;

public class ProcessUtils implements NoProguard {
    public static String getAppProcessName(Context context) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation == null || !confignation.isAgreeDangerousProtocol()) {
            return "DEFAULT";
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable e2) {
            Log.e(e2);
            return "DEFAULT";
        }
    }
}
