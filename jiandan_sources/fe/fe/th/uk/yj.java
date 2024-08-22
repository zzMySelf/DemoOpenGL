package fe.fe.th.uk;

import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class yj {
    public static char[] qw = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String ad(File file, int i2) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[i2];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                messageDigest.update(bArr, 0, read);
            } else {
                fileInputStream.close();
                try {
                    return de(messageDigest.digest());
                } catch (Exception e) {
                    throw new IOException(e.toString());
                }
            }
        }
    }

    public static String de(byte[] bArr) {
        return fe(bArr, 0, bArr.length);
    }

    public static String fe(byte[] bArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(i3 * 2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            rg(bArr[i2], stringBuffer);
            i2++;
        }
        return stringBuffer.toString();
    }

    public static String qw(File file) {
        return ad(file, 131072);
    }

    public static void rg(byte b, StringBuffer stringBuffer) {
        char[] cArr = qw;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & Ascii.SI];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
