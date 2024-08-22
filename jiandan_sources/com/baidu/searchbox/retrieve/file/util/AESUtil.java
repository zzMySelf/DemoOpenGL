package com.baidu.searchbox.retrieve.file.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    public static class ModeNotMatchException extends Exception {
        public ModeNotMatchException() {
        }

        public ModeNotMatchException(String str) {
            super(str);
        }
    }

    public static byte[] qw(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.android.common.security.AESUtil.ALGORITHM_NAME);
        Cipher instance = Cipher.getInstance(com.baidu.android.common.security.AESUtil.TRANSFORMATION);
        instance.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }
}
