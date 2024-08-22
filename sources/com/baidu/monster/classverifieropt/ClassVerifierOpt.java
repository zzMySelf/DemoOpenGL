package com.baidu.monster.classverifieropt;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.baidu.android.util.soloader.SoLoader;

public class ClassVerifierOpt {
    private static final int CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;
    private static final boolean DEBUG = true;
    public static final int ERROR_CODE_CALL_GET_SYSTEM_CLASSLOADER_ERROR = -9;
    public static final int ERROR_CODE_DLOPEN_ERROR = -6;
    public static final int ERROR_CODE_DSYM_DISABLE_VERIFY_ERROR = -7;
    public static final int ERROR_CODE_DSYM_GET_SYSTEM_CLASSLOADER_ERROR = -8;
    public static final int ERROR_CODE_GET_CLASSLOADER_OFFSET_ERROR = -10;
    public static final int ERROR_CODE_JAVA_EXCEPTION = -2;
    public static final int ERROR_CODE_LOAD_SO_FAILED = -1;
    public static final int ERROR_CODE_PARAM_ERR = -5;
    public static final int ERROR_CODE_RUNTIME_MAP_ERROR = -11;
    public static final int ERROR_CODE_SET_VERIFY_FAILED = -3;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_UNSUPPORT = -4;
    private static final int MIN_SUPPORT_SDK_VERSION = 21;
    private static final String SO_NAME = "verifyopt";
    private static final String TAG = "ClassVerifierOpt";
    private static int sInitErrorCode;
    private static boolean sInited = false;
    private static int sTargetSdkVersion;

    private static native int nDisableClassVerifier(int i2, int i3);

    private static synchronized int ensureInited(Context c2) {
        boolean soloadSuccess;
        synchronized (ClassVerifierOpt.class) {
            if (c2 == null) {
                Log.d(TAG, "context is null");
                return -5;
            } else if (CURRENT_SDK_VERSION < 21) {
                Log.d(TAG, "unsupport sdk version:" + Build.VERSION.SDK_INT);
                return -4;
            } else if (sInited) {
                int i2 = sInitErrorCode;
                return i2;
            } else {
                try {
                    SoLoader.load(c2, SO_NAME);
                    soloadSuccess = SoLoader.isSoLoadedSucc(SO_NAME);
                    sTargetSdkVersion = c2.getApplicationInfo().targetSdkVersion;
                } catch (Throwable e2) {
                    e2.printStackTrace();
                    Log.e(TAG, "so load exception:" + e2.getMessage());
                    soloadSuccess = false;
                }
                Log.d(TAG, "so load state:" + soloadSuccess);
                int i3 = soloadSuccess ? 0 : -1;
                sInitErrorCode = i3;
                sInited = true;
                return i3;
            }
        }
    }

    public static int disableClassVerifier(Context c2) {
        int result;
        int initResult = ensureInited(c2);
        if (initResult < 0) {
            Log.d(TAG, "verify class init error:" + initResult);
            return initResult;
        }
        try {
            StringBuilder append = new StringBuilder().append("current sdk:");
            int i2 = CURRENT_SDK_VERSION;
            Log.d(TAG, append.append(i2).append(" target sdk:").append(sTargetSdkVersion).toString());
            result = nDisableClassVerifier(i2, sTargetSdkVersion);
        } catch (Throwable e2) {
            e2.printStackTrace();
            result = -2;
        }
        Log.d(TAG, "disableClassVerifier result:" + result);
        return result;
    }
}
