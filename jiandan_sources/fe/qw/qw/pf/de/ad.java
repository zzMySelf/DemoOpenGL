package fe.qw.qw.pf.de;

import fe.qw.qw.ggg.th;
import fe.qw.qw.vvv.de;
import fe.qw.qw.vvv.qw;
import java.util.List;

public class ad extends rg<Float> {
    public ad(List<qw<Float>> list) {
        super(list);
    }

    public float ggg(qw<Float> qwVar, float f) {
        if (qwVar.f3525ad == null || qwVar.f3526de == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        de<A> deVar = this.f569rg;
        if (deVar != null) {
            Float f2 = (Float) deVar.ad(qwVar.f3531rg, qwVar.f3532th.floatValue(), qwVar.f3525ad, qwVar.f3526de, f, rg(), th());
            if (f2 != null) {
                return f2.floatValue();
            }
        }
        return th.pf(qwVar.th(), qwVar.de(), f);
    }

    public float ppp() {
        return ggg(ad(), fe());
    }

    /* renamed from: vvv */
    public Float i(qw<Float> qwVar, float f) {
        return Float.valueOf(ggg(qwVar, f));
    }
}
