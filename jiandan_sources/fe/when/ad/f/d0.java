package fe.when.ad.f;

import com.itextpdf.text.ExceptionConverter;

public class d0 implements Comparable<d0> {

    /* renamed from: ad  reason: collision with root package name */
    public ad f9388ad;

    /* renamed from: th  reason: collision with root package name */
    public float f9389th;

    /* renamed from: yj  reason: collision with root package name */
    public float f9390yj = 1.0f;

    public d0(ad adVar, float f) {
        this.f9389th = f;
        this.f9388ad = adVar;
    }

    public static d0 ad() {
        try {
            return new d0(ad.fe("Helvetica", "Cp1252", false), 12.0f);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public ad fe() {
        return this.f9388ad;
    }

    public float i() {
        return o(32);
    }

    public float o(int i2) {
        return this.f9388ad.qqq(i2, this.f9389th) * this.f9390yj;
    }

    public float pf(String str) {
        return this.f9388ad.eee(str, this.f9389th) * this.f9390yj;
    }

    /* renamed from: qw */
    public int compareTo(d0 d0Var) {
        if (d0Var == null) {
            return -1;
        }
        try {
            if (this.f9388ad != d0Var.f9388ad) {
                return 1;
            }
            return uk() != d0Var.uk() ? 2 : 0;
        } catch (ClassCastException unused) {
            return -2;
        }
    }

    public float rg() {
        return this.f9390yj;
    }

    public void th(float f) {
        this.f9390yj = f;
    }

    public float uk() {
        return this.f9389th;
    }
}
