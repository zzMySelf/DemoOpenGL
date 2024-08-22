package fe.fe.pf.yj.fe.ad;

import java.math.BigInteger;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static byte[] f2968ad;
    public static byte[] qw;

    public static byte[] ad() {
        byte[] bArr = qw;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(de.qw).modPow(new BigInteger(de.f2964ad), new BigInteger(de.f2967rg)).toByteArray();
        qw = byteArray;
        return byteArray;
    }

    public static byte[] qw() {
        byte[] bArr = f2968ad;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(de.f2965de).modPow(new BigInteger(de.f2966fe), new BigInteger(de.f2967rg)).toByteArray();
        f2968ad = byteArray;
        return byteArray;
    }
}
