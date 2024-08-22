package com.baidu.searchbox.nps.utils;

import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignatureParser {
    public static String getSignature(Signature[] signArray) {
        byte[] signByteArray;
        if (signArray == null || (signByteArray = changeToByteArray(signArray)) == null) {
            return null;
        }
        return getMD5Code(signByteArray);
    }

    private static byte[] changeToByteArray(Signature[] signArray) {
        int len = 0;
        byte[] signByteArray = null;
        if (signArray != null) {
            for (Signature s : signArray) {
                len += s.toByteArray().length;
            }
            signByteArray = new byte[len];
            int dstPos = 0;
            for (Signature s2 : signArray) {
                byte[] src = s2.toByteArray();
                System.arraycopy(src, 0, signByteArray, dstPos, src.length);
                dstPos += src.length;
            }
        }
        return signByteArray;
    }

    private static String getMD5Code(byte[] signByteArray) {
        if (signByteArray == null) {
            return null;
        }
        try {
            byte[] signmd5 = MessageDigest.getInstance("MD5").digest(signByteArray);
            if (signmd5 == null) {
                return null;
            }
            String base64sign = Base64.encodeToString(signmd5, 0);
            if (base64sign != null) {
                return base64sign.replaceAll("\\s", "").replaceAll("\\\\", "rg").replaceAll("/", "lg");
            }
            return base64sign;
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }
}
