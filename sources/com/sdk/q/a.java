package com.sdk.q;

import com.sdk.f.f;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5562a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f5563b = Boolean.valueOf(f.f5520a);

    public static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(new com.sdk.h.a().a(str)));
        } catch (Exception e2) {
            com.sdk.o.a.a(f5562a, e2.toString(), f5563b);
            return null;
        }
    }
}
