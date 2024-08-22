package com.baidu.android.imsdk.upload.action;

import android.annotation.SuppressLint;
import android.content.Context;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class IMPushUploadConstants {
    public static final String BIM_LOG_ID = "log-id";
    public static final int ERROR_CODE = -1;
    public static final String ONLINE_URL = "https://pimlog.baidu.com/LogService/PushIMLog";
    public static final String TAG = "BIMUploadUbc";
    public static final int VERSION = 1;

    public static class Service {
        public static final String BAIDU_APP = "baidu_app";
    }

    public static String md5(Context context, String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(b2));
            }
            "sign origin :" + str + ", md5: " + sb.toString();
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String sign(Context context, String str, long j) {
        return md5(context, String.format("%d%s%d", new Object[]{1, str.toLowerCase(), Long.valueOf(j)}));
    }
}
