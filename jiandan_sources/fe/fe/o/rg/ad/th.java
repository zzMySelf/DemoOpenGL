package fe.fe.o.rg.ad;

import android.content.Context;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import fe.fe.o.fe.qw.de.Cswitch;
import fe.fe.o.fe.qw.de.o;
import fe.fe.o.rg.de.i;
import java.util.TreeSet;

public class th implements OnFetchDataRequestListener {
    public final /* synthetic */ rg qw;

    public th(rg rgVar) {
        this.qw = rgVar;
    }

    public void qw(boolean z, TreeSet treeSet) {
        o oVar;
        fe.fe.o.rg.de.th mmm;
        boolean unused = this.qw.G = true;
        if (!z || ((mmm = i.ad((Context) null).qw().mmm()) != null && mmm.de(this.qw.f82switch))) {
            oVar = this.qw.f2601i;
        } else {
            rg rgVar = this.qw;
            if ((rgVar.r & 1) == 1) {
                if (!rgVar.H) {
                    this.qw.tt(mmm);
                } else if (treeSet != null) {
                    TreeSet unused2 = this.qw.F = treeSet;
                }
                ((Cswitch) this.qw.f2601i).s(true);
                this.qw.uk();
            }
            oVar = rgVar.f2601i;
        }
        ((Cswitch) oVar).s(false);
        ((Cswitch) this.qw.f2601i).f80switch.f2447pf = 0;
        this.qw.uk();
    }
}
