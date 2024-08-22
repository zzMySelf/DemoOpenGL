package com.alipay.sdk.m.l0;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.security.AESUtil;
import com.google.common.base.Ascii;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public class a {
    public static String a(String str) {
        byte[] bArr;
        try {
            bArr = a(a(), str.getBytes());
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr != null) {
            return a(bArr);
        }
        return null;
    }

    public static String b(String str) {
        try {
            return new String(b(a(), a(str)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] a() throws Exception {
        return e.a(new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 83, ExifInterface.MARKER_SOF14, -89, -84, -114, 80, 99, 10, 63, Ascii.SYN, -65, -11, Ascii.RS, 101, -118});
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESUtil.ALGORITHM_NAME);
        Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
        instance.init(2, secretKeySpec, new IvParameterSpec(b()));
        return instance.doFinal(bArr2);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESUtil.ALGORITHM_NAME);
        Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
        instance.init(1, secretKeySpec, new IvParameterSpec(b()));
        return instance.doFinal(bArr2);
    }

    public static byte[] b() {
        try {
            byte[] a = b.a("IUQSvE6r1TfFPdPEjfklLw==".getBytes("UTF-8"), 2);
            if (a != null) {
                return e.a(a);
            }
        } catch (Exception unused) {
        }
        return new byte[16];
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m5a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            a(stringBuffer, a);
        }
        return stringBuffer.toString();
    }

    public static void a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b & Ascii.SI));
    }
}
