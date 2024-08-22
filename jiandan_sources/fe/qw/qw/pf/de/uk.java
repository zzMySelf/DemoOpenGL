package fe.qw.qw.pf.de;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import fe.qw.qw.vvv.de;
import fe.qw.qw.vvv.qw;
import java.util.List;

public class uk extends rg<PointF> {

    /* renamed from: i  reason: collision with root package name */
    public final PointF f3377i = new PointF();

    /* renamed from: if  reason: not valid java name */
    public PathMeasure f108if = new PathMeasure();

    /* renamed from: o  reason: collision with root package name */
    public final float[] f3378o = new float[2];

    /* renamed from: pf  reason: collision with root package name */
    public yj f3379pf;

    public uk(List<? extends qw<PointF>> list) {
        super(list);
    }

    /* renamed from: ppp */
    public PointF i(qw<PointF> qwVar, float f) {
        yj yjVar = (yj) qwVar;
        Path o2 = yjVar.o();
        if (o2 == null) {
            return (PointF) qwVar.f3525ad;
        }
        de<A> deVar = this.f569rg;
        if (deVar != null) {
            PointF pointF = (PointF) deVar.ad(yjVar.f3531rg, yjVar.f3532th.floatValue(), yjVar.f3525ad, yjVar.f3526de, rg(), f, th());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.f3379pf != yjVar) {
            this.f108if.setPath(o2, false);
            this.f3379pf = yjVar;
        }
        PathMeasure pathMeasure = this.f108if;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.f3378o, (float[]) null);
        PointF pointF2 = this.f3377i;
        float[] fArr = this.f3378o;
        pointF2.set(fArr[0], fArr[1]);
        return this.f3377i;
    }
}
