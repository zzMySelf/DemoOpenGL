package fe.qw.qw.pf.de;

import android.graphics.PointF;
import fe.qw.qw.vvv.de;
import fe.qw.qw.vvv.qw;
import java.util.List;

public class i extends rg<PointF> {

    /* renamed from: i  reason: collision with root package name */
    public final PointF f3367i = new PointF();

    public i(List<qw<PointF>> list) {
        super(list);
    }

    /* renamed from: ppp */
    public PointF i(qw<PointF> qwVar, float f) {
        T t;
        T t2 = qwVar.f3525ad;
        if (t2 == null || (t = qwVar.f3526de) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) t2;
        PointF pointF2 = (PointF) t;
        de<A> deVar = this.f569rg;
        if (deVar != null) {
            PointF pointF3 = (PointF) deVar.ad(qwVar.f3531rg, qwVar.f3532th.floatValue(), pointF, pointF2, f, rg(), th());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        PointF pointF4 = this.f3367i;
        float f2 = pointF.x;
        float f3 = pointF.y;
        pointF4.set(f2 + ((pointF2.x - f2) * f), f3 + (f * (pointF2.y - f3)));
        return this.f3367i;
    }
}
