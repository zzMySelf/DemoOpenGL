package fe.qw.qw.pf.de;

import fe.qw.qw.ggg.ad;
import fe.qw.qw.ggg.th;
import fe.qw.qw.vvv.de;
import java.util.List;

public class qw extends rg<Integer> {
    public qw(List<fe.qw.qw.vvv.qw<Integer>> list) {
        super(list);
    }

    public int ggg(fe.qw.qw.vvv.qw<Integer> qwVar, float f) {
        T t = qwVar.f3525ad;
        if (t == null || qwVar.f3526de == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) t).intValue();
        int intValue2 = ((Integer) qwVar.f3526de).intValue();
        de<A> deVar = this.f569rg;
        if (deVar != null) {
            Integer num = (Integer) deVar.ad(qwVar.f3531rg, qwVar.f3532th.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, rg(), th());
            if (num != null) {
                return num.intValue();
            }
        }
        return ad.de(th.de(f, 0.0f, 1.0f), intValue, intValue2);
    }

    public int ppp() {
        return ggg(ad(), fe());
    }

    /* renamed from: vvv */
    public Integer i(fe.qw.qw.vvv.qw<Integer> qwVar, float f) {
        return Integer.valueOf(ggg(qwVar, f));
    }
}
