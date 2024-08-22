package fe.when.ad;

import java.net.URL;
import java.security.MessageDigest;

public class pf extends i {
    public byte[] X;

    public pf() {
        super((i) null);
    }

    public byte[] M0() {
        return this.X;
    }

    public pf(int i2, int i3, byte[] bArr, byte[] bArr2) {
        super((URL) null);
        this.qqq = 36;
        this.H = 9;
        float f = (float) i3;
        this.n = f;
        n(f);
        float f2 = (float) i2;
        this.m = f2;
        l(f2);
        this.tt = 1;
        this.N = 1;
        this.rrr = bArr;
        this.k = rrr();
        this.l = ggg();
        if (bArr2 != null) {
            this.X = bArr2;
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(this.X);
                instance.digest();
            } catch (Exception unused) {
            }
        }
    }
}
