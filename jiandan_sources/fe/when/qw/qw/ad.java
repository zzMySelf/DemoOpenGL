package fe.when.qw.qw;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.awt.geom.IllegalPathStateException;
import com.itextpdf.awt.geom.PathIterator;
import com.itextpdf.awt.geom.Shape;
import fe.when.qw.qw.rg;
import java.util.NoSuchElementException;

public final class ad implements Shape, Cloneable {

    /* renamed from: o  reason: collision with root package name */
    public static int[] f9905o = {2, 2, 4, 6, 0};

    /* renamed from: ad  reason: collision with root package name */
    public byte[] f9906ad;

    /* renamed from: i  reason: collision with root package name */
    public int f9907i;

    /* renamed from: th  reason: collision with root package name */
    public float[] f9908th;

    /* renamed from: uk  reason: collision with root package name */
    public int f9909uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f9910yj;

    public class qw implements PathIterator {

        /* renamed from: ad  reason: collision with root package name */
        public int f9911ad;

        /* renamed from: de  reason: collision with root package name */
        public ad f9912de;

        /* renamed from: fe  reason: collision with root package name */
        public AffineTransform f9913fe;
        public int qw;

        public qw(ad adVar, ad adVar2, AffineTransform affineTransform) {
            this.f9912de = adVar2;
            this.f9913fe = affineTransform;
        }

        public int ad(double[] dArr) {
            if (!isDone()) {
                byte b = this.f9912de.f9906ad[this.qw];
                int i2 = ad.f9905o[b];
                for (int i3 = 0; i3 < i2; i3++) {
                    dArr[i3] = (double) this.f9912de.f9908th[this.f9911ad + i3];
                }
                AffineTransform affineTransform = this.f9913fe;
                if (affineTransform != null) {
                    affineTransform.transform(dArr, 0, dArr, 0, i2 / 2);
                }
                this.f9911ad += i2;
                return b;
            }
            throw new NoSuchElementException(fe.when.qw.qw.uk.ad.qw("awt.4B"));
        }

        public int de(float[] fArr) {
            if (!isDone()) {
                ad adVar = this.f9912de;
                byte b = adVar.f9906ad[this.qw];
                int i2 = ad.f9905o[b];
                System.arraycopy(adVar.f9908th, this.f9911ad, fArr, 0, i2);
                AffineTransform affineTransform = this.f9913fe;
                if (affineTransform != null) {
                    affineTransform.transform(fArr, 0, fArr, 0, i2 / 2);
                }
                this.f9911ad += i2;
                return b;
            }
            throw new NoSuchElementException(fe.when.qw.qw.uk.ad.qw("awt.4B"));
        }

        public boolean isDone() {
            return this.qw >= this.f9912de.f9910yj;
        }

        public void next() {
            this.qw++;
        }

        public int qw() {
            return this.f9912de.yj();
        }
    }

    public ad() {
        this(1, 10);
    }

