package fe.fe.p007switch.qw;

import com.google.common.base.Ascii;
import java.security.MessageDigest;

/* renamed from: fe.fe.switch.qw.xxx  reason: invalid package */
public final class xxx {

    /* renamed from: fe.fe.switch.qw.xxx$qw */
    public static class qw {
        public static String qw(byte[] bArr) {
            try {
                return xxx.de(MessageDigest.getInstance("md5"), bArr);
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public static String ad(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] >> 4) & 15;
            byte b = bArr[i2] & Ascii.SI;
            sb.append((char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48));
            sb.append((char) (b >= 10 ? (b + 97) - 10 : b + 48));
        }
        return sb.toString();
    }

    public static String de(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        return ad(messageDigest.digest());
    }
}
