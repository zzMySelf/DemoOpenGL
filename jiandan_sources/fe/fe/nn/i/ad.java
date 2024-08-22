package fe.fe.nn.i;

import com.baidu.android.common.security.AESUtil;
import fe.fe.nn.ppp.de;
import fe.fe.nn.ppp.uk;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ad {
    public static byte[] ad(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            try {
                if (bArr.length == 32 && bArr2 != null) {
                    if (bArr2.length != 0) {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESUtil.ALGORITHM_NAME);
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        byte[] bArr3 = new byte[16];
                        System.arraycopy(bArr, 8, bArr3, 0, 16);
                        instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                        byte[] bArr4 = new byte[(bArr2.length - 16)];
                        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                        return instance.doFinal(bArr4);
                    }
                }
            } catch (Throwable th2) {
                de.fe(th2);
                return null;
            }
        }
        return bArr2;
    }

    public static qw de(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length != 0) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESUtil.ALGORITHM_NAME);
                    Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    byte[] bArr3 = new byte[16];
                    System.arraycopy(bArr, 8, bArr3, 0, 16);
                    instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                    byte[] doFinal = instance.doFinal(bArr2);
                    byte[] rg2 = uk.rg(bArr2);
                    byte[] bArr4 = new byte[(doFinal.length + rg2.length)];
                    System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
                    System.arraycopy(rg2, 0, bArr4, doFinal.length, rg2.length);
                    return new qw(bArr, bArr4);
                }
            } catch (Throwable th2) {
                de.fe(th2);
            }
        }
        return null;
    }

    public static byte[] qw() {
        char[] cArr = new char[32];
        try {
            char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            for (int i2 = 0; i2 < 32; i2++) {
                int nextInt = new SecureRandom().nextInt(62);
                if (nextInt >= 0 && nextInt < charArray.length) {
                    cArr[i2] = charArray[nextInt];
                }
            }
        } catch (Throwable th2) {
            de.fe(th2);
        }
        return new String(cArr).getBytes();
    }
}
