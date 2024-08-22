package fe.qw.qw.vvv;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import fe.qw.qw.de;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class qw<T> {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final T f3525ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public T f3526de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final Interpolator f3527fe;

    /* renamed from: i  reason: collision with root package name */
    public int f3528i;

    /* renamed from: if  reason: not valid java name */
    public float f119if;

    /* renamed from: o  reason: collision with root package name */
    public int f3529o;

    /* renamed from: pf  reason: collision with root package name */
    public float f3530pf;
    @Nullable
    public final de qw;

    /* renamed from: rg  reason: collision with root package name */
    public final float f3531rg;

    /* renamed from: switch  reason: not valid java name */
    public PointF f120switch;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public Float f3532th;

    /* renamed from: uk  reason: collision with root package name */
    public float f3533uk;
    public PointF when;

    /* renamed from: yj  reason: collision with root package name */
    public float f3534yj;

    public qw(de deVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.f3534yj = -3987645.8f;
        this.f3533uk = -3987645.8f;
        this.f3528i = 784923401;
        this.f3529o = 784923401;
        this.f3530pf = Float.MIN_VALUE;
        this.f119if = Float.MIN_VALUE;
        this.f120switch = null;
        this.when = null;
        this.qw = deVar;
        this.f3525ad = t;
        this.f3526de = t2;
        this.f3527fe = interpolator;
        this.f3531rg = f;
        this.f3532th = f2;
    }

    public float ad() {
        if (this.qw == null) {
            return 1.0f;
        }
        if (this.f119if == Float.MIN_VALUE) {
            if (this.f3532th == null) {
                this.f119if = 1.0f;
            } else {
                this.f119if = rg() + ((this.f3532th.floatValue() - this.f3531rg) / this.qw.rg());
            }
        }
        return this.f119if;
    }

    public float de() {
        if (this.f3533uk == -3987645.8f) {
            this.f3533uk = ((Float) this.f3526de).floatValue();
        }
        return this.f3533uk;
    }

    public int fe() {
        if (this.f3529o == 784923401) {
            this.f3529o = ((Integer) this.f3526de).intValue();
        }
        return this.f3529o;
    }

    public boolean qw(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= rg() && f < ad();
    }

    public float rg() {
        de deVar = this.qw;
        if (deVar == null) {
            return 0.0f;
        }
        if (this.f3530pf == Float.MIN_VALUE) {
            this.f3530pf = (this.f3531rg - deVar.ppp()) / this.qw.rg();
        }
        return this.f3530pf;
    }

    public float th() {
        if (this.f3534yj == -3987645.8f) {
            this.f3534yj = ((Float) this.f3525ad).floatValue();
        }
        return this.f3534yj;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f3525ad + ", endValue=" + this.f3526de + ", startFrame=" + this.f3531rg + ", endFrame=" + this.f3532th + ", interpolator=" + this.f3527fe + ExtendedMessageFormat.END_FE;
    }

    public boolean uk() {
        return this.f3527fe == null;
    }

    public int yj() {
        if (this.f3528i == 784923401) {
            this.f3528i = ((Integer) this.f3525ad).intValue();
        }
        return this.f3528i;
    }

    public qw(T t) {
        this.f3534yj = -3987645.8f;
        this.f3533uk = -3987645.8f;
        this.f3528i = 784923401;
        this.f3529o = 784923401;
        this.f3530pf = Float.MIN_VALUE;
        this.f119if = Float.MIN_VALUE;
        this.f120switch = null;
        this.when = null;
        this.qw = null;
        this.f3525ad = t;
        this.f3526de = t;
        this.f3527fe = null;
        this.f3531rg = Float.MIN_VALUE;
        this.f3532th = Float.valueOf(Float.MAX_VALUE);
    }
}