    public void ad(PathIterator pathIterator, boolean z) {
        int i2;
        while (!pathIterator.isDone()) {
            float[] fArr = new float[6];
            int de2 = pathIterator.de(fArr);
            if (de2 != 0) {
                if (de2 != 1) {
                    if (de2 == 2) {
                        pf(fArr[0], fArr[1], fArr[2], fArr[3]);
                    } else if (de2 == 3) {
                        th(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
                    } else if (de2 == 4) {
                        fe();
                    }
                    pathIterator.next();
                    z = false;
                }
            } else if (!z || (i2 = this.f9910yj) == 0) {
                o(fArr[0], fArr[1]);
                pathIterator.next();
                z = false;
            } else if (this.f9906ad[i2 - 1] != 4) {
                float[] fArr2 = this.f9908th;
                int i3 = this.f9909uk;
                if (fArr2[i3 - 2] == fArr[0] && fArr2[i3 - 1] == fArr[1]) {
                    pathIterator.next();
                    z = false;
                }
            }
            i(fArr[0], fArr[1]);
            pathIterator.next();
            z = false;
        }
    }

    public Object clone() {
        try {
            ad adVar = (ad) super.clone();
            adVar.f9906ad = (byte[]) this.f9906ad.clone();
            adVar.f9908th = (float[]) this.f9908th.clone();
            return adVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean contains(double d, double d2) {
        return uk(fe.when.qw.qw.yj.qw.th(this, d, d2));
    }

    public void de(int i2, boolean z) {
        if (!z || this.f9910yj != 0) {
            int i3 = this.f9910yj;
            byte[] bArr = this.f9906ad;
            if (i3 == bArr.length) {
                byte[] bArr2 = new byte[(i3 + 10)];
                System.arraycopy(bArr, 0, bArr2, 0, i3);
                this.f9906ad = bArr2;
            }
            int i4 = this.f9909uk;
            if (i4 + i2 > this.f9908th.length) {
                float[] fArr = new float[(i4 + Math.max(20, i2))];
                System.arraycopy(this.f9908th, 0, fArr, 0, this.f9909uk);
                this.f9908th = fArr;
                return;
            }
            return;
        }
        throw new IllegalPathStateException(fe.when.qw.qw.uk.ad.qw("awt.20A"));
    }

    public void fe() {
        int i2 = this.f9910yj;
        if (i2 == 0 || this.f9906ad[i2 - 1] != 4) {
            de(0, true);
            byte[] bArr = this.f9906ad;
            int i3 = this.f9910yj;
            this.f9910yj = i3 + 1;
            bArr[i3] = 4;
        }
    }

    public rg getBounds2D() {
        float f;
        float f2;
        float f3;
        float f4;
        int i2 = this.f9909uk;
        if (i2 == 0) {
            f4 = 0.0f;
            f3 = 0.0f;
            f2 = 0.0f;
            f = 0.0f;
        } else {
            int i3 = i2 - 1;
            float[] fArr = this.f9908th;
            int i4 = i3 - 1;
            float f5 = fArr[i3];
            int i5 = i4 - 1;
            f2 = fArr[i4];
            int i6 = i5;
            f3 = f5;
            f = f3;
            f4 = f2;
            while (i6 > 0) {
                float[] fArr2 = this.f9908th;
                int i7 = i6 - 1;
                float f6 = fArr2[i6];
                int i8 = i7 - 1;
                float f7 = fArr2[i7];
                if (f7 < f4) {
                    f4 = f7;
                } else if (f7 > f2) {
                    f2 = f7;
                }
                if (f6 < f3) {
                    f3 = f6;
                } else if (f6 > f) {
                    f = f6;
                }
                i6 = i8;
            }
        }
        return new rg.ad(f4, f3, f2 - f4, f - f3);
    }

    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new qw(this, this, affineTransform);
    }

    public void i(float f, float f2) {
        de(2, true);
        byte[] bArr = this.f9906ad;
        int i2 = this.f9910yj;
        this.f9910yj = i2 + 1;
        bArr[i2] = 1;
        float[] fArr = this.f9908th;
        int i3 = this.f9909uk;
        int i4 = i3 + 1;
        this.f9909uk = i4;
        fArr[i3] = f;
        this.f9909uk = i4 + 1;
        fArr[i4] = f2;
    }

    /* renamed from: if  reason: not valid java name */
    public void m1134if(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.f9907i = i2;
            return;
        }
        throw new IllegalArgumentException(fe.when.qw.qw.uk.ad.qw("awt.209"));
    }

    public boolean intersects(double d, double d2, double d3, double d4) {
        int i2 = fe.when.qw.qw.yj.qw.m1136if(this, d, d2, d3, d4);
        return i2 == 255 || uk(i2);
    }

    public void o(float f, float f2) {
        int i2 = this.f9910yj;
        if (i2 <= 0 || this.f9906ad[i2 - 1] != 0) {
            de(2, false);
            byte[] bArr = this.f9906ad;
            int i3 = this.f9910yj;
            this.f9910yj = i3 + 1;
            bArr[i3] = 0;
            float[] fArr = this.f9908th;
            int i4 = this.f9909uk;
            int i5 = i4 + 1;
            this.f9909uk = i5;
            fArr[i4] = f;
            this.f9909uk = i5 + 1;
            fArr[i5] = f2;
            return;
        }
        float[] fArr2 = this.f9908th;
        int i6 = this.f9909uk;
        fArr2[i6 - 2] = f;
        fArr2[i6 - 1] = f2;
    }

    public void pf(float f, float f2, float f3, float f4) {
        de(4, true);
        byte[] bArr = this.f9906ad;
        int i2 = this.f9910yj;
        this.f9910yj = i2 + 1;
        bArr[i2] = 2;
        float[] fArr = this.f9908th;
        int i3 = this.f9909uk;
        int i4 = i3 + 1;
        this.f9909uk = i4;
        fArr[i3] = f;
        int i5 = i4 + 1;
        this.f9909uk = i5;
        fArr[i4] = f2;
        int i6 = i5 + 1;
        this.f9909uk = i6;
        fArr[i5] = f3;
        this.f9909uk = i6 + 1;
        fArr[i6] = f4;
    }

    public Shape rg(AffineTransform affineTransform) {
        ad adVar = (ad) clone();
        if (affineTransform != null) {
            adVar.m1135switch(affineTransform);
        }
        return adVar;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1135switch(AffineTransform affineTransform) {
        float[] fArr = this.f9908th;
        affineTransform.transform(fArr, 0, fArr, 0, this.f9909uk / 2);
    }

    public void th(float f, float f2, float f3, float f4, float f5, float f6) {
        de(6, true);
        byte[] bArr = this.f9906ad;
        int i2 = this.f9910yj;
        this.f9910yj = i2 + 1;
        bArr[i2] = 3;
        float[] fArr = this.f9908th;
        int i3 = this.f9909uk;
        int i4 = i3 + 1;
        this.f9909uk = i4;
        fArr[i3] = f;
        int i5 = i4 + 1;
        this.f9909uk = i5;
        fArr[i4] = f2;
        int i6 = i5 + 1;
        this.f9909uk = i6;
        fArr[i5] = f3;
        int i7 = i6 + 1;
        this.f9909uk = i7;
        fArr[i6] = f4;
        int i8 = i7 + 1;
        this.f9909uk = i8;
        fArr[i7] = f5;
        this.f9909uk = i8 + 1;
        fArr[i8] = f6;
    }

    public boolean uk(int i2) {
        if (this.f9907i == 1) {
            return fe.when.qw.qw.yj.qw.when(i2);
        }
        return fe.when.qw.qw.yj.qw.m1137switch(i2);
    }

    public int yj() {
        return this.f9907i;
    }

    public ad(int i2) {
        this(i2, 10);
    }

    public boolean contains(double d, double d2, double d3, double d4) {
        int i2 = fe.when.qw.qw.yj.qw.m1136if(this, d, d2, d3, d4);
        return i2 != 255 && uk(i2);
    }

    public ad(int i2, int i3) {
        m1134if(i2);
        this.f9906ad = new byte[i3];
        this.f9908th = new float[(i3 * 2)];
    }
}
