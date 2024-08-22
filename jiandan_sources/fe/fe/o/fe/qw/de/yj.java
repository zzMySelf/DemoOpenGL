package fe.fe.o.fe.qw.de;

import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import java.util.TreeSet;

public class yj implements OnFetchDataRequestListener {
    public final /* synthetic */ rg qw;

    public yj(rg rgVar) {
        this.qw = rgVar;
    }

    public void qw(boolean z, TreeSet treeSet) {
        if (z) {
            rg rgVar = this.qw;
            ((Cswitch) rgVar.f2552ad).v(rgVar.vvv, this.qw);
        }
        synchronized (this.qw.f2555pf) {
            this.qw.f2555pf.notify();
        }
    }
}
