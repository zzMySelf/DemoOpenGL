package com.baidu.wallet.core.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.armor.SafePay;
import java.security.MessageDigest;

public final class VerSig {
    public static final int a = 0;

    public static int a(String str) {
        if ("MD5".equalsIgnoreCase(str)) {
            return 4;
        }
        if ("SHA-1".equalsIgnoreCase(str)) {
            return 5;
        }
        if ("SHA-256".equalsIgnoreCase(str)) {
            return 11;
        }
        if ("SHA-384".equalsIgnoreCase(str)) {
            return 12;
        }
        return "SHA-512".equalsIgnoreCase(str) ? 13 : 0;
    }

    public static boolean verify(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return verify(str.getBytes(), str2.getBytes(), str3);
    }

    public static boolean verify(byte[] bArr, byte[] bArr2, String str) {
        if (bArr == null || bArr2 == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] digest = MessageDigest.getInstance(str.toUpperCase()).digest(bArr2);
            if (SafePay.getInstance().rsaVerify(0, a(str), digest.length, digest, Base64.decode(bArr, 0)) == 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
