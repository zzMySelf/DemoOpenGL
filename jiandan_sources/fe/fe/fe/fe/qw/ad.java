package fe.fe.fe.fe.qw;

import java.security.SecureRandom;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static final SecureRandom f1852ad = new SecureRandom();
    public fe qw;

    public ad() {
        this.qw = null;
        this.qw = new fe(new qw(), 16);
    }

    public static byte[] de(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ad adVar = new ad();
        adVar.qw(1, bArr, bArr2);
        return adVar.ad(bArr3);
    }

    public static byte[] fe(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ad adVar = new ad();
        adVar.qw(2, bArr, bArr2);
        return adVar.ad(bArr3);
    }

    public final byte[] ad(byte[] bArr) {
        if (bArr != null) {
            return this.qw.rg(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }

    public void qw(int i2, byte[] bArr, byte[] bArr2) {
        this.qw.de(i2, bArr, bArr2, f1852ad);
    }
}
