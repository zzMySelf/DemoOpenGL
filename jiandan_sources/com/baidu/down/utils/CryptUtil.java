package com.baidu.down.utils;

import android.content.Context;
import android.util.Base64;
import java.io.UnsupportedEncodingException;

public class CryptUtil {
    static {
        System.loadLibrary("AsyncSdk_v1");
    }

    public static byte[] ad(Context context, byte[] bArr) {
        return decrypt(context, bArr);
    }

    public static native byte[] decrypt(Context context, byte[] bArr);

    public static String qw(Context context, String str) {
        try {
            return new String(ad(context, Base64.decode(str.getBytes("UTF-8"), 0)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
