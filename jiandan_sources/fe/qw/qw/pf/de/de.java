package fe.qw.qw.pf.de;

import fe.qw.qw.p009switch.i.ad;
import fe.qw.qw.vvv.qw;
import java.util.List;

public class de extends rg<ad> {

    /* renamed from: i  reason: collision with root package name */
    public final ad f3366i;

    public de(List<qw<ad>> list) {
        super(list);
        int i2 = 0;
        ad adVar = (ad) list.get(0).f3525ad;
        i2 = adVar != null ? adVar.de() : i2;
        this.f3366i = new ad(new float[i2], new int[i2]);
    }

    /* renamed from: ppp */
    public ad i(qw<ad> qwVar, float f) {
        this.f3366i.fe((ad) qwVar.f3525ad, (ad) qwVar.f3526de, f);
        return this.f3366i;
    }
}
