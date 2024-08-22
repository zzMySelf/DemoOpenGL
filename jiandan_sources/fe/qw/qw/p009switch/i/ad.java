package fe.qw.qw.p009switch.i;

import fe.qw.qw.ggg.th;

/* renamed from: fe.qw.qw.switch.i.ad  reason: invalid package */
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public final int[] f3440ad;
    public final float[] qw;

    public ad(float[] fArr, int[] iArr) {
        this.qw = fArr;
        this.f3440ad = iArr;
    }

    public float[] ad() {
        return this.qw;
    }

    public int de() {
        return this.f3440ad.length;
    }

    public void fe(ad adVar, ad adVar2, float f) {
        if (adVar.f3440ad.length == adVar2.f3440ad.length) {
            for (int i2 = 0; i2 < adVar.f3440ad.length; i2++) {
                this.qw[i2] = th.pf(adVar.qw[i2], adVar2.qw[i2], f);
                this.f3440ad[i2] = fe.qw.qw.ggg.ad.de(f, adVar.f3440ad[i2], adVar2.f3440ad[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + adVar.f3440ad.length + " vs " + adVar2.f3440ad.length + ")");
    }

    public int[] qw() {
        return this.f3440ad;
    }
}
