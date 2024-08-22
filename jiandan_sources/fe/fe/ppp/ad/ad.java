package fe.fe.ppp.ad;

import android.util.Base64;
import com.baidu.pass.a;
import fe.fe.ppp.ad.fe;

public class ad implements a {
    public static byte[] ad(String str, String str2, String str3) throws Exception {
        return new fe.qw().ad(str, str2, str3);
    }

    public static byte[] de(byte[] bArr) {
        return Base64.decode(bArr, 0);
    }

    public static String fe(byte[] bArr) {
        return new fe().qw(bArr);
    }

    public static byte[] qw(byte[] bArr, String str, String str2) throws Exception {
        return new fe.qw().de(bArr, str, str2);
    }

    public static String rg(byte[] bArr, boolean z) {
        return new fe().de(bArr, z);
    }
}
