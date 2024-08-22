package fe.mmm.qw.j.vvv;

import android.text.TextUtils;
import fe.mmm.qw.i.qw;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class de {
    public static byte[] ad(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return de(str.getBytes(str2));
        } catch (UnsupportedEncodingException e) {
            qw.th("MD5Util", e.getMessage(), e);
            return null;
        }
    }

    public static byte[] de(byte[] bArr) {
        if (!(bArr == null || bArr.length == 0)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.reset();
                instance.update(bArr, 0, bArr.length);
                if (instance != null) {
                    return instance.digest();
                }
                return null;
            } catch (NoSuchAlgorithmException e) {
                qw.th("MD5Util", e.getMessage(), e);
            }
        }
        return null;
    }

    public static String fe(String str, boolean z) {
        byte[] qw = qw(str);
        return (qw == null || qw.length == 0) ? "" : ad.de(qw, z);
    }

    public static byte[] qw(String str) {
        return ad(str, "UTF-8");
    }

    public static String rg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes(), 0, str.length());
            if (instance != null) {
                return ad.qw(instance.digest());
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
            qw.th("MD5Util", e.getMessage(), e);
            return null;
        }
    }
}
