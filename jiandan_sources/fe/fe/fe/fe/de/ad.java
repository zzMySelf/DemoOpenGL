package fe.fe.fe.fe.de;

import java.math.BigInteger;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static byte[] f1833ad;
    public static byte[] qw;

    public static byte[] ad() {
        byte[] bArr = f1833ad;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(qw.f1835de).modPow(new BigInteger(qw.f1836fe), new BigInteger(qw.f1837rg)).toByteArray();
        f1833ad = byteArray;
        return byteArray;
    }

    public static byte[] qw() {
        byte[] bArr = qw;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(qw.qw).modPow(new BigInteger(qw.f1834ad), new BigInteger(qw.f1837rg)).toByteArray();
        qw = byteArray;
        return byteArray;
    }
}
