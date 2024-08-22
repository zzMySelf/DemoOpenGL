package com.sdk.q;

import com.sdk.f.f;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class a {
    public static final String a = "a";
    public static Boolean b = Boolean.valueOf(f.a);

    public static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(new com.sdk.h.a().a(str)));
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.toString(), b);
            return null;
        }
    }
}
