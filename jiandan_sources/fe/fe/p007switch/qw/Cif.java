package fe.fe.p007switch.qw;

import android.annotation.SuppressLint;
import com.baidu.android.common.security.AESUtil;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: fe.fe.switch.qw.if  reason: invalid class name and invalid package */
public class Cif {
    @SuppressLint({"TrulyRandom"})
    public static byte[] ad(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESUtil.ALGORITHM_NAME);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr3);
    }

    public static byte[] de() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static byte[] qw() throws Exception {
        KeyGenerator instance = KeyGenerator.getInstance(AESUtil.ALGORITHM_NAME);
        instance.init(128, new SecureRandom());
        return instance.generateKey().getEncoded();
    }
}
