package fe.when.ad.f;

import fe.when.ad.c.qw;

/* renamed from: fe.when.ad.f.switch  reason: invalid class name */
public class Cswitch extends ppp {

    /* renamed from: rg  reason: collision with root package name */
    public w f9772rg;

    /* renamed from: th  reason: collision with root package name */
    public float[] f9773th;

    public Cswitch(w wVar, float[] fArr) {
        super(6);
        if (wVar.de().length == fArr.length) {
            this.f9772rg = wVar;
            this.f9773th = fArr;
            return;
        }
        throw new RuntimeException(qw.ad("devicen.color.shall.have.the.same.number.of.colorants.as.the.destination.DeviceN.color.space", new Object[0]));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cswitch) {
            Cswitch switchR = (Cswitch) obj;
            int length = switchR.f9773th.length;
            float[] fArr = this.f9773th;
            if (length == fArr.length) {
                int i2 = 0;
                for (float f : fArr) {
                    if (f != switchR.f9773th[i2]) {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f9772rg.hashCode();
        for (float valueOf : this.f9773th) {
            hashCode ^= Float.valueOf(valueOf).hashCode();
        }
        return hashCode;
    }

    public w o() {
        return this.f9772rg;
    }

    public float[] pf() {
        return this.f9773th;
    }
}
