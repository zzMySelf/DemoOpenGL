package fe.th.de.rrr.o;

import java.util.Arrays;

public final class o {

    /* renamed from: ad  reason: collision with root package name */
    public final int[] f5343ad = new int[10];
    public int qw;

    public int ad(int i2) {
        return this.f5343ad[i2];
    }

    public int de() {
        if ((this.qw & 2) != 0) {
            return this.f5343ad[1];
        }
        return -1;
    }

    public int fe() {
        if ((this.qw & 128) != 0) {
            return this.f5343ad[7];
        }
        return 65535;
    }

    public o i(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f5343ad;
            if (i2 < iArr.length) {
                this.qw = (1 << i2) | this.qw;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    public int o() {
        return Integer.bitCount(this.qw);
    }

    public void qw() {
        this.qw = 0;
        Arrays.fill(this.f5343ad, 0);
    }

    public int rg(int i2) {
        return (this.qw & 16) != 0 ? this.f5343ad[4] : i2;
    }

    public int th(int i2) {
        return (this.qw & 32) != 0 ? this.f5343ad[5] : i2;
    }

    public void uk(o oVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (oVar.yj(i2)) {
                i(i2, oVar.ad(i2));
            }
        }
    }

    public boolean yj(int i2) {
        return ((1 << i2) & this.qw) != 0;
    }
}
