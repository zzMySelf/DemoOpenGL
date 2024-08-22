package fe.qw.qw.pf.de;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import fe.qw.qw.ggg.th;
import fe.qw.qw.p009switch.i.yj;
import fe.qw.qw.vvv.qw;
import java.util.List;

public class pf extends BaseKeyframeAnimation<yj, Path> {

    /* renamed from: i  reason: collision with root package name */
    public final yj f3372i = new yj();

    /* renamed from: o  reason: collision with root package name */
    public final Path f3373o = new Path();

    public pf(List<qw<yj>> list) {
        super(list);
    }

    /* renamed from: ppp */
    public Path i(qw<yj> qwVar, float f) {
        this.f3372i.de((yj) qwVar.f3525ad, (yj) qwVar.f3526de, f);
        th.i(this.f3372i, this.f3373o);
        return this.f3373o;
    }
}
