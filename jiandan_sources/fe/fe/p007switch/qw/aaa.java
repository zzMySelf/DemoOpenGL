package fe.fe.p007switch.qw;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: fe.fe.switch.qw.aaa  reason: invalid package */
public class aaa {
    public static RSAKey ad(boolean z, byte[] bArr) throws Exception {
        KeyFactory instance = KeyFactory.getInstance("RSA");
        if (z) {
            return (RSAPrivateKey) instance.generatePrivate(new PKCS8EncodedKeySpec(bArr));
        }
        return (RSAPublicKey) instance.generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static byte[] de(int i2, Key key, int i3, byte[] bArr) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(i2, key);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        while (i4 < bArr.length) {
            int length = bArr.length - i4;
            if (length > i3) {
                length = i3;
            }
            byteArrayOutputStream.write(instance.doFinal(bArr, i4, length));
            i4 += i3;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] fe(boolean z, byte[] bArr, byte[] bArr2) throws Exception {
        RSAKey ad2 = ad(z, bArr);
        return de(1, (Key) ad2, ((ad2.getModulus().bitLength() + 1) / 8) - 11, bArr2);
    }

    public static String qw(byte[] bArr) throws Exception {
        try {
            return ggg.fe(fe(false, vvv.qw(), bArr));
        } catch (Exception unused) {
            return "";
        }
    }
}
