package fe.qw.qw.p009switch.uk;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import fe.qw.qw.pf.de.Cif;
import fe.qw.qw.vvv.qw;
import java.util.List;

/* renamed from: fe.qw.qw.switch.uk.i  reason: invalid package */
public class i implements AnimatableValue<PointF, PointF> {

    /* renamed from: ad  reason: collision with root package name */
    public final ad f3499ad;
    public final ad qw;

    public i(ad adVar, ad adVar2) {
        this.qw = adVar;
        this.f3499ad = adVar2;
    }

    public List<qw<PointF>> ad() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    public boolean de() {
        return this.qw.de() && this.f3499ad.de();
    }

    public BaseKeyframeAnimation<PointF, PointF> qw() {
        return new Cif(this.qw.qw(), this.f3499ad.qw());
    }
}
