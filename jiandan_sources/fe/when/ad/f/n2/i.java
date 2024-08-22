package fe.when.ad.f.n2;

import androidx.core.app.FrameMetricsAggregator;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import fe.when.ad.c.qw;

public class i {

    /* renamed from: ad  reason: collision with root package name */
    public byte[] f9571ad = null;

    /* renamed from: de  reason: collision with root package name */
    public byte[] f9572de;

    /* renamed from: fe  reason: collision with root package name */
    public int f9573fe;

    /* renamed from: i  reason: collision with root package name */
    public int f9574i;

    /* renamed from: if  reason: not valid java name */
    public int f432if = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f9575o;

    /* renamed from: pf  reason: collision with root package name */
    public int f9576pf = 0;
    public byte[][] qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9577rg = 9;

    /* renamed from: switch  reason: not valid java name */
    public int[] f433switch = {FrameMetricsAggregator.EVERY_DURATION, 1023, 2047, 4095};

    /* renamed from: th  reason: collision with root package name */
    public int f9578th;

    /* renamed from: uk  reason: collision with root package name */
    public int f9579uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f9580yj;

    public i(int i2, int i3, int i4) {
        this.f9579uk = i2;
        this.f9574i = i3;
        this.f9575o = i4;
    }

    public void ad(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b;
        byte[][] bArr3 = this.qw;
        int i2 = this.f9573fe;
        int i3 = i2 + 1;
        this.f9573fe = i3;
        bArr3[i2] = bArr2;
        if (i3 == 511) {
            this.f9577rg = 10;
        } else if (i3 == 1023) {
            this.f9577rg = 11;
        } else if (i3 == 2047) {
            this.f9577rg = 12;
        }
    }

    public byte[] de(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b;
        return bArr2;
    }

    public byte[] fe(byte[] bArr, byte[] bArr2, int i2) {
        if (bArr[0] == 0 && bArr[1] == 1) {
            throw new UnsupportedOperationException(qw.ad("tiff.5.0.style.lzw.codes.are.not.supported", new Object[0]));
        }
        th();
        this.f9571ad = bArr;
        this.f9572de = bArr2;
        this.f9578th = 0;
        this.f9580yj = 0;
        this.f9576pf = 0;
        this.f432if = 0;
        int i3 = 0;
        while (true) {
            int rg2 = rg();
            if (rg2 == 257 || this.f9580yj >= bArr2.length) {
                break;
            } else if (rg2 == 256) {
                th();
                i3 = rg();
                if (i3 == 257) {
                    break;
                }
                yj(this.qw[i3]);
            } else {
                if (rg2 < this.f9573fe) {
                    byte[] bArr3 = this.qw[rg2];
                    yj(bArr3);
                    ad(this.qw[i3], bArr3[0]);
                } else {
                    byte[] bArr4 = this.qw[i3];
                    byte[] de2 = de(bArr4, bArr4[0]);
                    yj(de2);
                    qw(de2);
                }
                i3 = rg2;
            }
        }
        if (this.f9574i == 2) {
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.f9575o;
                int i6 = ((this.f9579uk * i4) + 1) * i5;
                while (true) {
                    int i7 = this.f9579uk;
                    int i8 = this.f9575o;
                    if (i5 >= i7 * i8) {
                        break;
                    }
                    bArr2[i6] = (byte) (bArr2[i6] + bArr2[i6 - i8]);
                    i6++;
                    i5++;
                }
            }
        }
        return bArr2;
    }

    public void qw(byte[] bArr) {
        byte[][] bArr2 = this.qw;
        int i2 = this.f9573fe;
        int i3 = i2 + 1;
        this.f9573fe = i3;
        bArr2[i2] = bArr;
        if (i3 == 511) {
            this.f9577rg = 10;
        } else if (i3 == 1023) {
            this.f9577rg = 11;
        } else if (i3 == 2047) {
            this.f9577rg = 12;
        }
    }

    public int rg() {
        try {
            byte[] bArr = this.f9571ad;
            int i2 = this.f9578th;
            int i3 = i2 + 1;
            this.f9578th = i3;
            byte b = (this.f9576pf << 8) | (bArr[i2] & 255);
            this.f9576pf = b;
            int i4 = this.f432if + 8;
            this.f432if = i4;
            if (i4 < this.f9577rg) {
                byte[] bArr2 = this.f9571ad;
                this.f9578th = i3 + 1;
                this.f9576pf = (b << 8) | (bArr2[i3] & 255);
                this.f432if = i4 + 8;
            }
            int i5 = (this.f9576pf >> (this.f432if - this.f9577rg)) & this.f433switch[this.f9577rg - 9];
            this.f432if -= this.f9577rg;
            return i5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return 257;
        }
    }

    public void th() {
        this.qw = new byte[4096][];
        for (int i2 = 0; i2 < 256; i2++) {
            byte[][] bArr = this.qw;
            bArr[i2] = new byte[1];
            bArr[i2][0] = (byte) i2;
        }
        this.f9573fe = PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD;
        this.f9577rg = 9;
    }

    public void yj(byte[] bArr) {
        int length = this.f9572de.length - this.f9580yj;
        if (bArr.length < length) {
            length = bArr.length;
        }
        System.arraycopy(bArr, 0, this.f9572de, this.f9580yj, length);
        this.f9580yj += length;
    }
}
