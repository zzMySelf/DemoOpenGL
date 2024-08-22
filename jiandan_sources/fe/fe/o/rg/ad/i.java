package fe.fe.o.rg.ad;

import android.content.Context;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import fe.fe.o.fe.qw.de.Cswitch;
import fe.fe.o.th.ggg;
import java.util.TreeSet;

public class i implements OnFetchDataRequestListener {
    public final /* synthetic */ rg qw;

    public i(rg rgVar) {
        this.qw = rgVar;
    }

    public void qw(boolean z, TreeSet treeSet) {
        rg rgVar = this.qw;
        if (z) {
            if ((rgVar.r & 1) == 1) {
                if (rgVar.H) {
                    if (treeSet != null) {
                        TreeSet unused = this.qw.F = treeSet;
                    }
                    ((Cswitch) this.qw.f2601i).u(true);
                } else {
                    this.qw.tt(fe.fe.o.rg.de.i.ad((Context) null).qw().mmm());
                }
                ((Cswitch) this.qw.f2601i).s(true);
                if (((Cswitch) this.qw.f2601i).A()) {
                    ((Cswitch) this.qw.f2601i).f(1);
                }
            } else {
                ((Cswitch) rgVar.f2601i).s(false);
            }
            rg rgVar2 = this.qw;
            ((Cswitch) rgVar2.f2601i).f80switch.f2444fe = ggg.qw(rgVar2.f82switch);
        } else {
            ((Cswitch) rgVar.f2601i).s(false);
        }
        for (int i2 = 0; i2 < this.qw.O.size(); i2++) {
            ((OnFetchDataRequestListener) this.qw.O.get(i2)).qw(z, treeSet);
        }
        this.qw.O.clear();
        boolean unused2 = this.qw.P = false;
    }
}
