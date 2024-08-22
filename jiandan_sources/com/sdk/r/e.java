package com.sdk.r;

import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.sdk.f.f;
import com.sdk.i.a;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class e extends a {
    public static final String a = "com.sdk.r.e";
    public static boolean b = f.a;

    public static String a(String str) {
        if (com.sdk.o.a.a(str).booleanValue()) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes(Charset.defaultCharset()));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception e) {
            a.a(a, LightappBusinessClient.MTD_ENCRYPT, e.getMessage(), b);
            return null;
        }
    }
}
