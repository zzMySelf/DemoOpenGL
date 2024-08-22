package com.baidu.apollon.utils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class a {
    public static final String a = "RSA";

    public static PublicKey a(byte[] bArr) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PrivateKey b(byte[] bArr) {
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(PublicKey publicKey, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("RSA");
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(PrivateKey privateKey, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("RSA");
            instance.init(2, privateKey);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
