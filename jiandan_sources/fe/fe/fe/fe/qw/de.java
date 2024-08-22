package fe.fe.fe.fe.qw;

import java.security.InvalidKeyException;

public class de extends rg {

    /* renamed from: fe  reason: collision with root package name */
    public byte[] f1853fe;

    /* renamed from: rg  reason: collision with root package name */
    public byte[] f1854rg;

    /* renamed from: th  reason: collision with root package name */
    public byte[] f1855th = null;

    public de(qw qwVar) {
        super(qwVar);
        int i2 = this.f1874ad;
        this.f1854rg = new byte[i2];
        this.f1853fe = new byte[i2];
    }

    public void ad(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        while (i2 < i5) {
            for (int i6 = 0; i6 < this.f1874ad; i6++) {
                this.f1854rg[i6] = (byte) (bArr[i6 + i2] ^ this.f1853fe[i6]);
            }
            this.qw.th(this.f1854rg, 0, bArr2, i4);
            System.arraycopy(bArr2, i4, this.f1853fe, 0, this.f1874ad);
            int i7 = this.f1874ad;
            i2 += i7;
            i4 += i7;
        }
    }

    public void de() {
        System.arraycopy(this.f1875de, 0, this.f1853fe, 0, this.f1874ad);
    }

    public void fe(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6 = i3 + i2;
        byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f1874ad) ? null : (byte[]) bArr.clone();
        while (i2 < i6) {
            this.qw.o(bArr, i2, this.f1854rg, 0);
            int i7 = 0;
            while (true) {
                i5 = this.f1874ad;
                if (i7 >= i5) {
                    break;
                }
                bArr2[i7 + i4] = (byte) (this.f1854rg[i7] ^ this.f1853fe[i7]);
                i7++;
            }
            byte[] bArr4 = this.f1853fe;
            if (bArr3 == null) {
                System.arraycopy(bArr, i2, bArr4, 0, i5);
            } else {
                System.arraycopy(bArr3, i2, bArr4, 0, i5);
            }
            int i8 = this.f1874ad;
            i2 += i8;
            i4 += i8;
        }
    }

    public void qw(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f1874ad) {
            throw new InvalidKeyException("Internal error");
        }
        this.f1875de = bArr2;
        de();
        this.qw.rg(z, str, bArr);
    }

    public void rg() {
        if (this.f1855th == null) {
            this.f1855th = new byte[this.f1874ad];
        }
        System.arraycopy(this.f1853fe, 0, this.f1855th, 0, this.f1874ad);
    }

    public void yj() {
        System.arraycopy(this.f1855th, 0, this.f1853fe, 0, this.f1874ad);
    }
}
