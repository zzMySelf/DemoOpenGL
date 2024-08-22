package fe.fe.fe.fe.qw;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public int f1856ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public int f1857de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public int f1858fe = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1859i = false;
    public byte[] qw = null;

    /* renamed from: rg  reason: collision with root package name */
    public int f1860rg = 0;

    /* renamed from: th  reason: collision with root package name */
    public uk f1861th = null;

    /* renamed from: uk  reason: collision with root package name */
    public int f1862uk = 1;

    /* renamed from: yj  reason: collision with root package name */
    public rg f1863yj = null;

    public fe(qw qwVar, int i2) {
        this.f1856ad = i2;
        this.f1857de = i2;
        this.f1860rg = i2;
        this.qw = new byte[(i2 * 2)];
        this.f1863yj = new de(qwVar);
        this.f1861th = new yj(this.f1856ad);
    }

    public final int ad(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr == null || i4 == 0) {
            return 0;
        }
        int i5 = this.f1862uk;
        if (i5 == 2 || i5 == 3 || i4 % this.f1857de == 0 || i5 == 6) {
            if (this.f1859i) {
                this.f1863yj.uk(bArr, i2, i4, bArr2, i3);
            } else {
                this.f1863yj.th(bArr, i2, i4, bArr2, i3);
            }
            return i4;
        } else if (this.f1861th != null) {
            throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f1857de + " bytes");
        } else {
            throw new IllegalBlockSizeException("Input length not multiple of " + this.f1857de + " bytes");
        }
    }

    public void de(int i2, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        boolean z = i2 == 2 || i2 == 4;
        this.f1859i = z;
        if (this.f1862uk == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (!z) {
                if (secureRandom == null) {
                    secureRandom = ad.f1852ad;
                }
                bArr2 = new byte[this.f1856ad];
                secureRandom.nextBytes(bArr2);
            } else {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
        }
        this.f1858fe = 0;
        this.f1860rg = this.f1856ad;
        this.f1863yj.qw(this.f1859i, "", bArr, bArr2);
    }

    public int fe(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6;
        byte[] bArr3;
        int i7;
        uk ukVar;
        int i8 = i3;
        byte[] bArr4 = bArr2;
        int i9 = this.f1858fe + i8;
        int i10 = this.f1857de;
        int i11 = this.f1856ad;
        if (i10 != i11) {
            int i12 = this.f1860rg;
            i5 = i9 < i12 ? i12 - i9 : i11 - ((i9 - i12) % i11);
        } else {
            uk ukVar2 = this.f1861th;
            i5 = ukVar2 != null ? ukVar2.a(i9) : 0;
        }
        if (i5 <= 0 || i5 == this.f1856ad || this.f1861th == null || !this.f1859i) {
            int i13 = (this.f1859i || this.f1861th == null) ? i9 : i9 + i5;
            if (bArr4 != null) {
                int length = bArr4.length - i4;
                if (((!this.f1859i || this.f1861th == null) && length < i13) || (this.f1859i && length < i13 - this.f1856ad)) {
                    throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i13 + " bytes needed");
                }
                if (this.f1858fe != 0 || (!this.f1859i && this.f1861th != null)) {
                    byte[] bArr5 = new byte[i13];
                    int i14 = this.f1858fe;
                    if (i14 != 0) {
                        System.arraycopy(this.qw, 0, bArr5, 0, i14);
                    }
                    if (i8 != 0) {
                        System.arraycopy(bArr, i2, bArr5, this.f1858fe, i8);
                    }
                    if (!this.f1859i && (ukVar = this.f1861th) != null) {
                        ukVar.ad(bArr5, i9, i5);
                    }
                    bArr3 = bArr5;
                    i6 = 0;
                } else {
                    bArr3 = bArr;
                    i6 = i2;
                }
                if (this.f1859i) {
                    if (length < i13) {
                        this.f1863yj.rg();
                    }
                    byte[] bArr6 = new byte[i9];
                    i7 = ad(bArr3, i6, bArr6, 0, i9);
                    uk ukVar3 = this.f1861th;
                    if (ukVar3 != null && (i7 = ukVar3.qw(bArr6, 0, i7)) < 0) {
                        throw new BadPaddingException("Given final block not properly padded");
                    } else if (bArr4.length - i4 >= i7) {
                        for (int i15 = 0; i15 < i7; i15++) {
                            bArr4[i4 + i15] = bArr6[i15];
                        }
                    } else {
                        this.f1863yj.yj();
                        throw new ShortBufferException("Output buffer too short: " + (bArr4.length - i4) + " bytes given, " + i7 + " bytes needed");
                    }
                } else {
                    i7 = ad(bArr3, i6, bArr2, i4, i13);
                }
                this.f1858fe = 0;
                this.f1860rg = this.f1856ad;
                if (this.f1862uk != 0) {
                    this.f1863yj.de();
                }
                return i7;
            }
            throw new ShortBufferException("Output buffer is null");
        }
        throw new IllegalBlockSizeException("Input length must be multiple of " + this.f1856ad + " when decrypting with padded cipher");
    }

    public int qw(int i2) {
        int i3 = this.f1858fe + i2;
        uk ukVar = this.f1861th;
        if (ukVar == null || this.f1859i) {
            return i3;
        }
        int i4 = this.f1857de;
        int i5 = this.f1856ad;
        if (i4 == i5) {
            return i3 + ukVar.a(i3);
        }
        int i6 = this.f1860rg;
        return i3 < i6 ? i6 : (i3 + i5) - ((i3 - i6) % i5);
    }

    public byte[] rg(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = null;
        try {
            int qw2 = qw(i3);
            byte[] bArr3 = new byte[qw2];
            int fe2 = fe(bArr, i2, i3, bArr3, 0);
            if (fe2 >= qw2) {
                return bArr3;
            }
            bArr2 = new byte[fe2];
            if (fe2 != 0) {
                System.arraycopy(bArr3, 0, bArr2, 0, fe2);
            }
            return bArr2;
        } catch (ShortBufferException unused) {
        }
    }
}
