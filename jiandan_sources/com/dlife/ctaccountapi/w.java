package com.dlife.ctaccountapi;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class w {
    public static final String a = "w";
    public static String b = "RSA/ECB/PKCS1Padding";

    public static String a(String str, RSAPublicKey rSAPublicKey) {
        byte[] a2 = a(rSAPublicKey, str.getBytes());
        return a2 != null ? x.a(a2) : "";
    }

    public static PublicKey a(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(u.a(str)));
    }

    public static RSAPublicKey a() {
        try {
            return (RSAPublicKey) a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4LlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5xtcdptFjAIcgIR7oAWQIDAQAB");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(RSAPublicKey rSAPublicKey, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance(b);
            instance.init(1, rSAPublicKey);
            return instance.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
