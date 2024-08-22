package fe.qw.qw.pf.de;

import fe.qw.qw.ggg.th;
import fe.qw.qw.vvv.de;
import fe.qw.qw.vvv.qw;
import java.util.List;

public class fe extends rg<Integer> {
    public fe(List<qw<Integer>> list) {
        super(list);
    }

    public int ggg(qw<Integer> qwVar, float f) {
        if (qwVar.f3525ad == null || qwVar.f3526de == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        de<A> deVar = this.f569rg;
        if (deVar != null) {
            Integer num = (Integer) deVar.ad(qwVar.f3531rg, qwVar.f3532th.floatValue(), qwVar.f3525ad, qwVar.f3526de, f, rg(), th());
            if (num != null) {
                return num.intValue();
            }
        }
        return th.m230if(qwVar.yj(), qwVar.fe(), f);
    }

    public int ppp() {
        return ggg(ad(), fe());
    }

    /* renamed from: vvv */
    public Integer i(qw<Integer> qwVar, float f) {
        return Integer.valueOf(ggg(qwVar, f));
    }
}
