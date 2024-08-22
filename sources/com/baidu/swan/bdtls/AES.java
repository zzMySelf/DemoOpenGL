package com.baidu.swan.bdtls;

import android.content.Context;
import java.nio.charset.StandardCharsets;

public class AES {
    private static native byte[] advancedDecrypt(byte[] bArr, Object obj, String str);

    private static native byte[] advancedEncrypt(byte[] bArr, Object obj, String str);

    private static native byte[] decrypt(byte[] bArr, byte[] bArr2);

    private static native byte[] encrypt(byte[] bArr, byte[] bArr2);

    static {
        try {
            System.loadLibrary("bdtls");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static byte[] aesEncrypt(String content, byte[] key) {
        if (content != null && content.length() > 0) {
            return encrypt(content.getBytes(StandardCharsets.UTF_8), key);
        }
        return new byte[]{-1};
    }

    public static byte[] aesEncrypt(byte[] content, byte[] key) {
        if (content != null && content.length > 0) {
            return encrypt(content, key);
        }
        return new byte[]{-1};
    }

    public static byte[] aesEncrypt(byte[] content, Context context, String value) {
        if (content != null && content.length > 0 && context != null) {
            return advancedEncrypt(content, context, value);
        }
        return new byte[]{-1};
    }

    public static byte[] aesDecrypt(byte[] content, byte[] key) {
        if (content != null && content.length > 0) {
            return decrypt(content, key);
        }
        return new byte[]{-1};
    }

    public static byte[] aesDecrypt(byte[] content, Context context, String value) {
        if (content != null && content.length > 0 && context != null) {
            return advancedDecrypt(content, context, value);
        }
        return new byte[]{-1};
    }
}
