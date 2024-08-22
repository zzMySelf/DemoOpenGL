package fe.when.ad.f;

import com.itextpdf.awt.geom.AffineTransform;
import fe.when.ad.aaa;

public class o1 extends tt {

    /* renamed from: i  reason: collision with root package name */
    public float f9673i;

    /* renamed from: if  reason: not valid java name */
    public float f446if;

    /* renamed from: o  reason: collision with root package name */
    public float f9674o;

    /* renamed from: pf  reason: collision with root package name */
    public float f9675pf;

    public o1(float f, float f2, float f3, float f4, int i2) {
        super(new float[0]);
        this.f9673i = 0.0f;
        this.f9674o = 0.0f;
        this.f9675pf = 0.0f;
        this.f446if = 0.0f;
        if (i2 == 90 || i2 == 270) {
            this.f9673i = f2;
            this.f9674o = f;
            this.f9675pf = f4;
            this.f446if = f3;
        } else {
            this.f9673i = f;
            this.f9674o = f2;
            this.f9675pf = f3;
            this.f446if = f4;
        }
        super.qqq(new v0(this.f9673i));
        super.qqq(new v0(this.f9674o));
        super.qqq(new v0(this.f9675pf));
        super.qqq(new v0(this.f446if));
    }

    public boolean eee(float[] fArr) {
        return false;
    }

    public float k() {
        return this.f9674o;
    }

    public float l() {
        return this.f446if - this.f9674o;
    }

    public float m() {
        return this.f9673i;
    }

    public float n() {
        return this.f9675pf;
    }

    public float p() {
        return this.f446if;
    }

    public o1 q(AffineTransform affineTransform) {
        float[] fArr = {this.f9673i, this.f9674o, this.f9675pf, this.f446if};
        affineTransform.transform(fArr, 0, fArr, 0, 2);
        float[] fArr2 = {fArr[0], fArr[1], fArr[2], fArr[3]};
        if (fArr[0] > fArr[2]) {
            fArr2[0] = fArr[2];
            fArr2[2] = fArr[0];
        }
        if (fArr[1] > fArr[3]) {
            fArr2[1] = fArr[3];
            fArr2[3] = fArr[1];
        }
        return new o1(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
    }

    public boolean qqq(y0 y0Var) {
        return false;
    }

    public float r() {
        return this.f9675pf - this.f9673i;
    }

    public boolean rrr(int[] iArr) {
        return false;
    }

    public void tt(y0 y0Var) {
    }

    public o1(float f, float f2, float f3, float f4) {
        this(f, f2, f3, f4, 0);
    }

    public o1(float f, float f2) {
        this(0.0f, 0.0f, f, f2, 0);
    }

    public o1(aaa aaa, int i2) {
        this(aaa.vvv(), aaa.when(), aaa.ddd(), aaa.aaa(), i2);
    }

    public o1(aaa aaa) {
        this(aaa.vvv(), aaa.when(), aaa.ddd(), aaa.aaa(), 0);
    }
}
