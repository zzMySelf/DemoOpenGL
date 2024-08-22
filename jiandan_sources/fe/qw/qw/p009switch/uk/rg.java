package fe.qw.qw.p009switch.uk;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import fe.qw.qw.pf.de.i;
import fe.qw.qw.pf.de.uk;
import fe.qw.qw.vvv.qw;
import java.util.List;

/* renamed from: fe.qw.qw.switch.uk.rg  reason: invalid package */
public class rg implements AnimatableValue<PointF, PointF> {
    public final List<qw<PointF>> qw;

    public rg(List<qw<PointF>> list) {
        this.qw = list;
    }

    public List<qw<PointF>> ad() {
        return this.qw;
    }

    public boolean de() {
        return this.qw.size() == 1 && this.qw.get(0).uk();
    }

    public BaseKeyframeAnimation<PointF, PointF> qw() {
        if (this.qw.get(0).uk()) {
            return new i(this.qw);
        }
        return new uk(this.qw);
    }
}
