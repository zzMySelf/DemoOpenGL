package com.dlife.ctaccountapi;

import com.baidu.android.common.security.AESUtil;
import com.baidu.apollon.heartbeat.a;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class t {
    public static final String a = "t";
    public static byte[] b = "0000000000000000".getBytes();

    static {
        "vrf5g7h0tededwx3".getBytes();
    }

    public static String a(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(b);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), AESUtil.ALGORITHM_NAME);
            Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
            instance.init(2, secretKeySpec, ivParameterSpec);
            byte[] doFinal = instance.doFinal(x.b(str));
            return doFinal != null ? new String(doFinal) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(b);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), AESUtil.ALGORITHM_NAME);
            Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
            byte[] bytes = str.getBytes(a.h);
            instance.init(1, secretKeySpec, ivParameterSpec);
            return x.a(instance.doFinal(bytes));
        } catch (Throwable unused) {
            return null;
        }
    }
}
