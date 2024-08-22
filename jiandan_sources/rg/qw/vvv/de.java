package rg.qw.vvv;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class de {
    public static String ad(String str) {
        if (str == null) {
            return null;
        }
        try {
            return qw(str.getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized String qw(byte[] bArr) {
        String sb;
        synchronized (de.class) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                byte[] digest = instance.digest();
                StringBuilder sb2 = new StringBuilder();
                for (byte b : digest) {
                    sb2.append(Integer.toHexString((b & 255) | -256).substring(6));
                }
                sb = sb2.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
        return sb;
    }
}
