package fe.fe.nn.ppp;

import android.text.TextUtils;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import java.security.MessageDigest;

public final class uk {
    public static final String[] qw = {"0", "1", "2", "3", "4", BannerBaseItemInfo.TYPE_LOGIN, BannerBaseItemInfo.TYPE_SCHEME, "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String ad(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            String str3 = new String(str);
            try {
                return de(MessageDigest.getInstance("MD5").digest(str3.getBytes()));
            } catch (Throwable th2) {
                th = th2;
                str2 = str3;
                de.fe(th);
                return str2;
            }
        } catch (Throwable th3) {
            th = th3;
            de.fe(th);
            return str2;
        }
    }

    public static String de(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte qw2 : bArr) {
            stringBuffer.append(qw(qw2));
        }
        return stringBuffer.toString();
    }

    public static String fe(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        try {
            return de(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable th2) {
            de.fe(th2);
            return "";
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r3v0, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String qw(int r3) {
        /*
            if (r3 >= 0) goto L_0x0004
            int r3 = r3 + 256
        L_0x0004:
            int r0 = r3 / 16
            int r3 = r3 % 16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String[] r2 = qw
            r0 = r2[r0]
            r1.append(r0)
            r3 = r2[r3]
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.ppp.uk.qw(byte):java.lang.String");
    }

    public static byte[] rg(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (Throwable th2) {
            de.fe(th2);
            return null;
        }
    }
}
