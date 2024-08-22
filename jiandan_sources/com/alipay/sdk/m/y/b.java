package com.alipay.sdk.m.y;

import com.alipay.sdk.m.z.a;
import java.security.MessageDigest;

public final class b {
    public static String a(String str) {
        try {
            if (a.a(str)) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < digest.length; i2++) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i2])}));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
