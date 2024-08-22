package fe.fe.o.qw;

import com.baidu.down.a.e;
import com.baidu.down.a.h;
import fe.fe.o.th.ggg;
import java.util.List;

public class th implements e {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ rg f2594ad;
    public final /* synthetic */ Exception qw;

    public th(rg rgVar, Exception exc) {
        this.f2594ad = rgVar;
        this.qw = exc;
    }

    public void qw(boolean z, fe.fe.o.rg.de.th thVar, int i2) {
        boolean unused = this.f2594ad.f2586de = false;
        if (z) {
            fe.fe.o.rg.de.th unused2 = this.f2594ad.f2590rg = thVar;
            rg rgVar = this.f2594ad;
            List unused3 = rgVar.f2591th = rgVar.f2590rg.ad(this.f2594ad.f2585ad.ggg, this.qw);
        }
        if (ggg.th(this.f2594ad.f2591th)) {
            z = false;
        }
        rg rgVar2 = this.f2594ad;
        if (z) {
            i2 = 1;
        }
        int unused4 = rgVar2.f2588i = i2;
        for (int i3 = 0; i3 < this.f2594ad.f2587fe.size(); i3++) {
            ((h) this.f2594ad.f2587fe.get(i3)).a(z);
        }
        this.f2594ad.f2587fe.clear();
    }
}
