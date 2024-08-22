package com.cmic.sso.sdk.e;

import android.util.Base64;
import com.baidu.android.common.security.AESUtil;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {
    public static String a(byte[] bArr, String str, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESUtil.ALGORITHM_NAME);
            Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            return Base64.encodeToString(instance.doFinal(str.getBytes(com.baidu.apollon.heartbeat.a.h)), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(byte[] bArr, String str, byte[] bArr2) {
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESUtil.ALGORITHM_NAME);
            Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return new String(instance.doFinal(decode), com.baidu.apollon.heartbeat.a.h);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
