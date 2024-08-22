package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.ac.FH;

public class SafeService {
    public static final int DEVICE_AUTH_TOKEN_EVENT_ID = 122;
    public static final int GET_ZID_DEFAULT_EVENT_ID = 120;
    public static final int SOFIRE_MODULE_ID = 1;
    public static final int SOFIRE_MODULE_ID_NFC = 100105;
    public static final String Tag = "SafeService";

    public static class SingletonContainer {
        public static SafeService mSingleInstance = new SafeService();
    }

    public static SafeService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public String getDeviceAuthToken(Context context, String str, String str2, int i2) {
        return FH.gt(context, str, str2, i2, (String) null);
    }

    public String getZidAndCheckSafe(Context context, String str, int i2) {
        String gzfi = FH.gzfi(context, str, i2);
        return TextUtils.isEmpty(gzfi) ? "NoZidYet" : gzfi;
    }

    public boolean init(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
            return true;
        } catch (Throwable th2) {
            Log.e(Tag, "init()", th2.toString());
            return false;
        }
    }

    public boolean isInitSuc(int i2) {
        return FH.isInitSuc(i2);
    }

    public SafeService() {
    }
}
