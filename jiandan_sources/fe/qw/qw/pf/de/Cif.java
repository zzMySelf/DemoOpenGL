package fe.qw.qw.pf.de;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import fe.qw.qw.vvv.qw;
import java.util.Collections;

/* renamed from: fe.qw.qw.pf.de.if  reason: invalid class name */
public class Cif extends BaseKeyframeAnimation<PointF, PointF> {

    /* renamed from: i  reason: collision with root package name */
    public final PointF f3368i = new PointF();

    /* renamed from: o  reason: collision with root package name */
    public final BaseKeyframeAnimation<Float, Float> f3369o;

    /* renamed from: pf  reason: collision with root package name */
    public final BaseKeyframeAnimation<Float, Float> f3370pf;

    public Cif(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.f3369o = baseKeyframeAnimation;
        this.f3370pf = baseKeyframeAnimation2;
        m235if(th());
    }

    /* renamed from: ggg */
    public PointF i(qw<PointF> qwVar, float f) {
        return this.f3368i;
    }

    /* renamed from: if  reason: not valid java name */
    public void m235if(float f) {
        this.f3369o.m0if(f);
        this.f3370pf.m0if(f);
        this.f3368i.set(this.f3369o.uk().floatValue(), this.f3370pf.uk().floatValue());
        for (int i2 = 0; i2 < this.qw.size(); i2++) {
            this.qw.get(i2).qw();
        }
    }

    /* renamed from: ppp */
    public PointF uk() {
        return i((qw<PointF>) null, 0.0f);
    }
}
