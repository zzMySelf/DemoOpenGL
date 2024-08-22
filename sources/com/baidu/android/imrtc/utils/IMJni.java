package com.baidu.android.imrtc.utils;

import android.util.Base64;

public class IMJni {
    private static String TAG = "IMJni";

    public static String transBDUID(String content) {
        try {
            byte[] encrypted = AESUtil.encrypt("2011121211143000", "AFD311832EDEEAEF", content.getBytes());
            if (encrypted != null) {
                return Base64.encodeToString(encrypted, 11);
            }
            return "";
        } catch (Exception e2) {
            LogUtils.e(TAG, "AES java exception");
            return "";
        }
    }
}
