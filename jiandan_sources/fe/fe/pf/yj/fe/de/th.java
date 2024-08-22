package fe.fe.pf.yj.fe.de;

import java.security.MessageDigest;

public class th {
    public static byte[] ad(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String de(byte[] bArr) {
        return qw.ad(ad(bArr), false);
    }

    public static byte[] qw(String str, String str2) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(str.getBytes(str2));
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}
