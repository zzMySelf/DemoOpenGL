package fe.qw.qw.p009switch;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: fe.qw.qw.switch.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final PointF f3493ad;

    /* renamed from: de  reason: collision with root package name */
    public final PointF f3494de;
    public final PointF qw;

    public qw() {
        this.qw = new PointF();
        this.f3493ad = new PointF();
        this.f3494de = new PointF();
    }

    public PointF ad() {
        return this.f3493ad;
    }

    public PointF de() {
        return this.f3494de;
    }

    public void fe(float f, float f2) {
        this.qw.set(f, f2);
    }

    public PointF qw() {
        return this.qw;
    }

    public void rg(float f, float f2) {
        this.f3493ad.set(f, f2);
    }

    public void th(float f, float f2) {
        this.f3494de.set(f, f2);
    }

    public qw(PointF pointF, PointF pointF2, PointF pointF3) {
        this.qw = pointF;
        this.f3493ad = pointF2;
        this.f3494de = pointF3;
    }
}
