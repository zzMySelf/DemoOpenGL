package com.dxmpay.apollon.utils;

import android.os.Build;
import android.util.Base64;
import java.io.IOException;

public class Base64Utils {
    public static final Boolean qw = Boolean.valueOf(Build.VERSION.SDK_INT >= 8);

    public static byte[] decode(byte[] bArr) {
        if (qw.booleanValue()) {
            return Base64.decode(bArr, 2);
        }
        try {
            return com.dxmpay.apollon.utils.support.Base64.decode(bArr);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage());
        }
    }

    public static byte[] encode(byte[] bArr) {
        if (qw.booleanValue()) {
            return Base64.encode(bArr, 2);
        }
        return com.dxmpay.apollon.utils.support.Base64.encodeBytesToBytes(bArr);
    }

    public static String encodeToString(byte[] bArr) {
        if (qw.booleanValue()) {
            return Base64.encodeToString(bArr, 2);
        }
        return com.dxmpay.apollon.utils.support.Base64.encodeBytes(bArr);
    }

    public static byte[] decode(String str) {
        if (qw.booleanValue()) {
            return Base64.decode(str, 2);
        }
        try {
            return com.dxmpay.apollon.utils.support.Base64.decode(str);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage());
        }
    }
}
