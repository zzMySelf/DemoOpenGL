package fe.when.ad.f;

import androidx.core.app.FrameMetricsAggregator;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.c.qw;
import java.io.IOException;
import java.io.OutputStream;

public class qqq {

    /* renamed from: ad  reason: collision with root package name */
    public byte[] f9729ad = null;

    /* renamed from: de  reason: collision with root package name */
    public OutputStream f9730de;

    /* renamed from: fe  reason: collision with root package name */
    public int f9731fe;

    /* renamed from: i  reason: collision with root package name */
    public int[] f9732i = {FrameMetricsAggregator.EVERY_DURATION, 1023, 2047, 4095};
    public byte[][] qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9733rg = 9;

    /* renamed from: th  reason: collision with root package name */
    public int f9734th;

    /* renamed from: uk  reason: collision with root package name */
    public int f9735uk = 0;

    /* renamed from: yj  reason: collision with root package name */
    public int f9736yj = 0;

    public void ad(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b;
        byte[][] bArr3 = this.qw;
        int i2 = this.f9731fe;
        int i3 = i2 + 1;
        this.f9731fe = i3;
        bArr3[i2] = bArr2;
        if (i3 == 511) {
            this.f9733rg = 10;
        } else if (i3 == 1023) {
            this.f9733rg = 11;
        } else if (i3 == 2047) {
            this.f9733rg = 12;
        }
    }

    public byte[] de(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b;
        return bArr2;
    }

    public void fe(byte[] bArr, OutputStream outputStream) {
        if (bArr[0] == 0 && bArr[1] == 1) {
            throw new RuntimeException(qw.ad("lzw.flavour.not.supported", new Object[0]));
        }
        th();
        this.f9729ad = bArr;
        this.f9730de = outputStream;
        this.f9734th = 0;
        this.f9736yj = 0;
        this.f9735uk = 0;
        int i2 = 0;
        while (true) {
            int rg2 = rg();
            if (rg2 == 257) {
                return;
            }
            if (rg2 == 256) {
                th();
                i2 = rg();
                if (i2 != 257) {
                    yj(this.qw[i2]);
                } else {
                    return;
                }
            } else {
                if (rg2 < this.f9731fe) {
                    byte[] bArr2 = this.qw[rg2];
                    yj(bArr2);
                    ad(this.qw[i2], bArr2[0]);
                } else {
                    byte[] bArr3 = this.qw[i2];
                    byte[] de2 = de(bArr3, bArr3[0]);
                    yj(de2);
                    qw(de2);
                }
                i2 = rg2;
            }
        }
    }

    public void qw(byte[] bArr) {
        byte[][] bArr2 = this.qw;
        int i2 = this.f9731fe;
        int i3 = i2 + 1;
        this.f9731fe = i3;
        bArr2[i2] = bArr;
        if (i3 == 511) {
            this.f9733rg = 10;
        } else if (i3 == 1023) {
            this.f9733rg = 11;
        } else if (i3 == 2047) {
            this.f9733rg = 12;
        }
    }

    public int rg() {
        try {
            byte[] bArr = this.f9729ad;
            int i2 = this.f9734th;
            int i3 = i2 + 1;
            this.f9734th = i3;
            byte b = (this.f9736yj << 8) | (bArr[i2] & 255);
            this.f9736yj = b;
            int i4 = this.f9735uk + 8;
            this.f9735uk = i4;
            if (i4 < this.f9733rg) {
                byte[] bArr2 = this.f9729ad;
                this.f9734th = i3 + 1;
                this.f9736yj = (b << 8) | (bArr2[i3] & 255);
                this.f9735uk = i4 + 8;
            }
            int i5 = (this.f9736yj >> (this.f9735uk - this.f9733rg)) & this.f9732i[this.f9733rg - 9];
            this.f9735uk -= this.f9733rg;
            return i5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return 257;
        }
    }

    public void th() {
        this.qw = new byte[8192][];
        for (int i2 = 0; i2 < 256; i2++) {
            byte[][] bArr = this.qw;
            bArr[i2] = new byte[1];
            bArr[i2][0] = (byte) i2;
        }
        this.f9731fe = PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD;
        this.f9733rg = 9;
    }

    public void yj(byte[] bArr) {
        try {
            this.f9730de.write(bArr);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }
}
