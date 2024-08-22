package fe.fe.p007switch.qw;

import com.baidu.android.common.security.AESUtil;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: fe.fe.switch.qw.switch  reason: invalid class name and invalid package */
public class Cswitch {
    public static byte[] ad(int i2, byte[] bArr) throws Exception {
        int i3 = i2 - 1;
        if (i3 >= 0) {
            String[] strArr = vvv.qw;
            if (strArr.length > i3) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i3].getBytes(), AESUtil.ALGORITHM_NAME);
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(2, secretKeySpec);
                return instance.doFinal(bArr);
            }
        }
        return new byte[0];
    }

    public static String de(int i2, byte[] bArr) {
        try {
            return ggg.fe(qw(i2, bArr));
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] qw(int i2, byte[] bArr) throws Exception {
        int i3 = i2 - 1;
        if (i3 >= 0) {
            String[] strArr = vvv.qw;
            if (strArr.length > i3) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i3].getBytes(), AESUtil.ALGORITHM_NAME);
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(1, secretKeySpec);
                return instance.doFinal(bArr);
            }
        }
        return new byte[0];
    }
}
