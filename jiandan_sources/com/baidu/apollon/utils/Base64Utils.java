package com.baidu.apollon.utils;

import android.os.Build;
import android.util.Base64;
import java.io.IOException;

public class Base64Utils {
    public static final Boolean a = Boolean.valueOf(Build.VERSION.SDK_INT >= 8);

    public static byte[] decode(byte[] bArr) {
        if (a.booleanValue()) {
            return Base64.decode(bArr, 2);
        }
        try {
            return com.baidu.apollon.utils.support.Base64.decode(bArr);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage());
        }
    }

    public static byte[] encode(byte[] bArr) {
        if (a.booleanValue()) {
            return Base64.encode(bArr, 2);
        }
        return com.baidu.apollon.utils.support.Base64.encodeBytesToBytes(bArr);
    }

    public static String encodeToString(byte[] bArr) {
        if (a.booleanValue()) {
            return Base64.encodeToString(bArr, 2);
        }
        return com.baidu.apollon.utils.support.Base64.encodeBytes(bArr);
    }

    public static byte[] decode(String str) {
        if (a.booleanValue()) {
            return Base64.decode(str, 2);
        }
        try {
            return com.baidu.apollon.utils.support.Base64.decode(str);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage());
        }
    }
}
