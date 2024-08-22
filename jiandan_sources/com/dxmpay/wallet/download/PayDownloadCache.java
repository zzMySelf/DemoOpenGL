package com.dxmpay.wallet.download;

import android.content.Context;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.NoProguard;

public class PayDownloadCache implements NoProguard {
    public static final String PREF_FILE_NAME_FP = "__PAY_SDK_DOWNLOAD_FP";

    public static String getDownloadFileMd5Value(Context context, String str) {
        return (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, str, "");
    }

    public static void setDownloadFileMd5Value(Context context, String str, String str2) {
        SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, str, str2);
    }
}
