package fe.qw.qw.pf.de;

import fe.qw.qw.ggg.th;
import fe.qw.qw.vvv.de;
import fe.qw.qw.vvv.fe;
import fe.qw.qw.vvv.qw;
import java.util.List;

public class o extends rg<fe> {

    /* renamed from: i  reason: collision with root package name */
    public final fe f3371i = new fe();

    public o(List<qw<fe>> list) {
        super(list);
    }

    /* renamed from: ppp */
    public fe i(qw<fe> qwVar, float f) {
        T t;
        T t2 = qwVar.f3525ad;
        if (t2 == null || (t = qwVar.f3526de) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        fe feVar = (fe) t2;
        fe feVar2 = (fe) t;
        de<A> deVar = this.f569rg;
        if (deVar != null) {
            fe feVar3 = (fe) deVar.ad(qwVar.f3531rg, qwVar.f3532th.floatValue(), feVar, feVar2, f, rg(), th());
            if (feVar3 != null) {
                return feVar3;
            }
        }
        this.f3371i.fe(th.pf(feVar.ad(), feVar2.ad(), f), th.pf(feVar.de(), feVar2.de(), f));
        return this.f3371i;
    }
}
