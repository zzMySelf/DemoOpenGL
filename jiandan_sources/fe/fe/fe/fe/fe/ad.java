package fe.fe.fe.fe.fe;

import com.baidu.cesium.c.d.d;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;

public final class ad {
    public static final SecureRandom qw = new SecureRandom();

    public static BigInteger ad(byte[] bArr, BigInteger bigInteger) {
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        if (bigInteger2.compareTo(bigInteger) < 0) {
            return bigInteger2;
        }
        throw new BadPaddingException("Message is larger than modulus");
    }

    public static byte[] de(BigInteger bigInteger, int i2) {
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        if (length == i2) {
            return byteArray;
        }
        if (length == i2 + 1 && byteArray[0] == 0) {
            byte[] bArr = new byte[i2];
            System.arraycopy(byteArray, 1, bArr, 0, i2);
            return bArr;
        } else if (length >= i2) {
            return null;
        } else {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(byteArray, 0, bArr2, i2 - length, length);
            return bArr2;
        }
    }

    public static byte[] fe(byte[] bArr, int i2, int i3) {
        if (i2 == 0 && i3 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    public static int qw(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) >> 3;
    }

    public static byte[] rg(byte[] bArr, d dVar) {
        return th(bArr, dVar.a(), dVar.b());
    }

    public static byte[] th(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        return de(ad(bArr, bigInteger).modPow(bigInteger2, bigInteger), qw(bigInteger));
    }
}
