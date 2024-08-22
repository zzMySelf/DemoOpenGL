package com.baidu.sso.n;

import android.text.TextUtils;
import android.util.Base64;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESUtil */
public final class a {
    public static String a(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[32];
            new SecureRandom().nextBytes(bArr2);
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr2, 8, bArr3, 0, 16);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            byte[] doFinal = instance.doFinal(bArr);
            byte[] bArr4 = new byte[(doFinal.length + 32)];
            System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
            System.arraycopy(bArr2, 0, bArr4, doFinal.length, 32);
            return Base64.encodeToString(bArr4, 0);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] decode = Base64.decode(str, 0);
            if (decode == null) {
                return decode;
            }
            if (decode.length < 32) {
                return decode;
            }
            byte[] bArr = new byte[32];
            int length = decode.length - 32;
            byte[] bArr2 = new byte[length];
            System.arraycopy(decode, 0, bArr2, 0, length);
            System.arraycopy(decode, length, bArr, 0, 32);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, 8, bArr3, 0, 16);
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return instance.doFinal(bArr2);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }
}
