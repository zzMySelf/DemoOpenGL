package fe.when.ad.f.q2.ad;

import fe.when.ad.f.a0;
import fe.when.ad.f.k;
import fe.when.ad.f.v0;
import fe.when.ad.f.w1;
import fe.when.ad.f.y0;

public abstract class qw {

    /* renamed from: ad  reason: collision with root package name */
    public String f9726ad;

    /* renamed from: de  reason: collision with root package name */
    public int f9727de;
    public String qw;

    public static byte[] de(w1 w1Var) {
        byte[] th2 = w1Var.th();
        byte[] bArr = new byte[th2.length];
        System.arraycopy(th2, 0, bArr, 0, th2.length);
        return bArr;
    }

    public void ad(w1 w1Var, w1 w1Var2, y0 y0Var) {
        byte[] de2 = de(w1Var);
        byte[] de3 = de(w1Var2);
        if (de2.length != de3.length || de2.length == 0) {
            throw new IllegalArgumentException("Invalid map.");
        }
        byte[] bArr = null;
        boolean z = y0Var instanceof w1;
        if (z) {
            bArr = de((w1) y0Var);
        }
        byte b = de2[de2.length - 1] & 255;
        byte b2 = de3[de3.length - 1] & 255;
        for (int i2 = b; i2 <= b2; i2++) {
            de2[de2.length - 1] = (byte) i2;
            w1 w1Var3 = new w1(de2);
            w1Var3.eee(true);
            if (y0Var instanceof k) {
                qw(w1Var3, ((k) y0Var).g(i2 - b));
            } else if (y0Var instanceof v0) {
                qw(w1Var3, new v0((((v0) y0Var).eee() + i2) - b));
            } else if (z) {
                w1 w1Var4 = new w1(bArr);
                w1Var4.eee(true);
                int length = bArr.length - 1;
                bArr[length] = (byte) (bArr[length] + 1);
                qw(w1Var3, w1Var4);
            }
        }
    }

    public String fe(w1 w1Var) {
        if (w1Var.qqq()) {
            return a0.fe(w1Var.th(), "UnicodeBigUnmarked");
        }
        return w1Var.tt();
    }

    public void i(String str) {
        this.f9726ad = str;
    }

    public void o(String str) {
        this.qw = str;
    }

    public void pf(int i2) {
        this.f9727de = i2;
    }

    public abstract void qw(w1 w1Var, y0 y0Var);

    public String rg() {
        return this.f9726ad;
    }

    public String th() {
        return this.qw;
    }

    public void uk(String str) {
    }

    public int yj() {
        return this.f9727de;
    }
}
